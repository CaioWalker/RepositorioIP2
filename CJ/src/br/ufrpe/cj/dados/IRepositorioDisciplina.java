package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.exceptions.DiscNomeNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaJaExisteException;
import br.ufrpe.cj.exceptions.DisciplinaNExisteException;

public interface IRepositorioDisciplina {
	
	void salvarArquivo();
	
	void cadastrar(Disciplina d)throws DisciplinaJaExisteException;
	
//	cadastra uma disciplina no repositorio 
//	recebendo um objeto disciplina como parametro.
	
	void cadastrar(String nome, String descricao, Curso curso)throws DisciplinaJaExisteException;
	
//	cadastra uma disciplina no repositorio 
//	recebendo como parametro um nome, 
//	descricao e um objeto curso.
	
	Disciplina procurarCodigo(String codigo)throws DisciplinaCodigoNExisteException;
	
//	retorna uma disciplina de acordo com
//	o codigo informado na assinatura.
	
	Disciplina procurarNome(String nome)throws DiscNomeNExisteException;
	
//	retorna uma disciplina de acordo com
//	o nome informado na assinatura.
	
	ArrayList<Disciplina> disciplinasCurso(Curso c);
	
//	retorna um ArrayList de disciplinas
//	atribuidas a um determinado curso.
	
	ArrayList<Disciplina> disciplinasSemAula(Curso c);
	
//	retorna um ArrayList de disciplinas
//	sem aula de um determinado curso.
	
	boolean contemDisciplina(Disciplina d);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao uma disciplina
//	que corresponde a disciplina passada como
//	parametro.
	
	boolean contemDisciplina(String codigo);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao uma disciplina
//	que corresponde ao codigo passado como
//	parametro.
	
	void remover(String codigo)throws DisciplinaCodigoNExisteException;
	
//	remove uma disciplina do repositorio 
//	correspondente ao codigo passado 
//	como parametro.
//	(caso a disciplina exista).
	
	void remover(Disciplina d)throws DisciplinaNExisteException;
	
//	remove uma disciplina do repositorio 
//	correspondente a disciplina passada
//	como parametro.
//	(caso a disciplina exista).
	
	
}
