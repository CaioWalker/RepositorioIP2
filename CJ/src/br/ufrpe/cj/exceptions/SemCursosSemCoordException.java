package br.ufrpe.cj.exceptions;

public class SemCursosSemCoordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SemCursosSemCoordException(){
		super("A base de dados nao contem cursos sem coordenador.");
	}

}
