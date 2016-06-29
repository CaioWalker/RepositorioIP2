package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Aula;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.dados.IRepositorioDisciplina;
import br.ufrpe.cj.exceptions.ChoqueHorarioDiscException;
import br.ufrpe.cj.exceptions.DiscNomeNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaJaExisteException;
import br.ufrpe.cj.exceptions.DisciplinaNExisteException;
import br.ufrpe.cj.exceptions.SemDiscException;
import br.ufrpe.cj.exceptions.SemDiscSemAulaException;

public class CadastrarDisciplina {
	private IRepositorioDisciplina repositorioDisciplina;
	
	public CadastrarDisciplina(IRepositorioDisciplina instanciaRepositorio){
		this.repositorioDisciplina = instanciaRepositorio;
	}

	public void cadastrarDisciplina(String nome, String descricao, Curso curso)throws DisciplinaJaExisteException{
		this.repositorioDisciplina.cadastrar(nome,descricao,curso);
		this.repositorioDisciplina.salvarArquivo();
	}
	
	public Disciplina procurarDisciplinaCodigo(String codigo) throws DisciplinaCodigoNExisteException{
		return this.repositorioDisciplina.procurarCodigo(codigo);
	}
	
	public Disciplina procurarDisciplinaNome(String nome) throws DiscNomeNExisteException{
		return this.repositorioDisciplina.procurarNome(nome);
	}
	
	public ArrayList<Disciplina> disciplinasCurso(Curso c) throws SemDiscException{
		if(this.repositorioDisciplina.disciplinasCurso(c).size()==0){
			throw new SemDiscException();
		}
		
		return this.repositorioDisciplina.disciplinasCurso(c);
	}
	
	public ArrayList<Disciplina> disciplinasSemAula(Curso c) throws SemDiscSemAulaException{
		if(this.repositorioDisciplina.disciplinasSemAula(c).size()==0){
			throw new SemDiscSemAulaException();
		}
		
		return this.repositorioDisciplina.disciplinasSemAula(c);
	}
	
	public void removerDisciplina(Disciplina d) throws DisciplinaNExisteException{
		this.repositorioDisciplina.remover(d);
		this.repositorioDisciplina.salvarArquivo();

	}
	
	public void addAulaDisciplina(String codigo,Aula a) throws ChoqueHorarioDiscException, DisciplinaCodigoNExisteException{
		this.repositorioDisciplina.procurarCodigo(codigo).addAula(a);
		this.repositorioDisciplina.salvarArquivo();
	}

	
	
	
	
	
	
}
