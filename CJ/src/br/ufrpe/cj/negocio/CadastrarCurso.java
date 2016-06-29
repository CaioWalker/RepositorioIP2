package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.dados.IRepositorioCurso;
import br.ufrpe.cj.exceptions.CoordenadorCursoSetadoException;
import br.ufrpe.cj.exceptions.CoordenadorOcupado;
import br.ufrpe.cj.exceptions.CursoCodigoNExisteException;
import br.ufrpe.cj.exceptions.CursoCoordenadorNExisteException;
import br.ufrpe.cj.exceptions.CursoJaExisteException;
import br.ufrpe.cj.exceptions.CursoNExisteException;
import br.ufrpe.cj.exceptions.CursoNomeNExisteException;
import br.ufrpe.cj.exceptions.ProfessorNCoodenadorException;
import br.ufrpe.cj.exceptions.SemCursosComCoordException;
import br.ufrpe.cj.exceptions.SemCursosSemCoordException;

public class CadastrarCurso {
	
	private IRepositorioCurso repositorioCurso;
	
	public CadastrarCurso(IRepositorioCurso instanciaRepositorio){
		this.repositorioCurso=instanciaRepositorio;
	}
	
	public void cadastrarCurso(String nome, String descricao) throws CursoJaExisteException{
		this.repositorioCurso.cadastrar(nome, descricao);
	}

	public Curso procurarCursoCodigo(String codigo) throws CursoCodigoNExisteException{
		return this.repositorioCurso.procurarCodigo(codigo);
	}

	public Curso procurarCursoNome(String nome) throws CursoNomeNExisteException{
		return this.repositorioCurso.procurarNome(nome);
	}

	public void removerCurso(Curso c) throws CursoNExisteException {
		this.repositorioCurso.remover(c);
	}
	
	public void setCoodenadorCurso(Curso c, Professor p) throws ProfessorNCoodenadorException, CoordenadorOcupado, CoordenadorCursoSetadoException{
		if(p.getCoordenador()==false){
			throw new ProfessorNCoodenadorException(p);
		}
		
		if(c.getCoordenador()!=null){
			throw new CoordenadorCursoSetadoException(c);
		}
		
		boolean CoordenadorLivre = true;
		
		for(int i=0;i<this.repositorioCurso.cursosComCoordenador().size();i++){
			if(this.repositorioCurso.cursosComCoordenador().get(i).getCoordenador().equals(p)){
				CoordenadorLivre = false;
			}
		}
		
		if(CoordenadorLivre){
			c.setCoordenador(p);
			this.repositorioCurso.salvarArquivo();
		}
		else{
			throw new CoordenadorOcupado(p);
		}
		
	}

	public void removerCoodenadorCurso(Curso c) throws CursoCodigoNExisteException{
		this.repositorioCurso.procurarCodigo(c.getCodigo()).setCoordenador(null);
	}

	public ArrayList<Curso> cursosSemCoordenador() throws SemCursosSemCoordException{
		if(this.repositorioCurso.cursosSemCoordenador().size()==0){
			throw new SemCursosSemCoordException();
		}
		return this.repositorioCurso.cursosSemCoordenador();
	}
	
	public ArrayList<Curso> cursosComCoordenador() throws SemCursosComCoordException{
		if(this.repositorioCurso.cursosComCoordenador().size()==0){
			throw new SemCursosComCoordException();
		}
		return this.repositorioCurso.cursosComCoordenador();
	}
	
	public Curso procurarCursoCoordenador(Professor p) throws CursoCoordenadorNExisteException{
		return this.repositorioCurso.procurarCoordenador(p);
	}




}
