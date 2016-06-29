package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Apto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Professor professor;
	private Disciplina disciplina;
	private Boolean validacao;
	private String codigo;
	
	public Apto(Professor professor, Disciplina disciplina){
		this.professor=professor;
		this.disciplina=disciplina;
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
		
		String resultado=this.disciplina.getNome()+" --> Professor: "+this.professor.getNome()+" Codigo: "+this.getCodigo()+" "+validacao;
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Boolean equals(Apto cadas){
		if(cadas!=null){
			if(cadas.getProfessor().equals(this.professor)&&cadas.getDisciplina().equals(this.disciplina)&&cadas.getCodigo().equals(this.codigo)){
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

}

