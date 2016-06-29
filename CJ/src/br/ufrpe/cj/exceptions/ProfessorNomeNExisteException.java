package br.ufrpe.cj.exceptions;

public class ProfessorNomeNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;

	public ProfessorNomeNExisteException(String nome){
		super("Nao existe um professor referente ao nome: "+nome+".");
		this.nome =nome;
	}
	
	public String getNome() {
		return nome;
	}

	

}