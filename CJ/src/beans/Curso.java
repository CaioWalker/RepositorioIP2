package beans;

public class Curso {
	private String nome;
	private String descricao;
	private Coordenador coordenador;
	private int nPeriodos;
	private Periodo periodos[]=new Periodo[1];
	private int nProfessores;
	private String[] professores=new String[1];
	private int nCandidatos;
	private String[] candidatos=new String[1];
	
	public Curso(String nome,String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		nPeriodos=0;
		nProfessores=0;
		nCandidatos=0;
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
	
	public int getNPeriodos(){
		return this.nPeriodos;
	}
	
	public Periodo getPeriodo(int n){
		return periodos[n];
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

	public Coordenador getCoordenador() {
		return this.coordenador;
	}

	public void setCoordenador(String nome,String cpf,String endereco,String email) {
		this.coordenador = new Coordenador(nome,cpf,endereco,email,this.nome);
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
	
	public String toString(){
		String resultado="\nNome: "+this.nome+"\nDescricao: "+this.descricao;
		return resultado;
	}

}
