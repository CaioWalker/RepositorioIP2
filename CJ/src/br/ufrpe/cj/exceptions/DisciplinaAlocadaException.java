package br.ufrpe.cj.exceptions;

public class DisciplinaAlocadaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DisciplinaAlocadaException(){
		super("Esta disciplina foi alocada a outro professor no semestre corrente.");
	}
	
	
}
