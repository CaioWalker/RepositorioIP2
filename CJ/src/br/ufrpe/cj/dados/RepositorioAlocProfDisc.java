package br.ufrpe.cj.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.beans.AlocProfDisc;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.exceptions.AlocacaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.AlocacaoJaExisteException;
import br.ufrpe.cj.exceptions.AlocacaoNExisteException;

public class RepositorioAlocProfDisc implements IRepositorioAlocProfDisc, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2123955073805281555L;

	private static RepositorioAlocProfDisc instance;
	
	private ArrayList<AlocProfDisc> alocProfDiscs = new ArrayList<>();
	private int proxima;
	
	public static RepositorioAlocProfDisc getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioAlocProfDisc(){
		this.proxima = 1;
	}
	
	private static RepositorioAlocProfDisc lerDoArquivo(){
		RepositorioAlocProfDisc instanciaLocal = null;
		
		File in = new File("AlocProfDisc.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			instanciaLocal=(RepositorioAlocProfDisc) o;
		}
		
		catch(Exception e){
			instanciaLocal = new RepositorioAlocProfDisc();
		}
		
		finally{
			if(ois!=null){
				try{
					ois.close();
				}
				catch(Exception e){
//					nada acontece
				}
			}
		}
		
		return instanciaLocal;
	}
	
	public void salvarNoArquivo(){
		if(instance == null){
			return;
		}
		File out = new File("AlocProfDisc.dat");
		FileOutputStream fos= null;
		ObjectOutputStream oos= null;
		
		try{
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(out!= null){
				try{
					oos.close();
				}
				catch(Exception e){
//					não faz nada
				}
			}
		}
		
	}
		
	
	public void cadastrar(AlocProfDisc aloc) throws AlocacaoJaExisteException{
		int i=this.procurarIndice(aloc);
		if(i==-1){
			aloc.setCodigo("200"+this.proxima);
			this.alocProfDiscs.add(aloc);
			this.proxima++;
		}
		else {
			throw new AlocacaoJaExisteException(aloc);
        }
	}
	
	public void cadastrar(Professor p, Disciplina d, Semestre s) throws AlocacaoJaExisteException{
		AlocProfDisc aloc = new AlocProfDisc(p, d, s);
		this.cadastrar(aloc);
	}
	
	public AlocProfDisc procurarCodigo(String codigo) throws AlocacaoCodigoNExisteException{
		AlocProfDisc resultado = null;
		int i = this.procurarIndice(codigo);
		if(i!=-1){
			resultado=alocProfDiscs.get(i);
		}
		else {
			throw new AlocacaoCodigoNExisteException(codigo);
        }
        return resultado;
    }
	
	public AlocProfDisc getAlocacao(Professor p, Disciplina d, Semestre s) throws AlocacaoNExisteException{
		AlocProfDisc aloc = new AlocProfDisc(p, d, s);
		AlocProfDisc resultado=null;
		int indice = procurarIndice(aloc);
		if(indice!=-1){
			resultado = this.alocProfDiscs.get(indice);
		}
		else{
			throw new AlocacaoNExisteException(p,d,s);
		}
		
		return resultado;
	}
	
	private int procurarIndice(String codigo){
		int resultado = -1;
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getCodigo().equals(codigo)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	private int procurarIndice(AlocProfDisc aloc){
		int resultado = -1;
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getProfessor().equals(aloc.getProfessor())&&
				alocProfDiscs.get(i).getDisciplina().equals(aloc.getDisciplina())&&
				alocProfDiscs.get(i).getSemestre().equals(aloc.getSemestre())){
				resultado=i;
			}
		}
		return resultado;
	}
	
	public ArrayList<AlocProfDisc> alocacoesProfessor(Professor p, Semestre s) {
		ArrayList<AlocProfDisc> resultado = new ArrayList<>();
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(this.alocProfDiscs.get(i)!=null){
				if(alocProfDiscs.get(i).getProfessor().equals(p)&&
						alocProfDiscs.get(i).getSemestre().equals(s)){
						resultado.add(alocProfDiscs.get(i));
					}
			}
		}
		
        return resultado;
    }
	
	public ArrayList<AlocProfDisc> alocacoesDisciplina(Disciplina d, Semestre s) {
		ArrayList<AlocProfDisc> resultado = new ArrayList<>();
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getDisciplina().equals(d)&&alocProfDiscs.get(i).getSemestre().equals(s)){
				resultado.add(alocProfDiscs.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<AlocProfDisc> alocacoesSemestre(Semestre s) {
		ArrayList<AlocProfDisc> resultado = new ArrayList<>();
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getSemestre().equals(s)){
				resultado.add(alocProfDiscs.get(i));
			}
		}
		
        return resultado;
    }
	

	public boolean contemAlocacao(AlocProfDisc aloc){
		boolean resultado = false;
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getProfessor().equals(aloc.getProfessor())&&
				alocProfDiscs.get(i).getDisciplina().equals(aloc.getDisciplina())&&
				alocProfDiscs.get(i).getSemestre().equals(aloc.getSemestre())){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemAlocacao(Professor p, Disciplina d, Semestre s) {
		
		boolean resultado = false;
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getProfessor().equals(p)&&
				alocProfDiscs.get(i).getDisciplina().equals(d)&&
				alocProfDiscs.get(i).getSemestre().equals(s)){
				resultado=true;
			}
		}
		return resultado;
		
	}
	
	public boolean contemAlocacao(String codigo){
		boolean resultado = false;
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getCodigo().equals(codigo)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public ArrayList<AlocProfDisc> getValidacoesPendentes(Curso c, Semestre s) {
		ArrayList<AlocProfDisc> resultado = new ArrayList<>();
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getValidacao()==false&&
				alocProfDiscs.get(i).getDisciplina().getCurso().equals(c)&&
				alocProfDiscs.get(i).getSemestre().equals(s)){
				resultado.add(alocProfDiscs.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<AlocProfDisc> getAlocacoesValidas(Curso c, Semestre s) {
		ArrayList<AlocProfDisc> resultado = new ArrayList<>();
		for (int i = 0; i < alocProfDiscs.size(); i++) {
			if(alocProfDiscs.get(i).getValidacao()&&
				alocProfDiscs.get(i).getDisciplina().getCurso().equals(c)&&
				alocProfDiscs.get(i).getSemestre().equals(s)){
				resultado.add(alocProfDiscs.get(i));
			}
		}
        return resultado;
    }
	
	public ArrayList<AlocProfDisc> getAlocacoes() {
		return this.alocProfDiscs;
    }
	
	public void remover(String codigo) throws AlocacaoCodigoNExisteException{
        int i = this.procurarIndice(codigo);
		
        if (i>-1) {
            this.alocProfDiscs.remove(i);
        } 
		
		else {
			throw new AlocacaoCodigoNExisteException(codigo);
        }
    }
	
	public void remover(AlocProfDisc aloc) throws AlocacaoNExisteException{
		
        if (this.alocProfDiscs.contains(aloc)) {
            this.alocProfDiscs.remove(aloc);
        } 
		
		else {
			throw new AlocacaoNExisteException(aloc.getProfessor(),aloc.getDisciplina(),aloc.getSemestre());
        }
    }

	
	
}
