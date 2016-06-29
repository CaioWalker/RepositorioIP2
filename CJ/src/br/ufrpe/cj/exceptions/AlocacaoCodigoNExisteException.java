package br.ufrpe.cj.exceptions;

public class AlocacaoCodigoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;

	public AlocacaoCodigoNExisteException(String codigo){
		super("Nao existe uma alocacao referente ao codigo: "+codigo+".");
		this.codigo =codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

}
