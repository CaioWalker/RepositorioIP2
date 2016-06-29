package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.AlocProfDisc;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.exceptions.AlocacaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.AlocacaoJaExisteException;
import br.ufrpe.cj.exceptions.AlocacaoNExisteException;

public interface IRepositorioAlocProfDisc {
	void cadastrar(AlocProfDisc aloc) throws AlocacaoJaExisteException;
	
//	cadastra uma alocação no repositorio 
//	recebendo um objeto AlocProfDisc como
//	parametro.
	
	void cadastrar(Professor p, Disciplina d, Semestre s) throws AlocacaoJaExisteException;
	
//	cadastra uma alocação no repositorio 
//	recebendo como parametro um professor, 
//	uma disciplina e um semestre.
	
	AlocProfDisc procurarCodigo(String codigo) throws AlocacaoCodigoNExisteException;
	
//	retorna uma alocação de acordo com
//	o codigo informado na assinatura.
	
	AlocProfDisc getAlocacao(Professor p, Disciplina d, Semestre s) throws AlocacaoNExisteException;
	
//	retorna uma alocação de acordo com
//	o professor, disciplina e semestre 
//	informados na assinatura.
	
	ArrayList<AlocProfDisc> alocacoesProfessor(Professor p, Semestre s);
	
//	retorna um ArrayList de alocacoes
//	atribuidas a um determinado professor
//	e semestre.
	
	ArrayList<AlocProfDisc> alocacoesDisciplina(Disciplina d, Semestre s);
	
//	retorna um ArrayList de alocacoes
//	atribuidas a uma determinada disciplina
//	e semestre.
	
	ArrayList<AlocProfDisc> alocacoesSemestre(Semestre s);
	
//	retorna um ArrayList de alocacoes
//	atribuidas a um semestre passado como parametro.
	
	boolean contemAlocacao(AlocProfDisc aloc);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao a alocacao
//	passada como parametro.
	
	boolean contemAlocacao(Professor p, Disciplina d, Semestre s);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao a alocacao
//	correspondente ao professor e disciplina 
//	no semestre passado como parametro.
	
	boolean contemAlocacao(String codigo);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao uma alocacao
//	que corresponde ao codigo passado como
//	parametro.
	
	ArrayList<AlocProfDisc> getValidacoesPendentes(Curso c, Semestre s);
	
//	retorna um ArrayList de alocacoes
//	pendentes para que o coordenador 
//	possa vaidar.
	
	ArrayList<AlocProfDisc> getAlocacoesValidas(Curso c, Semestre s);
	
//	retorna um ArrayList de alocacoes
//  validas para fins de consulta do 
//	coordenador.
	
	ArrayList<AlocProfDisc> getAlocacoes();
	
//	retorna um ArrayList de alocacoes
//  na base de dados para fins de auditoria.
	
	void remover(String codigo) throws AlocacaoCodigoNExisteException;
	
//	remove do repositorio uma alocação coorespondente
//	ao codigo informado como parametro.
	
	void remover(AlocProfDisc aloc) throws AlocacaoNExisteException;
	
//	remove do repositorio uma alocação coorespondente
//	ao objeto passado como parametro.
	
	void salvarNoArquivo();
	
}
