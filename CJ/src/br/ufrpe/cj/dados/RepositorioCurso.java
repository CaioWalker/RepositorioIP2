package br.ufrpe.cj.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.exceptions.CursoCodigoNExisteException;
import br.ufrpe.cj.exceptions.CursoCoordenadorNExisteException;
import br.ufrpe.cj.exceptions.CursoJaExisteException;
import br.ufrpe.cj.exceptions.CursoNExisteException;
import br.ufrpe.cj.exceptions.CursoNomeNExisteException;



public class RepositorioCurso implements IRepositorioCurso, Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = -8635603547323350634L;

private static RepositorioCurso instance;
	
	private ArrayList<Curso> cursos = new ArrayList<>();
	private int proxima;
	
	public static RepositorioCurso getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioCurso(){
		this.proxima = 1;
	}
	
	private static RepositorioCurso lerDoArquivo(){
		RepositorioCurso instanciaLocal = null;
		
		File in = new File("curso.dat");
		FileInputStream fis = null;
		ObjectInputStream ois =null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o= ois.readObject();
			instanciaLocal = (RepositorioCurso) o;
		}
		catch(Exception e){
			instanciaLocal = new RepositorioCurso();
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
		
		File out = new File("curso.dat");
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
	
	public void cadastrar(Curso c)throws CursoJaExisteException{
		int i=this.procurarIndice(c);
		if(i==-1){
			c.setCodigo("400"+this.proxima);
			cursos.add(c);
			this.proxima++;
			this.salvarArquivo();
		}
		else {
			throw new CursoJaExisteException(c);
        }
	}
	
	public void cadastrar(String nome, String descricao)throws CursoJaExisteException{
		Curso c = new Curso(nome, descricao);
		this.cadastrar(c);
	}
	
	public Curso procurarCodigo(String codigo) throws CursoCodigoNExisteException{
		Curso resultado = null;
		int i = this.procurarIndice(codigo);
		if(i>-1){
			resultado=cursos.get(i);
		}
		else {
			throw new CursoCodigoNExisteException(codigo);
        }
        return resultado;
    }
	
	public Curso procurarCoordenador(Professor p) throws CursoCoordenadorNExisteException {
		Curso resultado = null;
		int i = this.procurarIndice(p);
		if(i>-1){
			resultado=cursos.get(i);
		}
		else {
			throw new CursoCoordenadorNExisteException(p);
        }
        return resultado;
    }
	
	private int procurarIndice(String codigo){
		int resultado = -1;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCodigo().equals(codigo)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	private int procurarIndice(Curso c){
		int resultado = -1;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getNome().equals(c.getNome())){
				resultado=i;
			}
		}
		return resultado;
	}
	
	private int procurarIndice(Professor p){
		int resultado = -1;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCoordenador().equals(p)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	public Curso procurarNome(String nome) throws CursoNomeNExisteException {
		Curso resultado = null;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getNome().equals(nome)){
				resultado=cursos.get(i);
			}
		}
		
		if(resultado==null){
			throw new CursoNomeNExisteException(nome);
		}
		
        return resultado;
    }
	
	public ArrayList<Curso> cursosSemCoordenador() {
		ArrayList<Curso> resultado = new ArrayList<>();
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCoordenador()==null){
				resultado.add(cursos.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<Curso> cursosComCoordenador() {
		ArrayList<Curso> resultado = new ArrayList<>();
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCoordenador()!=null){
				resultado.add(cursos.get(i));
			}
		}
		
        return resultado;
    }
	
	public boolean contemCurso(Curso c){
		boolean resultado = false;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.contains(c)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemCurso(String codigo){
		boolean resultado = false;
		for (int i = 0; i < cursos.size(); i++) {
			if(cursos.get(i).getCodigo().equals(codigo)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public void remover(String codigo) throws CursoCodigoNExisteException{
        int i = this.procurarIndice(codigo);
		
        if (i>-1) {
            this.cursos.remove(i);
        } 
		
		else {
			throw new CursoCodigoNExisteException(codigo);
        }
    }
	
	public void remover(Curso c) throws CursoNExisteException {
		
        if (this.cursos.contains(c)) {
            this.cursos.remove(c);
        } 
		
		else {
			throw new CursoNExisteException(c);
        }
    }


}
