package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;

public class AptidaoNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;
	private Disciplina disciplina;
	
	public AptidaoNExisteException(Professor p, Disciplina d){
		super("Nao existe uma aptidao referente ao professor "+p.getNome()+" e a disciplina "+d.getNome()+".");
		this.professor=p;
		this.disciplina=d;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}


}
