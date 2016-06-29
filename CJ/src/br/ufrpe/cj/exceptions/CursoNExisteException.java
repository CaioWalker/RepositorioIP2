package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Curso;

public class CursoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Curso curso;

	public CursoNExisteException(Curso c){
		super("O curso "+c.getNome()+" nao pertence a base de dados.");
		this.curso=c;
	}
	
	public Curso getCurso() {
		return curso;
	}

	
	
	

}
