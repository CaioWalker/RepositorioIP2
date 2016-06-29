package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class HrInicioDentrodeUmaAulaException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	
	public HrInicioDentrodeUmaAulaException(Professor professor){
		super("Esta Disciplina contem uma aula que começa no meio de uma aula a qual o professor "+professor.getNome()+" esta alocado.");
		this.professor = professor;
	}

	public Professor getProfessor() {
		return professor;
	}

}
