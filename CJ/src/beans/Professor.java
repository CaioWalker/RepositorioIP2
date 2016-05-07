package beans;

public class Professor extends Pessoa {
	private int nDisciplinas;
	private String[] disciplinas=new String[1];
	private int nFormacao;
	private Formacao[] formacoes = new Formacao[1];
	private int nAreasInt;
	private String[] areasInt=new String[1];
	private int nCursos;
	private String[] cursos;
	//private Horario horario;
	
	public Professor(String nome,String cpf,String endereco,String email){
		super(nome,cpf,endereco,email);
		this.nDisciplinas=0;
		this.nCursos=0;
		this.nFormacao=0;
	}
	
	public void cadastrarDisciplina(Disciplina d){
		if(nDisciplinas==0&&disciplinas[0]==null){
			this.disciplinas[nDisciplinas]=d.getNome();
			this.nDisciplinas++;
		}
		else{
			String[] temp = new String[nDisciplinas+1];
			for(int i=0;i<=nDisciplinas;i++){
				temp[i]=disciplinas[i];
			}
			this.disciplinas= new String[nDisciplinas+1];
			for(int i=0;i<=nDisciplinas;i++){
				disciplinas[i]=temp[i];
			}
			this.disciplinas[nDisciplinas]=d.getNome();
			this.nDisciplinas++;
		}
	}
	
	public void imprimeDisciplinas(){
		System.out.println("\nDisciplinas:");
		for(int i =0;i<nDisciplinas;i++){
			if(this.disciplinas[i]!=null){
				System.out.println(disciplinas[i]);
			}
		}	
	}
	
	public void addFormacao(String titulo, String descricao){
		if(nFormacao==0&&formacoes[0]==null){
			this.formacoes[nFormacao]=new Formacao(titulo,descricao);
			this.nFormacao++;
		}
		else{
			Formacao[] temp = new Formacao[nFormacao+1];
			for(int i=0;i<=nFormacao;i++){
				temp[i]=formacoes[i];
			}
			this.formacoes= new Formacao[nFormacao+1];
			for(int i=0;i<=nFormacao;i++){
				formacoes[i]=temp[i];
			}
			this.formacoes[nFormacao]=new Formacao(titulo,descricao);
			this.nFormacao++;
		}
	}
	
	public void validarFormacao(Boolean estado,int nForm){
		this.formacoes[nForm].setEstado(estado);
	}
	
	public void imprimeFormacao(){
		System.out.println("\nFormacao");
		for(int i =0;i<nFormacao;i++){
			if(this.formacoes[i]!=null&&this.formacoes[i].getEstado()==true){
				System.out.println(formacoes[i]);
			}
		}	
	}
	
	public void imprimeFormacaoPendente(){
		System.out.println("\nFormacoes pendentes:");
		for(int i =0;i<nFormacao;i++){
			if(this.formacoes[i]!=null&&this.formacoes[i].getEstado()==false){
				System.out.println(i+"-"+formacoes[i]);
			}
		}	
	}
	
	public void addAreasInt(String area){
		if(nAreasInt==0&&areasInt[0]==null){
			this.areasInt[nAreasInt]=area;
			this.nAreasInt++;
		}
		else{
			String[] temp = new String[nAreasInt+1];
			for(int i=0;i<=nAreasInt;i++){
				temp[i]=areasInt[i];
			}
			this.areasInt= new String[nAreasInt+1];
			for(int i=0;i<=nAreasInt;i++){
				areasInt[i]=temp[i];
			}
			this.areasInt[nAreasInt]=area;
			this.nAreasInt++;
		}
	}
	
	public void imprimeAreasInt(){
		System.out.println("\nAreas de interesse:");
		for(int i =0;i<nAreasInt;i++){
			if(this.areasInt[i]!=null){
				System.out.println("->"+areasInt[i]);
			}
		}	
	}
	
	public void addcurso(Curso c){
		if(nCursos==0&&cursos[0]==null){
			this.cursos[nCursos]=c.getNome();
			this.nCursos++;
		}
		else{
			String[] temp = new String[nCursos+1];
			for(int i=0;i<=nCursos;i++){
				temp[i]=cursos[i];
			}
			this.cursos= new String[nCursos+1];
			for(int i=0;i<=nCursos;i++){
				cursos[i]=temp[i];
			}
			this.cursos[nCursos]=c.getNome();
			this.nCursos++;
		}	
	}
	
	public void imprimeCursos(){
		System.out.println("\nCursos:");
		for(int i =0;i<nCursos;i++){
			if(this.cursos[i]!=null){
				System.out.println(cursos[i]);
			}
		}	
	}
	
	public Boolean checarDisc(String nome){
		Boolean resultado=false;
		for(int i=0;i<nDisciplinas;i++){
			if(this.disciplinas[i].equals(nome)){
				resultado=true;
			}
		}
		return resultado;
	}
		
	
}
