package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Curso;

public class CoordenadorCursoSetadoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Curso curso;

	public CoordenadorCursoSetadoException(Curso c){
		super("O curso "+c.getNome()+" ja possui um coordenador.");
		this.curso=c;
	}
	
	public Curso getCurso() {
		return curso;
	}

}
