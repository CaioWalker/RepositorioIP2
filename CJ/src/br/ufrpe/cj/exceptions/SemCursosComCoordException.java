package br.ufrpe.cj.exceptions;

public class SemCursosComCoordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SemCursosComCoordException(){
		super("A base de dados nao contem cursos com coordenador.");
	}

}
