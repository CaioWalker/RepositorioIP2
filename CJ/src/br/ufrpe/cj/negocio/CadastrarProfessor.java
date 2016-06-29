package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.dados.IRepositorioProfessor;
import br.ufrpe.cj.exceptions.NoFormPendentesException;
import br.ufrpe.cj.exceptions.ProfessorCpfNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailSenhaNExisteException;
import br.ufrpe.cj.exceptions.ProfessorJaCadastradoException;
import br.ufrpe.cj.exceptions.ProfessorNExisteException;
import br.ufrpe.cj.exceptions.ProfessorNomeNExisteException;

public class CadastrarProfessor {
	private IRepositorioProfessor repositorioProfessor;
	
	public CadastrarProfessor(IRepositorioProfessor instanciaRepositorio){
		this.repositorioProfessor=instanciaRepositorio;
	}
	
	public void cadastrarProfessor(String nome,String cpf,String endereco,String email,String senha) throws ProfessorJaCadastradoException{
		this.repositorioProfessor.cadastrar(nome, cpf, endereco, email,senha);
		this.repositorioProfessor.salvarArquivo();
	}
	
	public Professor procurarProfessorCpf(String cpf) throws ProfessorCpfNExisteException{
		return this.repositorioProfessor.procurarCpf(cpf);
	}
	
	public Professor procurarProfessorNome(String nome) throws ProfessorNomeNExisteException{
		return this.repositorioProfessor.procurarNome(nome);
	}
	
	public void setProfessorCoordenador(String cpf, boolean v) throws ProfessorCpfNExisteException{
		this.repositorioProfessor.procurarCpf(cpf).setCoordenador(v);
		this.repositorioProfessor.salvarArquivo();
	}
	
	public Professor procurarProfessorEmail(String email) throws ProfessorEmailNExisteException{
		return this.repositorioProfessor.procurarEmail(email);
	}
	
	public ArrayList<Professor> professoresFormPend() throws NoFormPendentesException {
		if(this.repositorioProfessor.professoresFormPend().size()==0){
			throw new NoFormPendentesException();
		}
		
		return this.repositorioProfessor.professoresFormPend();
	}
	
	public void remover(Professor p) throws ProfessorNExisteException{
		this.repositorioProfessor.remover(p);
		this.repositorioProfessor.salvarArquivo();
	}
	
	public Professor procurarEmailSenha(String email, String senha) throws ProfessorEmailSenhaNExisteException{
		return this.repositorioProfessor.procurarEmailSenha(email, senha);
	}
	
}
