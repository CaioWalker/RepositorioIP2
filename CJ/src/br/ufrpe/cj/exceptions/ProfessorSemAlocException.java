package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;

public class ProfessorSemAlocException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private Semestre semestre;
	
	public ProfessorSemAlocException(Professor p, Semestre s){
		super("O professor "+p.getNome()+" nao contem alocacoes no semestre "+s.getNome()+".");
		this.professor = p;
		this.semestre = s;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Semestre getSemestre() {
		return semestre;
	}


}
