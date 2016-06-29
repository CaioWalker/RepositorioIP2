package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class ProfessorNCoodenadorException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;

	public ProfessorNCoodenadorException(Professor p){
		super("O professor "+p.getNome()+" nao e um coordenador.");
		this.professor=p;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	
	

}
