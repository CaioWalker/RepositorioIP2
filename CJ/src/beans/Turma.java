package beans;

public class Turma {
	private String nome;
	private int nProfCand;
	private String[] profCand;
	private String nomeProf;
	
	public Turma(String nome){
		this.setNome(nome);
		this.nProfCand=0;
		this.nomeProf = "Indefinido";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNProfCand(){
		if(this.nProfCand==0&&this.profCand[0].equals("indefinido")){
			return 0;
		}
		else{
			return this.nProfCand-1;
		}
	}
	
	public void candidatarProf(Professor p){
		this.profCand[this.nProfCand]=p.getNome();
		this.nProfCand++;
	}
	
	public void definirProfessor(int posicao){
		if(this.profCand[posicao]!=null){
		this.nomeProf = this.profCand[posicao];
		}
	}
	
	public String toString(){
		String resultado="\nNome: "+this.nome+" Professor: "+this.nomeProf;
		return resultado;
	}

}
