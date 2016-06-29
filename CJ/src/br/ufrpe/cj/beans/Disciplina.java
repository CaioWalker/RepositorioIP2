package br.ufrpe.cj.beans;

import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.exceptions.ChoqueHorarioDiscException;

public class Disciplina implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String descricao;
	private String codigo;
	private Curso curso;
	private ArrayList<Aula> aulas = new ArrayList<>();
	
	public Disciplina(String nome,String descricao, Curso curso){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setCurso(curso);
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
		String resultado = "Nome: "+this.nome+"\nDescricao: "+this.descricao;
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public ArrayList<Aula> getAulas(){
		ArrayList<Aula>  resultado= new ArrayList<>();
		for(int i=0;i<this.aulas.size();i++){
			resultado.add(this.aulas.get(i));
		}
		return resultado;
	}
	
	public void addAula(Aula a) throws ChoqueHorarioDiscException{
		boolean horarioOK = true;
		for(int i=0;i<this.aulas.size();i++){
			if(this.aulas.get(i).getDiaSemana().equals(a.getDiaSemana())){
				if(this.aulas.get(i).getHrInicio().equals(a.getHrInicio())){
					horarioOK=false;
				}
				if(a.getHrInicio().isAfter(this.aulas.get(i).getHrInicio())&&
				a.getHrInicio().isBefore(this.aulas.get(i).getHrFim())){
					horarioOK=false;
				}
			}
		}
		
		if(horarioOK){
			this.aulas.add(a);
		}
		else{
			throw new ChoqueHorarioDiscException();
		}
		
	}
	
	public Boolean equals(Disciplina d){
		if(d!=null){
			if(d.getNome().equals(this.nome)&&d.getCodigo().equals(this.codigo)&& d.getCurso().equals(this.curso)){
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	
}
