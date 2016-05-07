package beans;

public class Disciplina {
	private String nome;
	private String descricao;
	private int nTurmas;
	private Turma[] turmas=new Turma[1];
	private int nProfessores;
	private String[] professores=new String[1];
	private int nCandidatos;
	private String[] candidatos= new String[1];
	
	public Disciplina(String nome,String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.nTurmas=0;
		this.nCandidatos=0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setNomeDescricao(String nome,String descricao){
		this.nome=nome;
		this.descricao=descricao;
	}
	
	public void candidatarProfessor(Professor p){
		if(nCandidatos==0&&candidatos[0]==null){
			this.candidatos[nCandidatos]=((Professor) p).getNome();
			this.nCandidatos++;
		}
		else{
			String[] temp = new String[nCandidatos+1];
			for(int i=0;i<=nCandidatos;i++){
				temp[i]=candidatos[i];
			}
			this.candidatos= new String[nCandidatos+1];
			for(int i=0;i<=nCandidatos;i++){
				candidatos[i]=temp[i];
			}
			this.candidatos[nCandidatos]=((Professor) p).getNome();
			this.nCandidatos++;
		}	
	}
	
	public void validarProfessor(Professor p,int n){
		if(((Professor) p).getNome().equals(candidatos[n])){
			if(nProfessores==0&&professores[0]==null){
				this.professores[nProfessores]=((Professor) p).getNome();
				this.nProfessores++;
			}
			else{
				String[] temp = new String[nProfessores+1];
				for(int i=0;i<=nProfessores;i++){
					temp[i]=professores[i];
				}
				this.professores= new String[nProfessores+1];
				for(int i=0;i<=nProfessores;i++){
					professores[i]=temp[i];
				}
				this.professores[nProfessores]=((Professor) p).getNome();
				this.nProfessores++;
			}
				
		}
	}
	
	public void imprimeProfCand(){
		System.out.println("\nProfessores candidatos:");
		for(int i =0;i<nCandidatos;i++){
			if(this.candidatos[i]!=null){
				System.out.println(i+"-"+candidatos[i]);
			}
		}	
	}
	
	public void imprimeProfessores(){
		System.out.println("\nProfessores candidatos:");
		for(int i =0;i<nProfessores;i++){
			if(this.professores[i]!=null){
				System.out.println(i+"-"+professores[i]);
			}
		}	
	}
	
	public void addTurma(String nome){
		if(nTurmas==0&&turmas[0]==null){
			this.turmas[nTurmas]=new Turma(nome,this.nome);
			this.nTurmas++;
		}
		else{
			Turma[] temp = new Turma[nTurmas+1];
			for(int i=0;i<=nTurmas;i++){
				temp[i]=turmas[i];
			}
			this.turmas= new Turma[nTurmas+1];
			for(int i=0;i<=nTurmas;i++){
				turmas[i]=temp[i];
			}
			this.turmas[nTurmas]=new Turma(nome,this.nome);
			this.nTurmas++;
		}
	}
	
	public void imprimeTurmas(){
		System.out.println("Turmas:\n");
		for(int i =0;i<nTurmas;i++){
			if(this.turmas[i]!=null){
				System.out.println("Turma:"+turmas[i].getNome()+" Professor: "+turmas[i].getNomeProfessor());
			}
		}	
	}
	
	public String toString(){
		String resultado = "Nome: "+this.nome+"\nDescricao: "+this.descricao;
		return resultado;
	}
	
}
