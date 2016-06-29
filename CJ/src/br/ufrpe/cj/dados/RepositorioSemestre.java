package br.ufrpe.cj.dados;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.exceptions.SemestreNExisteException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class RepositorioSemestre implements Serializable, IRepositorioSemestre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static RepositorioSemestre instance;
	
	private ArrayList<Semestre> semestres = new ArrayList<>();
	private int proxima;
	private int anoCorrente;
	private Semestre semstreCorrente;
	
	public static RepositorioSemestre getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioSemestre(){
		this.proxima = 1;
		this.anoCorrente = LocalDate.now().getYear();
	}
	
	private static RepositorioSemestre lerDoArquivo(){
		RepositorioSemestre instanciaLocal = null;
		
		File in = new File("semestre.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			instanciaLocal = (RepositorioSemestre) o;		
		}
		catch(Exception e){
			instanciaLocal = new RepositorioSemestre();
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
		
		File out = new File("semestre.dat");
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
	
	public void cadastrar(Semestre s){
				
		if(LocalDate.now().getYear()>this.anoCorrente){
			this.proxima = 1;
			this.anoCorrente = LocalDate.now().getYear();
		}
			
		s.setNome(LocalDate.now().getYear()+"."+this.proxima);
		semestres.add(s);
		this.semstreCorrente=s;
		this.proxima++;
		this.salvarArquivo();
		
		
	}
	
	public void cadastrar(String descricao){
		Semestre s = new Semestre(descricao);
		this.cadastrar(s);
	}
	
	public Semestre procurarNome(String nome) throws SemestreNExisteException{
		Semestre resultado = null;
		for (int i = 0; i < semestres.size(); i++) {
			if(semestres.get(i).getNome().equals(nome)){
				resultado=semestres.get(i);
			}
		}
		
		if(resultado==null){
			throw new SemestreNExisteException(nome);
		}
		
        return resultado;
    }
	
	public boolean contemSemestre(Semestre s){
		boolean resultado = false;
		for (int i = 0; i < semestres.size(); i++) {
			if(semestres.contains(s)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemSemstre(String nome){
		boolean resultado = false;
		for (int i = 0; i < semestres.size(); i++) {
			if(semestres.get(i).getNome().equals(nome)){
				resultado=true;
			}
		}
		return resultado;
	}

	public Semestre getSemstreCorrente() {
		return semstreCorrente;
	}
	
}
