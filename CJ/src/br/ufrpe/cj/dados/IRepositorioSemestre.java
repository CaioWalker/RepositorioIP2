package br.ufrpe.cj.dados;

import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.exceptions.SemestreNExisteException;

public interface IRepositorioSemestre {
	
	void salvarArquivo();
	
	void cadastrar(Semestre s);
	
//	cadastra um semestre no repositorio 
//	recebendo um objeto semestre como parametro.
	
	void cadastrar(String descricao);
	
//	cadastra um semestre no repositorio 
//	recebendo uma descricao como parametro.
	
	Semestre procurarNome(String nome)throws SemestreNExisteException;
	
//	retorna um semestre de acordo com
//	o nome informado na assinatura.
	
	boolean contemSemestre(Semestre s);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao um semestre
//	que corresponde ao semetre passado como
//	parametro.
	
	boolean contemSemstre(String nome);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao um semestre
//	que corresponde ao nome passado como
//	parametro.
	
	Semestre getSemstreCorrente();
	
//	retorna o semestre corrente 
//	do repositorio;


}
