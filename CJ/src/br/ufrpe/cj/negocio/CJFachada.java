package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.AlocProfDisc;
import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Aula;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;
import br.ufrpe.cj.dados.RepositorioAlocProfDisc;
import br.ufrpe.cj.dados.RepositorioApto;
import br.ufrpe.cj.dados.RepositorioCurso;
import br.ufrpe.cj.dados.RepositorioDisciplinas;
import br.ufrpe.cj.dados.RepositorioProfessor;
import br.ufrpe.cj.dados.RepositorioSemestre;
import br.ufrpe.cj.exceptions.AlocacaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.AlocacaoJaExisteException;
import br.ufrpe.cj.exceptions.AlocacaoNExisteException;
import br.ufrpe.cj.exceptions.AptidaoJaCadastradaException;
import br.ufrpe.cj.exceptions.AptidaoNExisteException;
import br.ufrpe.cj.exceptions.AptidiaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.BDSemAlocException;
import br.ufrpe.cj.exceptions.ChoqueHorarioDiscException;
import br.ufrpe.cj.exceptions.CoordenadorCursoSetadoException;
import br.ufrpe.cj.exceptions.CoordenadorOcupado;
import br.ufrpe.cj.exceptions.CursoCodigoNExisteException;
import br.ufrpe.cj.exceptions.CursoCoordenadorNExisteException;
import br.ufrpe.cj.exceptions.CursoJaExisteException;
import br.ufrpe.cj.exceptions.CursoNExisteException;
import br.ufrpe.cj.exceptions.CursoNomeNExisteException;
import br.ufrpe.cj.exceptions.CursoSemAlocPendenteException;
import br.ufrpe.cj.exceptions.CursoSemAlocValidaException;
import br.ufrpe.cj.exceptions.DiscNomeNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaAlocadaException;
import br.ufrpe.cj.exceptions.DisciplinaCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaJaExisteException;
import br.ufrpe.cj.exceptions.DisciplinaNContemAulaException;
import br.ufrpe.cj.exceptions.DisciplinaNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaSemAlocException;
import br.ufrpe.cj.exceptions.DisciplinaSemAptosException;
import br.ufrpe.cj.exceptions.HrInicioDentrodeUmaAulaException;
import br.ufrpe.cj.exceptions.HrInicioOcupadaException;
import br.ufrpe.cj.exceptions.NoFormPendentesException;
import br.ufrpe.cj.exceptions.NoValidacoesAptoPendentes;
import br.ufrpe.cj.exceptions.ProfessorCpfNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailSenhaNExisteException;
import br.ufrpe.cj.exceptions.ProfessorJaCadastradoException;
import br.ufrpe.cj.exceptions.ProfessorNAptoException;
import br.ufrpe.cj.exceptions.ProfessorNCoodenadorException;
import br.ufrpe.cj.exceptions.ProfessorNExisteException;
import br.ufrpe.cj.exceptions.ProfessorNomeNExisteException;
import br.ufrpe.cj.exceptions.ProfessorSemAlocException;
import br.ufrpe.cj.exceptions.ProfessorSemAptidoesException;
import br.ufrpe.cj.exceptions.SemCursosComCoordException;
import br.ufrpe.cj.exceptions.SemCursosSemCoordException;
import br.ufrpe.cj.exceptions.SemDiscException;
import br.ufrpe.cj.exceptions.SemDiscSemAulaException;
import br.ufrpe.cj.exceptions.SemestreNExisteException;
import br.ufrpe.cj.exceptions.SemestreSemAlocException;

public class CJFachada implements ICJ{
	private AlocarProfessorDisciplina alocacoes;
	private CadastrarCurso cursos;
	private CadastrarDisciplina disciplinas;
	private CadastrarProfessor professores;
	private CadastrarSemestre semestres;
	private HabilitarProfessorDisciplina aptidoes;
	
	private static ICJ instance;
	
	public static ICJ getInstance() {
	    if (instance == null) {
	      instance = new CJFachada();
	    }
	    return instance;
	  }
	
