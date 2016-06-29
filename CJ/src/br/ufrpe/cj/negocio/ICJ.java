package br.ufrpe.cj.negocio;

import java.util.ArrayList;

import br.ufrpe.cj.beans.AlocProfDisc;
import br.ufrpe.cj.beans.Apto;
import br.ufrpe.cj.beans.Aula;
import br.ufrpe.cj.beans.Curso;
import br.ufrpe.cj.beans.Disciplina;
import br.ufrpe.cj.beans.Professor;
import br.ufrpe.cj.beans.Semestre;
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

public interface ICJ {
	void alocarProfessorDisciplina(Professor p, Disciplina d) 
			throws HrInicioOcupadaException, HrInicioDentrodeUmaAulaException, DisciplinaNContemAulaException, ProfessorNAptoException, AlocacaoJaExisteException;

	void removerAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException;
	
	void validarAlocacao(Professor p, Disciplina d) throws AlocacaoNExisteException, DisciplinaAlocadaException;
	
	AlocProfDisc procurarAlocacaoCodigo(String codigo) throws AlocacaoCodigoNExisteException;
	
	AlocProfDisc getAlocacao(Professor p, Disciplina d, Semestre s) throws AlocacaoNExisteException;
	
	ArrayList<AlocProfDisc> alocacoesProfessor(Professor p, Semestre s) throws ProfessorSemAlocException;
	
	ArrayList<AlocProfDisc> alocacoesDisciplina(Disciplina d, Semestre s) throws DisciplinaSemAlocException;
	
	ArrayList<AlocProfDisc> alocacoesSemestre(Semestre s) throws SemestreSemAlocException;
	
	ArrayList<AlocProfDisc> getAlocacoesPendentes(Curso c) throws CursoSemAlocPendenteException;
	
	ArrayList<AlocProfDisc> getAlocacoesValidas(Curso c, Semestre s) throws CursoSemAlocValidaException;
	
	ArrayList<AlocProfDisc> getAlocacoes() throws BDSemAlocException;
	
	void cadastrarCurso(String nome, String descricao) throws CursoJaExisteException;
	
	Curso procurarCursoCodigo(String codigo) throws CursoCodigoNExisteException;
	
	Curso procurarCursoNome(String nome) throws CursoNomeNExisteException;
	
	void removerCurso(Curso c) throws CursoNExisteException;
	
	void setCoodenadorCurso(Curso c, Professor p) throws ProfessorNCoodenadorException, CoordenadorOcupado, CoordenadorCursoSetadoException;
	
	void removerCoodenadorCurso(Curso c) throws CursoCodigoNExisteException;
	
	ArrayList<Curso> cursosSemCoordenador() throws SemCursosSemCoordException;
	
	ArrayList<Curso> cursosComCoordenador() throws SemCursosComCoordException;
	
	void cadastrarDisciplina(String nome, String descricao, Curso curso)throws DisciplinaJaExisteException;
	
	Disciplina procurarDisciplinaCodigo(String codigo) throws DisciplinaCodigoNExisteException;
	
	Disciplina procurarDisciplinaNome(String nome) throws DiscNomeNExisteException;
	
	ArrayList<Disciplina> disciplinasCurso(Curso c) throws SemDiscException;
	
	ArrayList<Disciplina> disciplinasSemAula(Curso c) throws SemDiscSemAulaException;
	
	void removerDisciplina(Disciplina d) throws DisciplinaNExisteException;
	
	void cadastrarProfessor(String nome,String cpf,String endereco,String email,String senha) throws ProfessorJaCadastradoException;
	
	Professor procurarProfessorCpf(String cpf) throws ProfessorCpfNExisteException;
	
	Professor procurarProfessorNome(String nome) throws ProfessorNomeNExisteException;
	
	Professor procurarProfessorEmail(String email) throws ProfessorEmailNExisteException;
	
	ArrayList<Professor> professoresFormPend() throws NoFormPendentesException;
	
	void removerProfessor(Professor p) throws ProfessorNExisteException;
	
	void cadastrarSemestre(String descricao);
	
	Semestre procurarSemestreNome(String nome) throws SemestreNExisteException;
	
	Semestre getSemstreCorrente();
	
	void habilitarProfessorDisciplina(Professor p, Disciplina d) throws AptidaoJaCadastradaException;
	
	void removerAptidao(Apto a) throws AptidaoNExisteException;
	
	Apto procurarAptidaoCodigo(String codigo) throws AptidiaoCodigoNExisteException;
	
	ArrayList<Apto> aptidoesProfessor(Professor p) throws ProfessorSemAptidoesException;
	
	ArrayList<Apto> aptidoesDisciplina(Disciplina d) throws DisciplinaSemAptosException;
	
	ArrayList<Apto> getValidacoesAptoPendentes() throws NoValidacoesAptoPendentes;
	
	void setProfessorCoordenador(String cpf, boolean v) throws ProfessorCpfNExisteException;
	
	void validarAptidao(String codigo,boolean v) throws AptidiaoCodigoNExisteException;
	
	void addAulaDisciplina(String codigo,Aula a) throws ChoqueHorarioDiscException, DisciplinaCodigoNExisteException;
	
	Curso procurarCursoCoordenador(Professor p) throws CursoCoordenadorNExisteException;
	
	Professor procurarEmailSenha(String email, String senha) throws ProfessorEmailSenhaNExisteException;
	
	
	
}
