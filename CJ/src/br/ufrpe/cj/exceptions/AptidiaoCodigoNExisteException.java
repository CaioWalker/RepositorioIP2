package br.ufrpe.cj.exceptions;

public class AptidiaoCodigoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;

	public AptidiaoCodigoNExisteException(String codigo){
		super("Nao existe uma aptidiao referente ao codigo: "+codigo+".");
		this.codigo =codigo;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

	

}
