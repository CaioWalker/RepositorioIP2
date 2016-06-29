package br.ufrpe.cj.negocio;

import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.dados.IRepositorioSemestre;
import br.ufrpe.cj.exceptions.SemestreNExisteException;

public class CadastrarSemestre {
	private IRepositorioSemestre repositorioSemestre;
	
	public CadastrarSemestre(IRepositorioSemestre instanciaRepositorio){
		this.repositorioSemestre = instanciaRepositorio;
	}
	
	public void cadastrarSemestre(String descricao){
		this.repositorioSemestre.cadastrar(descricao);
	}
	
	public Semestre procurarSemestreNome(String nome) throws SemestreNExisteException{
		return this.repositorioSemestre.procurarNome(nome);
	}
	
	public Semestre getSemstreCorrente() {
		return this.repositorioSemestre.getSemstreCorrente();
	}

}
