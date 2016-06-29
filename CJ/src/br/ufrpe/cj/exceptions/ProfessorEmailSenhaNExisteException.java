package br.ufrpe.cj.exceptions;

public class ProfessorEmailSenhaNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProfessorEmailSenhaNExisteException(){
		super("Email ou senha incorretos.");
	}

}
