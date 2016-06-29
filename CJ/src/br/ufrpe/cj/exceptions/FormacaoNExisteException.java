package br.ufrpe.cj.exceptions;

public class FormacaoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FormacaoNExisteException(){
		super("Esta formacao nao pertence a base de dados.");
	}

}
