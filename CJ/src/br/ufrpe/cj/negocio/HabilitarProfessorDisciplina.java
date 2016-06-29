package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.dados.IRepositorioApto;
import br.ufrpe.cj.exceptions.AptidaoJaCadastradaException;
import br.ufrpe.cj.exceptions.AptidaoNExisteException;
import br.ufrpe.cj.exceptions.AptidiaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaSemAptosException;
import br.ufrpe.cj.exceptions.NoValidacoesAptoPendentes;
import br.ufrpe.cj.exceptions.ProfessorSemAptidoesException;

public class HabilitarProfessorDisciplina {
	
	private IRepositorioApto repositorioApto;
	
	public HabilitarProfessorDisciplina(IRepositorioApto instanciaRepositorio){
		this.repositorioApto = instanciaRepositorio;
	}
	
	public void habilitarProfessorDisciplina(Professor p, Disciplina d) throws AptidaoJaCadastradaException{
		this.repositorioApto.cadastrar(p, d);
		this.repositorioApto.salvarArquivo();
	}
	
	public void removerAptidao(Apto a) throws AptidaoNExisteException{
		this.repositorioApto.remover(a);
		this.repositorioApto.salvarArquivo();
	}
	
	public Apto procurarAptidaoCodigo(String codigo) throws AptidiaoCodigoNExisteException{
		return this.repositorioApto.procurarCodigo(codigo);
	}

	public ArrayList<Apto> getValidacoesAptoPendentes() throws NoValidacoesAptoPendentes{
		if(this.repositorioApto.getValidacoesPendentes().size()==0){
			throw new NoValidacoesAptoPendentes();
		}
		return this.repositorioApto.getValidacoesPendentes();
	}
	
	public ArrayList<Apto> aptidoesProfessor(Professor p) throws ProfessorSemAptidoesException{
		if(this.repositorioApto.aptidoesProfessor(p).size()==0){
			throw new ProfessorSemAptidoesException(p);
		}
		return this.repositorioApto.aptidoesProfessor(p);
	}
	
	public ArrayList<Apto> aptidoesDisciplina(Disciplina d) throws DisciplinaSemAptosException{
		if(this.repositorioApto.aptidoesDisciplina(d).size()==0){
			throw new DisciplinaSemAptosException(d);
		}
		
		return this.repositorioApto.aptidoesDisciplina(d);
	}
	
	public void validarAptidao(String codigo,boolean v) throws AptidiaoCodigoNExisteException{
		this.repositorioApto.procurarCodigo(codigo).setValidacao(v);
		this.repositorioApto.salvarArquivo();
	}
	
	


}
