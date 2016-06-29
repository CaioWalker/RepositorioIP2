package br.ufrpe.cj.beans;

public enum DiaSemana {
	SEGUNDA(1),TERCA(2),QUARTA(3),QUINTA(4),SEXTA(5);
	
	private final int valor;
	
	DiaSemana(int valorDia){
		valor =valorDia;
	}
	
	public int getValor(){
		return this.valor;
	}

}
