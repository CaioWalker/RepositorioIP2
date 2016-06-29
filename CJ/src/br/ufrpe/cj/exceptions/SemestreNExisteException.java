package br.ufrpe.cj.exceptions;

public class SemestreNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public SemestreNExisteException(String nome){
		super("O semestre "+nome+" nao pertence a base de dados.");
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	

}
