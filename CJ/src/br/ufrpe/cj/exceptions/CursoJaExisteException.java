package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Curso;

public class CursoJaExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Curso curso;
	
	public CursoJaExisteException(Curso c){
		super("Ja existe um curso "+ c.getNome()+".");
		this.curso = c;
	}
	
	public Curso getCurso(){
		return this.curso;
	}

}
