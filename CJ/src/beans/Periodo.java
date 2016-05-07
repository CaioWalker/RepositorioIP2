package beans;

public class Periodo {
	private String nome;
	private int nDisciplinasCadas;
	private Disciplina[] disciplinas = new Disciplina[1];
	
	public Periodo(int n){
		this.nome=n+"º periodo";
		this.nDisciplinasCadas=0;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public int getNDisciplinasCadas(){
		return nDisciplinasCadas;
	}
	
	public void cadastarDisciplina(String nome, String descricao){
		if(nDisciplinasCadas==0&&disciplinas[0]==null){
			this.disciplinas[nDisciplinasCadas]=new Disciplina(nome,descricao);
			this.nDisciplinasCadas++;
		}
		else{
			Disciplina[] temp = new Disciplina[nDisciplinasCadas+1];
			for(int i=0;i<=nDisciplinasCadas;i++){
				temp[i]=disciplinas[i];
			}
			this.disciplinas= new Disciplina[nDisciplinasCadas+1];
			for(int i=0;i<=nDisciplinasCadas;i++){
				disciplinas[i]=temp[i];
			}
			this.disciplinas[nDisciplinasCadas]=new Disciplina(nome,descricao);
			this.nDisciplinasCadas++;
		}
	}
	
	public void imprimeDisciplinas(){
		System.out.println("Disciplinas:\n");
		for(int i =0;i<nDisciplinasCadas;i++){
			if(this.disciplinas[i]!=null){
				System.out.println("Disciplina:"+disciplinas[i].getNome()+"\nDescricao: "+disciplinas[i].getDescricao());
			}
		}
	}
	
	public String toString(){
		String resultado=this.getNome()+" "+this.getNDisciplinasCadas()+" Disciplinas";
		return resultado;
	}
	
	
}
