package br.ufrpe.cj.exceptions;

import java.io.Serializable;
import java.time.LocalTime;

import br.ufrpe.cj.beans.Professor;

public class HrInicioOcupadaException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private LocalTime HrInicio;
	private String diaSemana;
	
	public HrInicioOcupadaException(Professor professor, LocalTime HrInicio, String diaSemana){
		super("O professor "+professor.getNome()+" ja esta alocado a uma disciplina que contem uma aula que se inicia as "+HrInicio+" na "+diaSemana+".");
		this.professor = professor;
		this.HrInicio = HrInicio;
		this.diaSemana=diaSemana;
	}

	public Professor getProfessor() {
		return professor;
	}

	public LocalTime getHrInicio() {
		return HrInicio;
	}

	public String getDiaSemana() {
		return diaSemana;
	}



}
