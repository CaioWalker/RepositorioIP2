package beans;

public class Curso {
	private String nome;
	private String descricao;
	private int nPeriodos;
	private Periodo periodos[]=new Periodo[1];
	private Professor coordenador;	
	private String codigo;
	
	public Curso(String nome,String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		nPeriodos=0;
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
	
	public Professor getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(Professor coordenador) {
		this.coordenador = coordenador;
	}
	
	
	
	public String toString(){
		String resultado="\nNome: "+this.nome+"\nCoordenador: "+this.coordenador.getNome()
		+"\nDescricao: "+this.descricao;
		return resultado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
