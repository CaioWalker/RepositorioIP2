package beans;

public class Semestre {
	private String nome;
	private String descricao;
	private int nCursos;
	private Curso[] cursos=new Curso[1];
	private int nProfessores;
	private Professor[] professores=new Professor[1];
	
	public Semestre(String nome, String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.nCursos=0;
		this.nProfessores=0;
		
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
	
	public Curso getCurso(int n){
		return this.cursos[n];
	}
	
	public void cadastrarCurso(String nome,String descricao){
		if(nCursos==0&&cursos[0]==null){
			this.cursos[nCursos]=new Curso(nome,descricao);
			this.nCursos++;
		}
		else{
			Curso[] temp = new Curso[nCursos+1];
			for(int i=0;i<=nCursos;i++){
				temp[i]=cursos[i];
			}
			this.cursos= new Curso[nCursos+1];
			for(int i=0;i<=nCursos;i++){
				cursos[i]=temp[i];
			}
			this.cursos[nCursos]=new Curso(nome,descricao);
			this.nCursos++;
		}
	}
	
	public void imprimeCursos(){
		System.out.println("\nCursos:\n");
		for(int i =0;i<nCursos;i++){
			if(this.cursos[i]!=null){
				System.out.println(cursos[i].getNome());
			}
		}	
	}
	
	public int getNProfessores(){
		return this.nProfessores;
	}
	
	public Professor getProfessor(int n){
		return this.professores[n];
	}
	
	
	public void cadastrarProfessor(String nome,String cpf,String endereco,String email){
		if(nProfessores==0&&professores[0]==null){
			this.professores[nProfessores]=new Professor(nome,cpf,endereco,email);
			this.nProfessores++;
		}
		else{
			Professor[] temp = new Professor[nProfessores+1];
			for(int i=0;i<=nProfessores;i++){
				temp[i]=professores[i];
			}
			this.professores= new Professor[nProfessores+1];
			for(int i=0;i<=nProfessores;i++){
				professores[i]=temp[i];
			}
			this.professores[nProfessores]=new Professor(nome,cpf,endereco,email);
			this.nProfessores++;
		}
	}
	
	public void imprimeProfessores(){
		System.out.println("\nProfessores:");
		for(int i =0;i<nProfessores;i++){
			if(this.professores[i]!=null){
				System.out.println(professores[i].getNome());
			}
		}	
	}
	
	public String toString(){
		String resultado="\n Semestre: "+this.nome+" Cursos Ofertados: "+this.nCursos+" Professores Cadastrados: "+this.nProfessores;
		return resultado;
	}

}


