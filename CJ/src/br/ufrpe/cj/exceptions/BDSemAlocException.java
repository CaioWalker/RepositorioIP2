package br.ufrpe.cj.exceptions;

public class BDSemAlocException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BDSemAlocException(){
		super("A base de dados nao contem alocacao.");
	}

}
