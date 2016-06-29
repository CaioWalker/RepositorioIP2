package br.ufrpe.cj.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.exceptions.DiscNomeNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaJaExisteException;
import br.ufrpe.cj.exceptions.DisciplinaNExisteException;

public class RepositorioDisciplinas implements IRepositorioDisciplina, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static RepositorioDisciplinas instance;
	
	private ArrayList<Disciplina> disciplinas = new ArrayList<>();
	private int proxima;
	
	public static RepositorioDisciplinas getInstance(){
		if(instance == null){
			instance = lerDoArquivo();
		}
		return instance;
	}
	
	private RepositorioDisciplinas(){
		this.proxima = 1;
	}
	
	private static RepositorioDisciplinas lerDoArquivo(){
		RepositorioDisciplinas instanciaLocal = null;
		
		File in = new File("disciplina.dat");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try{
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			
			instanciaLocal = (RepositorioDisciplinas) o;		
		}
		catch(Exception e){
			instanciaLocal = new RepositorioDisciplinas();
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
		
		File out = new File("disciplina.dat");
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
	
	public void cadastrar(Disciplina d)throws DisciplinaJaExisteException{
		int i=this.procurarIndice(d);
		if(i==-1){
			d.setCodigo("100"+this.proxima);
			disciplinas.add(d);
			this.proxima++;
			this.salvarArquivo();
		}
		else {
			throw new DisciplinaJaExisteException(d);
        }
	}
	
	public void cadastrar(String nome, String descricao, Curso curso)throws DisciplinaJaExisteException{
		Disciplina d = new Disciplina(nome, descricao, curso);
		this.cadastrar(d);
	}
	
	public Disciplina procurarCodigo(String codigo) throws DisciplinaCodigoNExisteException{
		Disciplina resultado = null;
		int i = this.procurarIndice(codigo);
		if(i>-1){
			resultado=disciplinas.get(i);
		}
		else {
			throw new DisciplinaCodigoNExisteException(codigo);
        }
        return resultado;
    }
	
	private int procurarIndice(String codigo){
		int resultado = -1;
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getCodigo().equals(codigo)){
				resultado=i;
			}
		}
		return resultado;
	}
	
	private int procurarIndice(Disciplina d){
		int resultado = -1;
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getNome().equals(d.getNome())&&
				disciplinas.get(i).getDescricao().equals(d.getDescricao())&&
				disciplinas.get(i).getCurso().equals(d.getCurso())
					){
				resultado=i;
			}
		}
		return resultado;
	}
	
	public Disciplina procurarNome(String nome) throws DiscNomeNExisteException {
		Disciplina resultado = null;
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getNome().equals(nome)){
				resultado=disciplinas.get(i);
			}
		}
		if(resultado==null){
			throw new DiscNomeNExisteException(nome);
		}
        return resultado;
    }
	
	public ArrayList<Disciplina> disciplinasCurso(Curso c) {
		ArrayList<Disciplina> resultado = new ArrayList<>();
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getCurso().equals(c)){
				resultado.add(disciplinas.get(i));
			}
		}
		
        return resultado;
    }
	
	public ArrayList<Disciplina> disciplinasSemAula(Curso c) {
		ArrayList<Disciplina> resultado = new ArrayList<>();
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getAulas().size()==0&&disciplinas.get(i).getCurso().equals(c)){
				resultado.add(disciplinas.get(i));
			}
		}
		
        return resultado;
    }

	public boolean contemDisciplina(Disciplina d){
		boolean resultado = false;
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.contains(d)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public boolean contemDisciplina(String codigo){
		boolean resultado = false;
		for (int i = 0; i < disciplinas.size(); i++) {
			if(disciplinas.get(i).getCodigo().equals(codigo)){
				resultado=true;
			}
		}
		return resultado;
	}
	
	public void remover(String codigo) throws DisciplinaCodigoNExisteException{
        int i = this.procurarIndice(codigo);
		
        if (i>-1) {
            this.disciplinas.remove(i);
            this.salvarArquivo();
        } 
		
		else {
			throw  new DisciplinaCodigoNExisteException(codigo);
        }
    }
	
	public void remover(Disciplina d) throws DisciplinaNExisteException{
		
        if (this.disciplinas.contains(d)) {
            this.disciplinas.remove(d);
            this.salvarArquivo();
        } 
		
		else {
			throw new DisciplinaNExisteException(d);
        }
    }
	
}
