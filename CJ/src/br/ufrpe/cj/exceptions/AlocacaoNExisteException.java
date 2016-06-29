package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;

public class AlocacaoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private Disciplina disciplina;
	private Semestre semestre;
	
	public AlocacaoNExisteException(Professor p, Disciplina d, Semestre s){
		super("Nao existe uma alocacao referente ao professor "+p.getNome()+" e a disciplina "+d.getNome()+" no semestre "+s.getNome()+".");
		this.professor=p;
		this.disciplina=d;
		this.semestre=s;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Semestre getSemestre() {
		return semestre;
	}
	
	
	

}
