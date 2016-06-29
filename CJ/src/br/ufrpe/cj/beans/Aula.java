package br.ufrpe.cj.beans;
import java.io.Serializable;
import java.time.LocalTime;

public class Aula implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String diaSemana;
	private LocalTime Inicio;
	private LocalTime Fim;
	
	public Aula(String diaSemana, int hrInicio, int minInicio, int hrFim, int minFim){
		this.diaSemana = diaSemana;
		this.Inicio = LocalTime.of(hrInicio, minInicio);
		this.Fim = LocalTime.of(hrFim,minFim);
	}
	
	
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public LocalTime getHrInicio() {
		return Inicio;
	}
	public void setHrInicio(int hrInicio, int minInicio) {
		this.Inicio = LocalTime.of(hrInicio, minInicio);
	}
	public LocalTime getHrFim() {
		return Fim;
	}
	public void setHrFim(int hrFim, int minFim) {
		this.Fim = LocalTime.of(hrFim,minFim);
	}
	
	public boolean equals(Aula a){
		boolean resultado = false;
		if(a.getDiaSemana().equals(diaSemana)&&a.getHrInicio()==this.Inicio&&a.getHrFim()==this.Fim){
			resultado = true;
		}
		return resultado;
	}
	
	public String toString(){
		String resultado="Aula na: "+this.diaSemana+" | Inicio: "+this.Inicio+" | Fim: "+this.Fim;
		return resultado;
	}

}
