package br.ufrpe.cj;

import br.ufrpe.cj.beans.Aula;
import br.ufrpe.cj.exceptions.AlocacaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.AlocacaoJaExisteException;
import br.ufrpe.cj.exceptions.AlocacaoNExisteException;
import br.ufrpe.cj.exceptions.AptidaoJaCadastradaException;
import br.ufrpe.cj.exceptions.AptidaoNExisteException;
import br.ufrpe.cj.exceptions.AptidiaoCodigoNExisteException;
import br.ufrpe.cj.exceptions.ChoqueHorarioDiscException;
import br.ufrpe.cj.exceptions.CoordenadorCursoSetadoException;
import br.ufrpe.cj.exceptions.CoordenadorOcupado;
import br.ufrpe.cj.exceptions.CursoCodigoNExisteException;
import br.ufrpe.cj.exceptions.CursoJaExisteException;
import br.ufrpe.cj.exceptions.CursoNomeNExisteException;
import br.ufrpe.cj.exceptions.CursoSemAlocPendenteException;
import br.ufrpe.cj.exceptions.CursoSemAlocValidaException;
import br.ufrpe.cj.exceptions.DiscNomeNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaAlocadaException;
import br.ufrpe.cj.exceptions.DisciplinaCodigoNExisteException;
import br.ufrpe.cj.exceptions.DisciplinaJaExisteException;
import br.ufrpe.cj.exceptions.DisciplinaNContemAulaException;
import br.ufrpe.cj.exceptions.HrInicioDentrodeUmaAulaException;
import br.ufrpe.cj.exceptions.HrInicioOcupadaException;
import br.ufrpe.cj.exceptions.NoValidacoesAptoPendentes;
import br.ufrpe.cj.exceptions.ProfessorCpfNExisteException;
import br.ufrpe.cj.exceptions.ProfessorEmailSenhaNExisteException;
import br.ufrpe.cj.exceptions.ProfessorJaCadastradoException;
import br.ufrpe.cj.exceptions.ProfessorNAptoException;
import br.ufrpe.cj.exceptions.ProfessorNCoodenadorException;
import br.ufrpe.cj.exceptions.ProfessorSemAlocException;
import br.ufrpe.cj.exceptions.SemCursosSemCoordException;
import br.ufrpe.cj.negocio.CJFachada;
import br.ufrpe.cj.negocio.ICJ;

public class Principal {
	public static void main(String[] args) throws ProfessorJaCadastradoException, CursoJaExisteException, ProfessorCpfNExisteException, ProfessorNCoodenadorException, CoordenadorOcupado, CoordenadorCursoSetadoException, CursoNomeNExisteException, DisciplinaJaExisteException, ChoqueHorarioDiscException, DiscNomeNExisteException, HrInicioOcupadaException, HrInicioDentrodeUmaAulaException, DisciplinaNContemAulaException, ProfessorNAptoException, AlocacaoJaExisteException, AptidaoJaCadastradaException, CursoSemAlocPendenteException, SemCursosSemCoordException, CursoCodigoNExisteException, CursoSemAlocValidaException, AlocacaoNExisteException, NoValidacoesAptoPendentes, AptidiaoCodigoNExisteException, AptidaoNExisteException, DisciplinaCodigoNExisteException, ProfessorSemAlocException, AlocacaoCodigoNExisteException, DisciplinaAlocadaException, ProfessorEmailSenhaNExisteException{
		
		ICJ  fachada = CJFachada.getInstance();		
		
		fachada.cadastrarSemestre("primeiro");
//		
		fachada.cadastrarProfessor("leandro", "12345678912", "algun lugar", "leandro@gmail.com", "123456");
//		
		fachada.procurarProfessorCpf("12345678912").addFormacao("dr em alguma coisa", "descricao");
		
		
		System.out.println(fachada.procurarEmailSenha("leandro@gmail.com", "123456"));
		
		fachada.procurarProfessorCpf("12345678912").validarFormacao(fachada.procurarProfessorCpf("12345678912").getFormacaoPendente().get(0));
		
		System.out.println(fachada.procurarProfessorCpf("12345678912").getFormacao());
//	
		fachada.cadastrarCurso("computacao", "de computador");
//		
//		
		fachada.setProfessorCoordenador("12345678912", true);
//		
//	
		fachada.setCoodenadorCurso(fachada.procurarCursoNome("computacao"), fachada.procurarProfessorCpf("12345678912"));
//		
		fachada.cadastrarDisciplina("POO", "alguma coisa", fachada.procurarCursoNome("computacao"));
//		
		fachada.addAulaDisciplina("1001", new Aula("Segunda",14,00,16,00));
		fachada.addAulaDisciplina("1001", new Aula("Quarta",16,0,18,00));
//		
		fachada.habilitarProfessorDisciplina(fachada.procurarProfessorCpf("12345678912"), fachada.procurarDisciplinaNome("POO"));
//		
//		
		System.out.println(fachada.procurarAptidaoCodigo("3001"));
//		
		fachada.validarAptidao("3001", true);
//		
		System.out.println(fachada.procurarAptidaoCodigo("3001"));
//		
//		
		fachada.alocarProfessorDisciplina(fachada.procurarProfessorCpf("12345678912"), fachada.procurarDisciplinaNome("POO"));
//		
		System.out.println(fachada.getAlocacoesPendentes(fachada.procurarCursoNome("computacao")));
		
		fachada.getAlocacoesPendentes(fachada.procurarCursoNome("computacao")).get(0).setValidacao(true);
//		
		System.out.println(fachada.getAlocacoesValidas(fachada.procurarCursoNome("computacao"),fachada.getSemstreCorrente()));

	}
}
	

	
