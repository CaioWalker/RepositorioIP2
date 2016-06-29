package br.ufrpe.cj.exceptions;

public class DiscNomeNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public DiscNomeNExisteException(String nome){
		super("Nao existe uma disciplina "+nome+".");
		this.nome =nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	
}
