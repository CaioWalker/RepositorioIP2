package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.AlocProfDisc;

public class AlocacaoJaExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AlocProfDisc aloc;
	
	public AlocacaoJaExisteException(AlocProfDisc aloc){
		super("Ja existe uma alocacao referente ao professor "+ aloc.getProfessor().getNome()+" e a disciplina "+aloc.getDisciplina().getNome()+" no semestre corrente.");
		this.aloc = aloc;
	}
	
	public AlocProfDisc getAloc(){
		return this.aloc;
	}
	

}
