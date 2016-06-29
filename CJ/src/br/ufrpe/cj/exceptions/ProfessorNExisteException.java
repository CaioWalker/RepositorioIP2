package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class ProfessorNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	
	public ProfessorNExisteException(Professor p){
		super("O professor"+p.getNome()+" nao pertence a base de dados.");
		this.professor = p;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	

	
	
}
