package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.AlocProfDisc;
import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.dados.IRepositorioAlocProfDisc;
import br.ufrpe.cj.dados.IRepositorioApto;
import br.ufrpe.cj.dados.IRepositorioSemestre;
import br.ufrpe.cj.exceptions.AlocacaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.AlocacaoJaExisteException;
import br.ufrpe.cj.exceptions.AlocacaoNExisteException;
import br.ufrpe.cj.exceptions.BDSemAlocException;
import br.ufrpe.cj.exceptions.CursoSemAlocPendenteException;
import br.ufrpe.cj.exceptions.CursoSemAlocValidaException;
import br.ufrpe.cj.exceptions.DisciplinaAlocadaException;
import br.ufrpe.cj.exceptions.DisciplinaNContemAulaException;
import br.ufrpe.cj.exceptions.DisciplinaSemAlocException;
import br.ufrpe.cj.exceptions.HrInicioDentrodeUmaAulaException;
import br.ufrpe.cj.exceptions.HrInicioOcupadaException;
import br.ufrpe.cj.exceptions.ProfessorNAptoException;
import br.ufrpe.cj.exceptions.ProfessorSemAlocException;
import br.ufrpe.cj.exceptions.SemestreSemAlocException;

public class AlocarProfessorDisciplina{
	
	private IRepositorioAlocProfDisc repositorioAlocProfDisc;
	private IRepositorioSemestre repositorioSemestre;
	private IRepositorioApto repositorioApto;
	
	
	public AlocarProfessorDisciplina(IRepositorioAlocProfDisc repositorioAlocacoes, IRepositorioSemestre repositorioSemestres, IRepositorioApto repositorioAptidoes){
		this.repositorioAlocProfDisc = repositorioAlocacoes;
		this.repositorioSemestre = repositorioSemestres;
		this.repositorioApto = repositorioAptidoes;
	}
		
	public void alocarProfessorDisciplina(Professor p, Disciplina d) throws HrInicioOcupadaException, HrInicioDentrodeUmaAulaException, DisciplinaNContemAulaException, ProfessorNAptoException, AlocacaoJaExisteException{
		AlocProfDisc aloc = new AlocProfDisc(p,d,repositorioSemestre.getSemstreCorrente());
		boolean alocacaoOk = true;
		boolean professorApto = false;
		
		ArrayList<AlocProfDisc> alocacoesProf = repositorioAlocProfDisc.alocacoesProfessor(p, repositorioSemestre.getSemstreCorrente());
		ArrayList<Apto> aptidoesProfessor = repositorioApto.aptidoesProfessor(p);
		
		for(int i=0;i<aptidoesProfessor.size();i++){
			if(aptidoesProfessor.get(i).getValidacao()){
				professorApto = true;
			}
		}
		if(professorApto){
			if(d.getAulas().size()>0){
				for(int i=0;i<alocacoesProf.size();i++){
					for(int j=0;j<alocacoesProf.get(i).getDisciplina().getAulas().size();j++){
						for(int k=0;k<d.getAulas().size();k++){		
							if(alocacoesProf.get(i).getValidacao()==true&&alocacoesProf.get(i).getDisciplina().getAulas().get(j).getDiaSemana().equals(aloc.getDisciplina().getAulas().get(k).getDiaSemana())){
								
								if(alocacoesProf.get(i).getDisciplina().getAulas().get(j).getHrInicio().equals(aloc.getDisciplina().getAulas().get(k).getHrInicio())){
									alocacaoOk=false;
									throw new HrInicioOcupadaException(p,alocacoesProf.get(i).getDisciplina().getAulas().get(j).getHrInicio(),alocacoesProf.get(i).getDisciplina().getAulas().get(j).getDiaSemana());
									//Professor já está alocado a uma disciplina que contem 
									//uma aula que começa nesse horario. 
								}
								
								if(aloc.getDisciplina().getAulas().get(k).getHrInicio().isAfter(alocacoesProf.get(i).getDisciplina().getAulas().get(j).getHrInicio())&&
								aloc.getDisciplina().getAulas().get(k).getHrInicio().isBefore(alocacoesProf.get(i).getDisciplina().getAulas().get(j).getHrFim())){
									alocacaoOk=false;
									throw new HrInicioDentrodeUmaAulaException(p);
									//Esta Disciplina contem uma aula que começa
									//no meio de uma aula a qual o professor está alocado;
								}
							}
						}
					}
				}
			}
			
			else{
				//Disciplina n contem aulas cadastradas.
				throw new DisciplinaNContemAulaException(d);
			}
		}
		
		else{
			//Professor não está apto a lecionar esta disciplina.
			throw new ProfessorNAptoException(p,d);
		}
		
		
		if(alocacaoOk&&professorApto){
			repositorioAlocProfDisc.cadastrar(aloc);
			repositorioAlocProfDisc.salvarNoArquivo();
		}
		
	}
	
