package beans;

public class Periodo {
	private String nome;
	
	private Curso curso;
	
	public Periodo(int n){
		this.nome=n+"º periodo";
	}
	
	public String getNome(){
		return this.nome;
	}
	
	
	
	
	public String toString(){
		String resultado=this.getNome()+" "+this.getNDisciplinasCadas()+" Disciplinas";
		return resultado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
