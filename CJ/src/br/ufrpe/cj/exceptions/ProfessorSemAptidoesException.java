package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class ProfessorSemAptidoesException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;

	public ProfessorSemAptidoesException(Professor p){
		super("O professor "+p.getNome()+" nao contem aptidoes cadastradas.");
		this.professor=p;
	}
	
	public Professor getProfessor() {
		return professor;
	}


}
