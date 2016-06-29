package br.ufrpe.cj.exceptions;

public class CursoNomeNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public CursoNomeNExisteException(String nome){
		super("Nao existe um curso "+nome+".");
		this.nome =nome;
	}
	
	
	public String getNome() {
		return nome;
	}
	

}
