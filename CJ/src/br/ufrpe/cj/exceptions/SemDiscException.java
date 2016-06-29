package br.ufrpe.cj.exceptions;

public class SemDiscException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SemDiscException(){
		super("A base de dados deste curso nao contem disciplinas.");
	}

}
