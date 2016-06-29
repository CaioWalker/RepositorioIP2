package br.ufrpe.cj.exceptions;

public class NoValidacoesAptoPendentes extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoValidacoesAptoPendentes(){
		super("Nao existe aptidao com validacao pendente na base de dados.");
	}
	

}
