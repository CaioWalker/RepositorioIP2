package br.ufrpe.cj.exceptions;

public class SemDiscSemAulaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SemDiscSemAulaException(){
		super("A base de dados deste curso nao contem disciplinas sem aula.");
	}
	

}
