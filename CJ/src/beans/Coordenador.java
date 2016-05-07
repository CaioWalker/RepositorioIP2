package beans;

public class Coordenador extends Pessoa{
	private String curso;
	
	public Coordenador(String nome,String cpf,String endereco,String email,String curso){
		super(nome,cpf,endereco,email);
		this.curso=curso;
	}
	
	public void validarProfDisc(Professor p,int nProf, Disciplina d, int nDisc){
		d.validarProfessor(p, nProf);
		p.cadastrarDisciplina(d);
	}
	
	public void validarProfForm(Professor p, int nFormacao){
		p.validarFormacao(true, nFormacao);
	}
	
	public void alocarProfCurso(Professor p, Curso c, int nProf){
		c.validarProfessor(p, nProf);
		p.addcurso(c);
	}
	
	public void alocarProfTurma(Professor p, Turma t){
		if(p.checarDisc(t.getDisciplina())){
			t.definirProfessor(p);
		}
	}
	
	public String toString(){
		String resultado="\nNome: "+this.getNome()+"\nEndereco: "+this.getEndereco()+"\nCPF: "+this.getCpf()+"\nEmail: "+this.getEmail()+"\nCoordenador do Curso: "+this.curso;
		return resultado;
	}

}
