package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;

public class ProfessorNAptoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private Disciplina disciplina;
	
	public ProfessorNAptoException(Professor p, Disciplina d){
		super("O professor "+p.getNome()+" nao está apto a lecionar a disciplina "+d.getNome()+".");
		this.professor = p;
		this.disciplina=d;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}


}
