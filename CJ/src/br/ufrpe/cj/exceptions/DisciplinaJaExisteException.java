package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Disciplina;

public class DisciplinaJaExisteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Disciplina disciplina;
	
	public DisciplinaJaExisteException(Disciplina d){
		super("Ja existe uma disciplina "+d.getNome()+" com a mesma descricao cadastrada no curso "+d.getCurso().getNome()+".");
		this.disciplina = d;
	}
	
	public Disciplina getDisciplina(){
		return this.disciplina;
	}

}
