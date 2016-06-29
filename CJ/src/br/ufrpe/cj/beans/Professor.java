package br.ufrpe.cj.beans;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.exceptions.FormacaoNExisteException;

public class Professor extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nFormacao;
	private ArrayList<Formacao> formacoes = new ArrayList<>();
	private ArrayList<AreasInt> areasInt = new ArrayList<>();
	private Boolean coordenador;
	private ArrayList<String> notificacoes = new ArrayList<>();
	
	public Professor(String nome,String cpf,String endereco,String email,String senha){
		super(nome,cpf,endereco,email,senha);
		this.setCoordenador(false);
		this.nFormacao=0;
	}

	public void addFormacao(String titulo, String descricao){
		Formacao f = new Formacao(titulo,descricao);
		f.setCodigo("800"+this.nFormacao);
		this.formacoes.add(f);
	}
	
	public void removeFormacao(Formacao f) throws FormacaoNExisteException{
		int resultado = -1;
		for (int i = 0; i < this.formacoes.size(); i++) {
			if(this.formacoes.get(i).getCodigo().equals(f.getCodigo())){
				resultado=i;
			}
		}
		if(resultado!=-1){
			this.formacoes.remove(resultado);
			this.addNotificacoes("A Formacao "+f.getTitulo()+" foi invalidada pelo coordenador.");
		}
		else{
			throw new FormacaoNExisteException();
		}
	}
	
	public void validarFormacao(Formacao f){
		f.setEstado(true);
		this.addNotificacoes("A Formacao "+f.getTitulo()+" foi validada pelo coordenador.");
	}
	
	public ArrayList<Formacao> getFormacao() {
		ArrayList<Formacao> resultado = new ArrayList<>();
		for (int i = 0; i < formacoes.size(); i++) {
			if(formacoes.get(i).getEstado()==true){
				resultado.add(formacoes.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<Formacao> getFormacaoPendente() {
		ArrayList<Formacao> resultado = new ArrayList<>();
		for (int i = 0; i < formacoes.size(); i++) {
			if(formacoes.get(i).getEstado()==false){
				resultado.add(formacoes.get(i));
			}
		}
		
        return resultado;
    }
	
	public void addAreasInt(String titulo,String descricao){
		AreasInt a = new AreasInt(titulo,descricao);
		this.areasInt.add(a);
	}

	public Boolean getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Boolean coordenador) {
		this.coordenador = coordenador;
	}

	public ArrayList<String> getNotificacoes() {
		return notificacoes;
	}

	public void addNotificacoes(String not) {
		this.notificacoes.add(not);
	}
		
	
}
