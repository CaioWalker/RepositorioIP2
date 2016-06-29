package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Semestre;

public class DisciplinaSemAlocException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Disciplina disciplina;
	private Semestre semestre;
	
	public DisciplinaSemAlocException(Disciplina d, Semestre s){
		super("O disciplina "+d.getNome()+" nao contem alocacoes no semestre "+s.getNome()+".");
		this.disciplina=d;
		this.semestre = s;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

}
