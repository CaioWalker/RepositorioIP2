package beans;

public class Disciplina {
	private String nome;
	private String descricao;
	private String codigo;
	private int nTurmas;
	private Turma[] turmas=new Turma[1];
	
	public Disciplina(String nome,String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.nTurmas=0;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public Boolean equals(Disciplina d){
		if(d!=null){
			if(d.getNome().equals(this.nome)&&d.getCodigo().equals(this.codigo)){
				return true;
			}
			else{
				return false;
			} 	
		}
		else{
			return false;
		}
	}
	
}
