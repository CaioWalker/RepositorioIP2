package br.ufrpe.cj.exceptions;

public class NoFormPendentesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoFormPendentesException(){
		super("Nao existem professores com formacao pendente na base de dados.");
	}
}
