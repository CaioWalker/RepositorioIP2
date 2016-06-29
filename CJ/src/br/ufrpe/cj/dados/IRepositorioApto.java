package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.AptidaoJaCadastradaException;
import br.ufrpe.cj.exceptions.AptidaoNExisteException;
import br.ufrpe.cj.exceptions.AptidiaoCodigoNExisteException;

public interface IRepositorioApto {
	
	void salvarArquivo();
	
	void cadastrar(Apto cadas) throws AptidaoJaCadastradaException;
	
//	cadastra uma intencao de lecionar no repositorio 
//	recebendo um objeto Apto como parametro.
	
	void cadastrar(Professor p, Disciplina d)throws AptidaoJaCadastradaException;
	
//	cadastra uma intencao de lecionar no repositorio 
//	recebendo um Professor e uma Disciplina como parametro.
	
	Apto procurarCodigo(String codigo)throws AptidiaoCodigoNExisteException;
	
//	retorna uma aptidao de acordo com
//	o codigo informado na assinatura.
	
	ArrayList<Apto> aptidoesProfessor(Professor p);
	
//	retorna um ArrayList de aptidoes
//	atribuidas a um determinado professor.
	
	ArrayList<Apto> aptidoesDisciplina(Disciplina d);
	
//	retorna um ArrayList de aptidoes
//	atribuidas a uma determinada disciplina.
	
	boolean contemAptidao(Apto cadas);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao a aptidao
//	passada como parametro.
	
	boolean contemAptidao(String codigo);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao uma aptidao
//	que corresponde ao codigo passado como
//	parametro.
	
	ArrayList<Apto> getValidacoesPendentes();
	
//	retorna um ArrayList de aptidoes
//	pendentes para que o coordenador 
//	possa vaidar.
	
	ArrayList<Apto> getAptidoesValidas();

//	retorna um ArrayList de aptidoes
//  validas para fins de consulta do 
//	coordenador.
	
	void remover(String codigo)throws AptidiaoCodigoNExisteException;
	
//	remove uma aptidao do repositorio 
//	correspondente ao codigo passado 
//	como parametro.
//	(caso a aptidao exista).
	
	void remover(Apto cadas)throws AptidaoNExisteException;
	
//	remove uma aptidao do repositorio 
//	correspondente a aptidao passada 
//	como parametro.
//	(caso a aptidao exista).
	

}
