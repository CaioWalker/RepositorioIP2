package br.ufrpe.cj.exceptions;

public class ProfessorEmailNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String email;

	public ProfessorEmailNExisteException(String email){
		super("Nao existe um professor referente ao email: "+email+".");
		this.email =email;
	}
	
	public String getEmail() {
		return email;
	}
	
}