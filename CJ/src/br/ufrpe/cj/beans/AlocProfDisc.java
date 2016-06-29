package br.ufrpe.cj.beans;

import java.io.Serializable;

public class AlocProfDisc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private Disciplina disciplina;
	private Semestre semestre;
	private Boolean validacao;
	private String codigo;
	
	public AlocProfDisc(Professor professor, Disciplina disciplina, Semestre semestre){
		this.professor=professor;
		this.disciplina=disciplina;
		this.semestre=semestre;
		this.validacao=false;
	}

	public Professor getProfessor() {
		return professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public Boolean getValidacao() {
		return validacao;
	}

	public void setValidacao(Boolean validacao) {
		this.validacao = validacao;
	}
	
	public String toString(){
		String validacao;
		if(this.validacao){
			validacao = "OK";
		}
		else{
			validacao = "Pendente";
		}
		String resultado=this.disciplina.getNome()+" Professor: "+this.professor.getNome()+" Codigo: "+this.getCodigo()+" "+validacao;
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Boolean equals(AlocProfDisc aloc){
		if(aloc!=null){
			if(aloc.getProfessor().equals(this.professor)&&aloc.getSemestre().equals(this.semestre)&&aloc.getDisciplina().equals(this.disciplina)&&aloc.getCodigo().equals(this.codigo)){
				return true;
			}
			else{
				return false;
			} 	
		}
		else{
			return false;
		}
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

}
