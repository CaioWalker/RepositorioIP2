package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Semestre;

public class SemestreSemAlocException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Semestre semestre;
	
	public SemestreSemAlocException(Semestre s){
		super("O semestre "+s.getNome()+" nao contem alocacoes na base de dados.");
		this.semestre=s;
	}
	
	public Semestre getSemestre() {
		return semestre;
	}

	

}
