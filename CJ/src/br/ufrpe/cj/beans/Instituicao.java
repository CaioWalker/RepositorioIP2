package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Instituicao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private String endereco;
	
	public Instituicao(String nome,String descricao,String endereco){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setEndereco(endereco);
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	public String toString(){
		String resultado ="Instituicao: "+this.nome+"\n"+this.descricao+"\nEndereco: "+this.endereco;
		return resultado;
	}
	

}
