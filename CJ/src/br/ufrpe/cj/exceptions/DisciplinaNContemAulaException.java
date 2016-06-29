package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;

public class DisciplinaNContemAulaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Disciplina disciplina;
	
	public DisciplinaNContemAulaException(Disciplina d){
		super("A Disciplina "+d.getNome()+" nao contem aulas setadas.");
		this.disciplina = d;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	

}
