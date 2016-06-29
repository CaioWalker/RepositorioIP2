package br.ufrpe.cj.exceptions;

import br.ufrpe.cj.beans.Apto;

public class AptidaoJaCadastradaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Apto aptidao;

	public AptidaoJaCadastradaException(Apto aptidao){
		super("O professor "+aptidao.getProfessor().getNome()+"ja contem esta aptidao cadastrada.");
		
	}
	
	public Apto getAptidao() {
		return aptidao;
	}

	
	

}
