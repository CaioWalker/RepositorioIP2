package beans;

public class Turma {
	private String nome;
	private int nProfCand;
	private String[] profCand=new String[1];
	private String nomeProf;
	private String disciplina;
	
	public Turma(String nome,String disciplina){
		this.setNome(nome);
		this.nProfCand=0;
		this.nomeProf = "Indefinido";
		this.disciplina=disciplina;
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
	
	public String getDisciplina(){
		return this.disciplina;
	}
	
	public void candidatarProf(Professor p){
		if(nProfCand==0&&profCand[0]==null){
			this.profCand[nProfCand]=((Professor) p).getNome();
			this.nProfCand++;
		}
		else{
			String[] temp = new String[nProfCand+1];
			for(int i=0;i<=nProfCand;i++){
				temp[i]=profCand[i];
			}
			this.profCand= new String[nProfCand+1];
			for(int i=0;i<=nProfCand;i++){
				profCand[i]=temp[i];
			}
			this.profCand[nProfCand]=((Professor) p).getNome();
			this.nProfCand++;
		}
	}
	
	public void imprimeProfCand(){
		System.out.println("\nProfessores candidatos:");
		for(int i =0;i<nProfCand;i++){
			if(this.profCand[i]!=null){
				System.out.println(i+"-"+profCand[i]);
			}
		}	
	}
	
	public void definirProfessor(Professor p){
		this.nomeProf=((Professor) p).getNome();
	}
	
	public String getNomeProfessor(){
		return this.nomeProf;
	}
	
	public String toString(){
		String resultado="\nNome: "+this.nome+" Professor: "+this.nomeProf;
		return resultado;
	}

}
