package br.ufrpe.cj.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.ProfessorCpfNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailSenhaNExisteException;
import br.ufrpe.cj.exceptions.ProfessorJaCadastradoException;
import br.ufrpe.cj.exceptions.ProfessorNExisteException;
import br.ufrpe.cj.exceptions.ProfessorNomeNExisteException;

public class RepositorioProfessor implements Serializable, IRepositorioProfessor{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private static RepositorioProfessor instance;
	
	private ArrayList<Professor> professores = new ArrayList<>();
	
	public static RepositorioProfessor getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioProfessor(){
	}
	
	private static RepositorioProfessor lerDoArquivo(){
		RepositorioProfessor instanciaLocal = null;
		
		File in = new File("professor.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			instanciaLocal = (RepositorioProfessor) o;		
		}
		catch(Exception e){
			instanciaLocal = new RepositorioProfessor();
		}
		finally{
			if(ois!=null){
				try{
					ois.close();
				}
				catch(Exception e){
//					não faz nada
				}
			}
		}
		
		return instanciaLocal;
	}
	
	public void salvarArquivo(){
		if(instance==null){
			return;
		}
		
		File out = new File("professor.dat");
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try{
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(oos!=null){
				try{
					oos.close();
				}
				catch(Exception e){
//					não faz nada
				}
			}
		}
	}
	
	public void cadastrar(Professor p) throws ProfessorJaCadastradoException{
		int i=this.procurarIndice(p.getCpf());
		if(i==-1){
			professores.add(p);
		}
		else {
			throw new ProfessorJaCadastradoException(p);
        }
	}
	
	public void cadastrar(String nome, String cpf, String endereco, String email, String senha)throws ProfessorJaCadastradoException{
		Professor p = new Professor(nome,cpf,endereco,email,senha);
		this.cadastrar(p);
	}
	
	public Professor procurarCpf(String cpf) throws ProfessorCpfNExisteException{
		Professor resultado = null;
		int i = this.procurarIndice(cpf);
		if(i>-1){
			resultado=professores.get(i);
		}
		else {
			throw new ProfessorCpfNExisteException(cpf);
        }
        return resultado;
    }
	
	private int procurarIndice(String cpf){
		int resultado = -1;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getCpf().equals(cpf)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	public Professor procurarNome(String nome) throws ProfessorNomeNExisteException{
		Professor resultado = null;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getNome().equals(nome)){
				resultado=professores.get(i);
			}
		}
		
		if(resultado==null){
			throw new ProfessorNomeNExisteException(nome);
		}
		
        return resultado;
    }
	
	public Professor procurarEmailSenha(String email, String senha) throws ProfessorEmailSenhaNExisteException{
		Professor resultado = null;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getEmail().endsWith(email)&&
				professores.get(i).getSenha().equals(senha)){
				resultado=professores.get(i);
			}
		}
		
		if(resultado==null){
			throw new ProfessorEmailSenhaNExisteException();
		}
		
        return resultado;
	}

	public Professor procurarEmail(String email) throws ProfessorEmailNExisteException{
		Professor resultado = null;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getEmail().equals(email)){
				resultado=professores.get(i);
			}
		}
		
		if(resultado==null){
			throw new ProfessorEmailNExisteException(email);
		}
		
        return resultado;
	}
	
	public ArrayList<Professor> professoresFormPend() {
		ArrayList<Professor> resultado = new ArrayList<>();
		for (int i = 0; i < professores.size(); i++) {
				if(professores.get(i).getFormacaoPendente().size()>0){
					resultado.add(professores.get(i));
				}			
		}
		
        return resultado;
    }
	

	public boolean contemProfessor(Professor p){
		boolean resultado = false;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.contains(p)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemProfessor(String cpf){
		boolean resultado = false;
		for (int i = 0; i < professores.size(); i++) {
			if(professores.get(i).getCpf().equals(cpf)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public void remover(String cpf) throws ProfessorCpfNExisteException{
        int i = this.procurarIndice(cpf);
		
        if (i>-1) {
            this.professores.remove(i);
        } 
		
		else {
			throw new ProfessorCpfNExisteException(cpf);
        }
    }
	
	public void remover(Professor p) throws ProfessorNExisteException{
		
        if (this.professores.contains(p)) {
            this.professores.remove(p);
        } 
		
		else {
			throw new ProfessorNExisteException(p);
        }
    }
	

}
