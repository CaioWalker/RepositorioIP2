package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class ProfessorJaCadastradoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	
	public ProfessorJaCadastradoException(Professor p){
		super("Ja existe um professor cadastrado na base de dados com o cpf "+p.getCpf()+".");
		this.professor = p;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	
	

}
