package br.ufrpe.cj.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.AptidaoJaCadastradaException;
import br.ufrpe.cj.exceptions.AptidaoNExisteException;
import br.ufrpe.cj.exceptions.AptidiaoCodigoNExisteException;

public class RepositorioApto implements Serializable, IRepositorioApto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1464624834899902304L;

	private static RepositorioApto instance;
	
	private ArrayList<Apto> aptidoes = new ArrayList<>();
	private int proxima;
	
	public static RepositorioApto getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioApto(){
		this.proxima = 1;
	}
	
	private static RepositorioApto lerDoArquivo(){
		RepositorioApto instanciaLocal = null;
		
		File in = new File("apto.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			instanciaLocal = (RepositorioApto) o;		
		}
		catch(Exception e){
			instanciaLocal = new RepositorioApto();
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
		
		File out = new File("apto.dat");
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
	
	public void cadastrar(Apto cadas)throws AptidaoJaCadastradaException{
		int i=this.procurarIndice(cadas);
		if(i==-1){
			cadas.setCodigo("300"+this.proxima);
			this.aptidoes.add(cadas);
			this.proxima++;
		}
		else {
			throw new AptidaoJaCadastradaException(cadas);
        }
	}
	
	public void cadastrar(Professor p, Disciplina d) throws AptidaoJaCadastradaException{
		Apto cadas = new Apto(p, d);
		this.cadastrar(cadas);
	}
	
	public Apto procurarCodigo(String codigo) throws AptidiaoCodigoNExisteException{
		Apto resultado = null;
		int i = this.procurarIndice(codigo);
		if(i>-1){
			resultado=aptidoes.get(i);
		}
		else {
			throw new AptidiaoCodigoNExisteException(codigo);
        }
        return resultado;
    }
	
	private int procurarIndice(String codigo){
		int resultado = -1;
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getCodigo().equals(codigo)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	private int procurarIndice(Apto a){
		int resultado = -1;
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getProfessor().getCpf().equals(a.getProfessor().getCpf())&&
				aptidoes.get(i).getDisciplina().getCodigo().equals(a.getDisciplina().getCodigo())){
				resultado=i;
			}
		}
		return resultado;
	}
	
	public ArrayList<Apto> aptidoesProfessor(Professor p) {
		ArrayList<Apto> resultado = new ArrayList<>();
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getProfessor().equals(p)){
				resultado.add(aptidoes.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<Apto> aptidoesDisciplina(Disciplina d) {
		ArrayList<Apto> resultado = new ArrayList<>();
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getDisciplina().equals(d)){
				resultado.add(aptidoes.get(i));
			}
		}
		
        return resultado;
    }
	
	public boolean contemAptidao(Apto cadas){
		Boolean resultado = false;
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getProfessor().equals(cadas.getProfessor())&&
					aptidoes.get(i).getDisciplina().equals(cadas.getDisciplina())){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemAptidao(String codigo){
		Boolean resultado = false;
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getCodigo().equals(codigo)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public ArrayList<Apto> getValidacoesPendentes() {
		ArrayList<Apto> resultado = new ArrayList<>();
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getValidacao()==false){
				resultado.add(aptidoes.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<Apto> getAptidoesValidas() {
		ArrayList<Apto> resultado = new ArrayList<>();
		for (int i = 0; i < aptidoes.size(); i++) {
			if(aptidoes.get(i).getValidacao()){
				resultado.add(aptidoes.get(i));
			}
		}
        return resultado;
    }
	
	public void remover(String codigo) throws AptidiaoCodigoNExisteException{
        int i = this.procurarIndice(codigo);
		
        if (i>-1) {
            this.aptidoes.remove(i);
            this.salvarArquivo();
        } 
		
		else {
			throw new AptidiaoCodigoNExisteException(codigo);
        }
    }
	
	public void remover(Apto cadas) throws AptidaoNExisteException{
		
        if (this.aptidoes.contains(cadas)) {
            this.aptidoes.remove(cadas);
            this.salvarArquivo();
        } 
		
		else {
			throw new AptidaoNExisteException(cadas.getProfessor(),cadas.getDisciplina());
        }
    }
	
}
