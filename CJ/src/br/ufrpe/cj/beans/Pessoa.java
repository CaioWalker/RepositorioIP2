package br.ufrpe.cj.beans;

import java.io.Serializable;

public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String senha;
	
	public Pessoa(String nome,String cpf,String endereco,String email,String senha){
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
		this.setEmail(email);
		this.senha=senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString(){
		String resultado ="\nNome: "+this.nome+" CPF: "+this.cpf+" Endereco: "+this.endereco+" Email: "+this.email;
		return resultado;
	}
	
	public Boolean equals(Pessoa p){
		if(p!=null){
			if(p.getNome().equals(this.nome)&&p.getCpf().equals(this.cpf)&&p.getEndereco().equals(this.endereco)&&p.getEmail().equals(this.email)){
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

