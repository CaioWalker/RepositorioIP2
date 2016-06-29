package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Formacao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titulo;
	private String descricao;
	private Boolean estado;
	private String codigo;
	
	public Formacao(String titulo, String descricao){
		this.setTitulo(titulo);
		this.setDescricao(descricao);
		this.setEstado(false);
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

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String toString(){
		String resultado = "\nTitulo: "+this.titulo+"\n"+this.descricao;
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
