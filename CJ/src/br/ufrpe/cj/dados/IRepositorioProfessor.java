package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.ProfessorCpfNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailSenhaNExisteException;
import br.ufrpe.cj.exceptions.ProfessorJaCadastradoException;
import br.ufrpe.cj.exceptions.ProfessorNExisteException;
import br.ufrpe.cj.exceptions.ProfessorNomeNExisteException;

public interface IRepositorioProfessor {
	
	void salvarArquivo();
	
	void cadastrar(Professor p)throws ProfessorJaCadastradoException;
	
//	cadastra um professor no repositorio 
//	recebendo um objeto professor como parametro.
	
	void cadastrar(String nome, String cpf, String endereco, String email, String senha)throws ProfessorJaCadastradoException;
	
//	cadastra um professor no repositorio 
//	recebendo como parametro seus atributos nome, 
//	cpf, endereço e email.
	
	Professor procurarCpf(String cpf)throws ProfessorCpfNExisteException;
	
//	retorna um professor de acordo com
//	o cpf informado na assinatura.
	
	Professor procurarNome(String nome) throws ProfessorNomeNExisteException;
	
//	retorna um professor de acordo com
//	o nome informado na assinatura.
	
	Professor procurarEmail(String email)throws ProfessorEmailNExisteException;
	
//	retorna um professor de acordo com
//	o email informado na assinatura.
	
	ArrayList<Professor> professoresFormPend();
	
	Professor procurarEmailSenha(String email, String senha) throws ProfessorEmailSenhaNExisteException;
	
//	retorna um ArrayList de professores
//	que contem formacoes que ainda nao 
//	foram validadas pelo coordenador.
	
	boolean contemProfessor(Professor p);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao um professor
//	que corresponde ao professor passado como
//	parametro.
	
	boolean contemProfessor(String cpf);
	
//	retorna um boolean indicando se o
//	repositorio contem ou nao um professor
//	que corresponde ao cpf passado como
//	parametro.
	
	void remover(String cpf)throws ProfessorCpfNExisteException;
	
//	remove um professor do repositorio 
//	correspondente ao cpf passado 
//	como parametro.
//	(caso o professor exista).
	
	void remover(Professor p)throws ProfessorNExisteException;
	
//	remove um professor do repositorio 
//	correspondente ao objeto professor
//	passado como parametro.
//	(caso o professor exista).
	
	

}
