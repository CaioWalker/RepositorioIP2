package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;

public class DisciplinaSemAptosException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Disciplina disciplina;
	
	public DisciplinaSemAptosException(Disciplina d){
		super("A disciplina "+d.getNome()+" nao contem professores aptos cadastrados.");
		this.disciplina=d;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

}
