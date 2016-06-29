package br.ufrpe.cj.exceptions;

public class ChoqueHorarioDiscException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChoqueHorarioDiscException(){
		super("Esta disciplina já contem uma aula neste horario.");
	}

}
