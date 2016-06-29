package br.ufrpe.cj.beans;

import java.io.Serializable;

public class AreasInt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String descricao;
	
	public AreasInt(String titulo, String descricao){
		this.setTitulo(titulo);
		this.setDescricao(descricao);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String toString(){
		String resultado ="\n"+this.titulo+"\n"+this.descricao;
		return resultado;
	}
	
	

}
