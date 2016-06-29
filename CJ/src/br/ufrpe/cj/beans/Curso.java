package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Curso implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private Professor coordenador;	
	private String codigo;
	
	public Curso(String nome,String descricao){
		this.setNome(nome);
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
	
	public void setNomeDescricao(String nome,String descricao){
		this.nome=nome;
		this.descricao=descricao;
	}
	
	
	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}
	
	
	
	public String toString(){
		String resultado;
		if(this.coordenador!=null){
			resultado ="\nNome: "+this.nome+"\nCoordenador: "+this.coordenador.getNome()
			+"\nDescricao: "+this.descricao;
		}
		else{
			resultado ="\nNome: "+this.nome+"\nCoordenador: indefinido"+"\nDescricao: "+this.descricao;
		}
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Boolean equals(Curso c){
		if(c!=null){
			if(c.getNome().equals(this.nome)&&c.getCodigo().equals(this.codigo)&&c.getCoordenador().equals(this.coordenador)&&c.getDescricao().equals(this.descricao)){
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
