package beans;

public class Professor extends Pessoa {
	private int nDisciplinas;
	private String[] disciplinas;
	private int nFormacao;
	private Formacao[] formacoes;
	private int nAreasInt;
	private String[] areasInt;
	private int nCursos;
	private String[] cursos;
	//private Horario horario;
	
	public Professor(String nome,String cpf,String endereco,String email){
		super(nome,cpf,endereco,email);
		this.nDisciplinas=0;
		this.nCursos=0;
		this.nFormacao=0;
	}
}
