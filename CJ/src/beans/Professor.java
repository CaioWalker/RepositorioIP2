package beans;

public class Professor extends Pessoa {
	private int nFormacao;
	private Formacao[] formacoes = new Formacao[1];
	private int nAreasInt;
	private AreasInt[] areasInt=new AreasInt[1];
	private Boolean coordenador;
	
	public Professor(String nome,String cpf,String endereco,String email){
		super(nome,cpf,endereco,email);
		this.setCoordenador(false);
		this.nAreasInt=0;
		this.nFormacao=0;
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
	
	public void addAreasInt(String titulo,String descricao){
		if(nAreasInt==0&&areasInt[0]==null){
			this.areasInt[nAreasInt]=new AreasInt(titulo,descricao);
			this.nAreasInt++;
		}
		else{
			AreasInt[] temp = new AreasInt[nAreasInt+1];
			for(int i=0;i<=nAreasInt;i++){
				temp[i]=areasInt[i];
			}
			this.areasInt= new AreasInt[nAreasInt+1];
			for(int i=0;i<=nAreasInt;i++){
				areasInt[i]=temp[i];
			}
			this.areasInt[nAreasInt]=new AreasInt(titulo,descricao);
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


	public Boolean getCoordenador() {
		return coordenador;
	}


	public void setCoordenador(Boolean coordenador) {
		this.coordenador = coordenador;
	}
		
	
}
