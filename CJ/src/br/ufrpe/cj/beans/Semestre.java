package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Semestre implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	
	public Semestre(String descricao){
		this.setDescricao(descricao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
		
	public String toString(){
		String resultado="Semestre: "+this.nome;
		return resultado;
	}
	
	public Boolean equals(Semestre s){
		if(s!=null){
			if(s.getNome().equals(this.nome)&&s.getDescricao().equals(this.descricao)){
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


