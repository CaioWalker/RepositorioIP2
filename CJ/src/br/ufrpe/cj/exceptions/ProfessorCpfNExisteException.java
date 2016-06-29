package br.ufrpe.cj.exceptions;

public class ProfessorCpfNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String cpf;

	public ProfessorCpfNExisteException(String cpf){
		super("Nao existe um professor referente ao cpf: "+cpf+".");
		this.cpf =cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	

}
