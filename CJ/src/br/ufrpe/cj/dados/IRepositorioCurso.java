package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.CursoCodigoNExisteException;
import br.ufrpe.cj.exceptions.CursoCoordenadorNExisteException;
import br.ufrpe.cj.exceptions.CursoJaExisteException;
import br.ufrpe.cj.exceptions.CursoNExisteException;
import br.ufrpe.cj.exceptions.CursoNomeNExisteException;

public interface IRepositorioCurso {
	
	void salvarArquivo();
	
	void cadastrar(Curso c)throws CursoJaExisteException;
	
//	cadastra um curso no repositorio 
//	recebendo um objeto Curso como parametro.
	
	void cadastrar(String nome, String descricao)throws CursoJaExisteException;
	
//	cadastra um curso no repositorio 
//	recebendo um nome e uma descricao 
//	como parametro.
	
	Curso procurarCodigo(String codigo)throws CursoCodigoNExisteException;
	
//	retorna um curso de acordo com
//	o codigo informado na assinatura.
	
	Curso procurarNome(String nome)throws CursoNomeNExisteException;
	
//	retorna um curso de acordo com
//	o nome informado na assinatura.
	
	boolean contemCurso(Curso c);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao ocurso
//	passado como parametro.
	
	boolean contemCurso(String codigo);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao um curso
//	que corresponde ao codigo passado como
//	parametro.
	
	void remover(String codigo)throws CursoCodigoNExisteException;
	
//	remove um curso do repositorio 
//	correspondente ao codigo passado 
//	como parametro.
//	(caso o curso exista).
	
	void remover(Curso d)throws CursoNExisteException;
	
//	remove um curso do repositorio 
//	correspondente ao curso passada 
//	como parametro.
//	(caso o curso exista).
	
	ArrayList<Curso> cursosComCoordenador();
	
//	retorna um ArrayList de cursos
//	com coordenador setado.
	
	ArrayList<Curso> cursosSemCoordenador();
	
//	retorna um ArrayList de cursos
//	sem coordenador setado.
	
	Curso procurarCoordenador(Professor p) throws CursoCoordenadorNExisteException;
	

}
