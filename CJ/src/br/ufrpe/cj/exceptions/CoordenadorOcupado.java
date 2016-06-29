package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Professor;

public class CoordenadorOcupado extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Professor professor;

	public CoordenadorOcupado(Professor p){
		super("O Coordenador "+p.getNome()+" ja esta alocado a outro curso.");
		this.professor=p;
	}
	
	public Professor getProfessor() {
		return professor;
	}


}
