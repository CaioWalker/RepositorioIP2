package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;

public class DisciplinaNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Disciplina disciplina;

	public DisciplinaNExisteException(Disciplina d){
		super("A disciplina "+d.getNome()+" nao pertence a base de dados.");
		this.disciplina = d;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}	
	
}
