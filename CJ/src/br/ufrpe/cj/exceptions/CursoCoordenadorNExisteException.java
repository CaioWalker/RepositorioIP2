package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class CursoCoordenadorNExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;

	public CursoCoordenadorNExisteException(Professor p){
		super("Nao existe um curso com o coordenador "+p.getNome()+".");
		this.professor =p;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}
	

}
