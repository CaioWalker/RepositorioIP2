package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Semestre;

public class CursoSemAlocValidaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Curso curso;
	private Semestre semestre;
	
	public CursoSemAlocValidaException(Curso c, Semestre s){
		super("O curso "+c.getNome()+" nao contem alocacoes validas no semestre "+s.getNome()+".");
		this.curso=c;
		this.semestre=s;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public Semestre getSemestre() {
		return semestre;
	}

}