	private CJFachada(){
		this.alocacoes = new AlocarProfessorDisciplina(RepositorioAlocProfDisc.getInstance(), RepositorioSemestre.getInstance(), RepositorioApto.getInstance());
		this.cursos = new CadastrarCurso(RepositorioCurso.getInstance());
		this.disciplinas = new CadastrarDisciplina(RepositorioDisciplinas.getInstance());
		this.professores = new CadastrarProfessor(RepositorioProfessor.getInstance());
		this.semestres = new CadastrarSemestre(RepositorioSemestre.getInstance());
		this.aptidoes = new HabilitarProfessorDisciplina(RepositorioApto.getInstance());
	}

@Override
public void alocarProfessorDisciplina(Professor p, Disciplina d)
		throws HrInicioOcupadaException, HrInicioDentrodeUmaAulaException, DisciplinaNContemAulaException,
		ProfessorNAptoException, AlocacaoJaExisteException {
	this.alocacoes.alocarProfessorDisciplina(p, d);
}

@Override
public void removerAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException {
	this.alocacoes.removerAlocacao(p, d);
}

@Override
public void validarAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException, DisciplinaAlocadaException {
	this.alocacoes.validarAlocacao(p, d);
}

@Override
public AlocProfDisc procurarAlocacaoCodigo(String codigo) throws AlocacaoCodigoNExisteException {
	return this.alocacoes.procurarAlocacaoCodigo(codigo);
}

@Override
public AlocProfDisc getAlocacao(Professor p, Disciplina d, Semestre s) throws AlocacaoNExisteException {
	return this.alocacoes.getAlocacao(p, d, s);
}

@Override
public ArrayList<AlocProfDisc> alocacoesProfessor(Professor p, Semestre s) throws ProfessorSemAlocException {
	return this.alocacoes.alocacoesProfessor(p, s);
}

@Override
public ArrayList<AlocProfDisc> alocacoesDisciplina(Disciplina d, Semestre s) throws DisciplinaSemAlocException {
	return this.alocacoes.alocacoesDisciplina(d, s);
}

@Override
public ArrayList<AlocProfDisc> alocacoesSemestre(Semestre s) throws SemestreSemAlocException {
	return this.alocacoes.alocacoesSemestre(s);
}

@Override
public ArrayList<AlocProfDisc> getAlocacoesPendentes(Curso c) throws CursoSemAlocPendenteException {
	return this.alocacoes.getAlocacoesPendentes(c);
}

@Override
public ArrayList<AlocProfDisc> getAlocacoesValidas(Curso c, Semestre s) throws CursoSemAlocValidaException {
	return this.alocacoes.getAlocacoesValidas(c, s);
}

@Override
public ArrayList<AlocProfDisc> getAlocacoes() throws BDSemAlocException {
	return this.alocacoes.getAlocacoes();
}

@Override
public void cadastrarCurso(String nome, String descricao) throws CursoJaExisteException {
	this.cursos.cadastrarCurso(nome, descricao);
	
}

@Override
public Curso procurarCursoCodigo(String codigo) throws CursoCodigoNExisteException {
	return this.cursos.procurarCursoCodigo(codigo);
}

@Override
public Curso procurarCursoNome(String nome) throws CursoNomeNExisteException {
	return this.cursos.procurarCursoNome(nome);
}

@Override
public void removerCurso(Curso c) throws CursoNExisteException {
	this.cursos.removerCurso(c);	
}

@Override
public void setCoodenadorCurso(Curso c, Professor p)
		throws ProfessorNCoodenadorException, CoordenadorOcupado, CoordenadorCursoSetadoException {
	this.cursos.setCoodenadorCurso(c, p);
	
}

@Override
public void removerCoodenadorCurso(Curso c) throws CursoCodigoNExisteException {
	this.cursos.removerCoodenadorCurso(c);
	
}

@Override
public ArrayList<Curso> cursosSemCoordenador() throws SemCursosSemCoordException {
	return this.cursos.cursosSemCoordenador();
}

@Override
public ArrayList<Curso> cursosComCoordenador() throws SemCursosComCoordException {
	return this.cursos.cursosComCoordenador();
}

@Override
public void cadastrarDisciplina(String nome, String descricao, Curso curso) throws DisciplinaJaExisteException {
	this.disciplinas.cadastrarDisciplina(nome, descricao, curso);
}

@Override
public Disciplina procurarDisciplinaCodigo(String codigo) throws DisciplinaCodigoNExisteException {
	return this.disciplinas.procurarDisciplinaCodigo(codigo);
}

@Override
public Disciplina procurarDisciplinaNome(String nome) throws DiscNomeNExisteException {
	return this.disciplinas.procurarDisciplinaNome(nome);
}

@Override
public ArrayList<Disciplina> disciplinasCurso(Curso c) throws SemDiscException {
	return this.disciplinas.disciplinasCurso(c);
}

@Override
public ArrayList<Disciplina> disciplinasSemAula(Curso c) throws SemDiscSemAulaException {
	return this.disciplinas.disciplinasSemAula(c);
}

@Override
public void removerDisciplina(Disciplina d) throws DisciplinaNExisteException {
	this.disciplinas.removerDisciplina(d);	
}

@Override
public void cadastrarProfessor(String nome, String cpf, String endereco, String email, String senha)
		throws ProfessorJaCadastradoException {
	this.professores.cadastrarProfessor(nome, cpf, endereco, email, senha);
}

@Override
public Professor procurarProfessorCpf(String cpf) throws ProfessorCpfNExisteException {
	return this.professores.procurarProfessorCpf(cpf);
}

@Override
public Professor procurarProfessorNome(String nome) throws ProfessorNomeNExisteException {
	return this.professores.procurarProfessorNome(nome);
}

@Override
public Professor procurarProfessorEmail(String email) throws ProfessorEmailNExisteException {
	return this.professores.procurarProfessorEmail(email);
}

@Override
public ArrayList<Professor> professoresFormPend() throws NoFormPendentesException {
	return this.professores.professoresFormPend();
}

@Override
public void removerProfessor(Professor p) throws ProfessorNExisteException {
	this.professores.remover(p);
}

@Override
public void cadastrarSemestre(String descricao) {
	this.semestres.cadastrarSemestre(descricao);
}

@Override
public Semestre procurarSemestreNome(String nome) throws SemestreNExisteException {
	return this.semestres.procurarSemestreNome(nome);
}

@Override
public Semestre getSemstreCorrente() {
	return this.semestres.getSemstreCorrente();
}

@Override
public void habilitarProfessorDisciplina(Professor p, Disciplina d) throws AptidaoJaCadastradaException {
	this.aptidoes.habilitarProfessorDisciplina(p, d);
	
}

@Override
public void removerAptidao(Apto a) throws AptidaoNExisteException {
	this.aptidoes.removerAptidao(a);	
}

@Override
public Apto procurarAptidaoCodigo(String codigo) throws AptidiaoCodigoNExisteException {
	return this.aptidoes.procurarAptidaoCodigo(codigo);
}

@Override
public ArrayList<Apto> aptidoesProfessor(Professor p) throws ProfessorSemAptidoesException {
	return this.aptidoes.aptidoesProfessor(p);
}

@Override
public ArrayList<Apto> aptidoesDisciplina(Disciplina d) throws DisciplinaSemAptosException {
	return this.aptidoes.aptidoesDisciplina(d);
}

@Override
public ArrayList<Apto> getValidacoesAptoPendentes() throws NoValidacoesAptoPendentes {
	return this.aptidoes.getValidacoesAptoPendentes();
}

public void setProfessorCoordenador(String cpf, boolean v) throws ProfessorCpfNExisteException {
	this.professores.setProfessorCoordenador(cpf, v);
}

@Override
public void validarAptidao(String codigo, boolean v) throws AptidiaoCodigoNExisteException {
	this.aptidoes.validarAptidao(codigo, v);
	
}

@Override
public void addAulaDisciplina(String codigo, Aula a)
		throws ChoqueHorarioDiscException, DisciplinaCodigoNExisteException {
	this.disciplinas.addAulaDisciplina(codigo, a);
	
}

@Override
public Curso procurarCursoCoordenador(Professor p) throws CursoCoordenadorNExisteException {
	return this.cursos.procurarCursoCoordenador(p);
}

@Override
public Professor procurarEmailSenha(String email, String senha) throws ProfessorEmailSenhaNExisteException {
	return professores.procurarEmailSenha(email, senha);
}
	
}
