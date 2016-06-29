package br.ufrpe.cj.exceptions;

public class DisciplinaCodigoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;

	public DisciplinaCodigoNExisteException(String codigo){
		super("Nao existe uma disciplina referente ao codigo: "+codigo+".");
		this.codigo =codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}


	
	
	

}