	public void removerAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException{
		AlocProfDisc aloc=null;
		if(repositorioAlocProfDisc.contemAlocacao(p, d, this.repositorioSemestre.getSemstreCorrente())){
			aloc = this.repositorioAlocProfDisc.getAlocacao(p, d, this.repositorioSemestre.getSemstreCorrente());
		}
		
		else{
			//não existe uma alocação referente a este professor e esta disciplina no semestre corrente.
			throw new AlocacaoNExisteException(p,d,this.repositorioSemestre.getSemstreCorrente());
		}
		
		repositorioAlocProfDisc.remover(aloc);
		p.addNotificacoes("Sua alocacao a disciplina "+d.getNome()+" foi reprovada pelo coordenador.");
		repositorioAlocProfDisc.salvarNoArquivo();
		
	}

	public void validarAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException, DisciplinaAlocadaException{
		AlocProfDisc aloc=null;
		boolean jaAlocada = false;
		if(repositorioAlocProfDisc.contemAlocacao(p, d, this.repositorioSemestre.getSemstreCorrente())){
			aloc = this.repositorioAlocProfDisc.getAlocacao(p, d, this.repositorioSemestre.getSemstreCorrente());
		}
		else{
			//não existe uma alocação referente a este professor e esta disciplina no semestre corrente.
			throw new AlocacaoNExisteException(p,d,this.repositorioSemestre.getSemstreCorrente());
		}
		
		for(int i=0;i<repositorioAlocProfDisc.alocacoesDisciplina(d, this.repositorioSemestre.getSemstreCorrente()).size();i++){
			if(repositorioAlocProfDisc.alocacoesDisciplina(d, this.repositorioSemestre.getSemstreCorrente()).get(i).getValidacao()==true){
				jaAlocada = true;
			}
		}
		
		if(jaAlocada){
			//Disciplina já contem uma alocação
			throw new DisciplinaAlocadaException();
		}
		aloc.setValidacao(true);
		p.addNotificacoes("Voce foi alocado a disciplina "+d.getNome()+".");
		repositorioAlocProfDisc.salvarNoArquivo();
	}
	
	public AlocProfDisc procurarAlocacaoCodigo(String codigo) throws AlocacaoCodigoNExisteException{
		return this.repositorioAlocProfDisc.procurarCodigo(codigo);
	}

	public AlocProfDisc getAlocacao(Professor p, Disciplina d, Semestre s) throws AlocacaoNExisteException{
		return this.repositorioAlocProfDisc.getAlocacao(p, d, s);
	}

	public ArrayList<AlocProfDisc> alocacoesProfessor(Professor p, Semestre s) throws ProfessorSemAlocException {
		if(this.repositorioAlocProfDisc.alocacoesProfessor(p, s).size()==0){
			throw new ProfessorSemAlocException(p,s);
		}
		return this.repositorioAlocProfDisc.alocacoesProfessor(p, s);
	}

	public ArrayList<AlocProfDisc> alocacoesDisciplina(Disciplina d, Semestre s) throws DisciplinaSemAlocException{
		if(this.repositorioAlocProfDisc.alocacoesDisciplina(d, s).size()==0){
			throw new DisciplinaSemAlocException(d,s);
		}
		return this.repositorioAlocProfDisc.alocacoesDisciplina(d, s);
	}

	public ArrayList<AlocProfDisc> alocacoesSemestre(Semestre s) throws SemestreSemAlocException{
		if(this.repositorioAlocProfDisc.alocacoesSemestre(s).size()==0){
			throw new SemestreSemAlocException(s);
		}
		return this.repositorioAlocProfDisc.alocacoesSemestre(s);
	}
	
	public ArrayList<AlocProfDisc> getAlocacoesPendentes(Curso c) throws CursoSemAlocPendenteException {
		if(this.repositorioAlocProfDisc.getValidacoesPendentes(c,this.repositorioSemestre.getSemstreCorrente()).size()==0){
			throw new CursoSemAlocPendenteException(c,this.repositorioSemestre.getSemstreCorrente());
		}
		
		return this.repositorioAlocProfDisc.getValidacoesPendentes(c,this.repositorioSemestre.getSemstreCorrente());
	}

	public ArrayList<AlocProfDisc> getAlocacoesValidas(Curso c, Semestre s) throws CursoSemAlocValidaException {
		if(this.repositorioAlocProfDisc.getAlocacoesValidas(c, this.repositorioSemestre.getSemstreCorrente()).size()==0){
			throw new CursoSemAlocValidaException(c,this.repositorioSemestre.getSemstreCorrente());
		}
		
		return this.repositorioAlocProfDisc.getAlocacoesValidas(c, this.repositorioSemestre.getSemstreCorrente());
	}

	public ArrayList<AlocProfDisc> getAlocacoes() throws BDSemAlocException{
		if(this.repositorioAlocProfDisc.getAlocacoes().size()==0){
			throw new BDSemAlocException();
		}
		return this.repositorioAlocProfDisc.getAlocacoes();
	}



}
