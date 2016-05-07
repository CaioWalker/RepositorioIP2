package beans;

public class Instituicao {
	private String nome;
	private String descricao;
	private String endereco;
	private int nSemestres;
	private Semestre[] semestres=new Semestre[1];
	
	public Instituicao(String nome,String descricao,String endereco){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setEndereco(endereco);
		this.nSemestres=0;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getNSemestres(){
		return this.nSemestres;
	}
	
	public Semestre getSemestre(int n){
		return this.semestres[n];
	}
	
	public void cadastrarSemestre(String nome,String descricao){
		if(nSemestres==0&&semestres[0]==null){
			this.semestres[nSemestres]=new Semestre(nome,descricao);
			this.nSemestres++;
		}
		else{
			Semestre[] temp = new Semestre[nSemestres+1];
			for(int i=0;i<=nSemestres;i++){
				temp[i]=semestres[i];
			}
			this.semestres= new Semestre[nSemestres+1];
			for(int i=0;i<=nSemestres;i++){
				semestres[i]=temp[i];
			}
			this.semestres[nSemestres]=new Semestre(nome,descricao);
			this.nSemestres++;
		}
	}
	
	public void imprimeSemestre(){
		System.out.println("\nSemestres:\n");
		for(int i =0;i<nSemestres;i++){
			if(this.semestres[i]!=null){
				System.out.println(semestres[i].getNome());
			}
		}	
	}
	
	public String toString(){
		String resultado ="Instituicao: "+this.nome+"\n"+this.descricao+"\nEndereco: "+this.endereco;
		return resultado;
	}
	

}
