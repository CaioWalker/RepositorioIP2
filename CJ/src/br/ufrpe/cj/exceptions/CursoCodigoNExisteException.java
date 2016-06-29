package br.ufrpe.cj.exceptions;

public class CursoCodigoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String codigo;

	public CursoCodigoNExisteException(String codigo){
		super("Nao existe um curso referente ao codigo: "+codigo+".");
		this.codigo =codigo;
	}
	
	
	public String getCodigo() {
		return codigo;
	}

}
