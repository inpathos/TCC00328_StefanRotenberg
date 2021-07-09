package uff.ic.lleme.tcc00328.s20211.exercicio.tutorialOO.StefanRotenberg;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SistemaAcademico {
    
    static class VariaveisGlobais{
	static ArrayList<Aluno>		alunos	    = new ArrayList<Aluno>();
	static ArrayList<Disciplina>	disciplinas = new ArrayList<Disciplina>();
	static ArrayList<Inscricao>	inscricoes  = new ArrayList<Inscricao>();
	static String	arquivoAlunos	    = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOO/StefanRotenberg/alunos.txt";
	static String	arquivoDisciplinas  = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOO/StefanRotenberg/disciplinas.txt";
    	static String	arquivoInscricoes   = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOO/StefanRotenberg/inscricoes.txt";
    }
  
    public static void main(String[] args){
	carregarAlunos(VariaveisGlobais.arquivoAlunos);
	carregarDisciplinas(VariaveisGlobais.arquivoDisciplinas);
	carregarInscricoes(VariaveisGlobais.arquivoInscricoes);
	informarNotasDeAlunos();
	VariaveisGlobais.alunos.forEach	    (a -> a.printAluno());
	VariaveisGlobais.disciplinas.forEach(d -> d.printDisciplina());
	VariaveisGlobais.inscricoes.forEach (i -> i.printInscricao());
	calcularMedias();
	
    }
        
    static void		carregarAlunos		(String nomeArquivo){
	File	in;
	Scanner	arquivo;
	Aluno	aluno_temp;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: CPF MATRICULA UNIDADE NOME
	    while(arquivo.hasNext()){
		aluno_temp		= new Aluno();
		aluno_temp.cpf		= arquivo.next();
		aluno_temp.matricula	= arquivo.next();
		aluno_temp.unidade	= arquivo.next();
		aluno_temp.nome		= arquivo.nextLine();
		VariaveisGlobais.alunos.add(aluno_temp);
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
	
    }
    static void		carregarDisciplinas	(String nomeArquivo){
	File	    in;
	Scanner	    arquivo;
	Disciplina  disciplina_temp;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: CODIGO SIGLA NOME
	    while(arquivo.hasNext()){
		disciplina_temp		= new Disciplina();
		disciplina_temp.codigo	= arquivo.next();
		disciplina_temp.sigla	= arquivo.next();
		disciplina_temp.nome	= arquivo.nextLine();
		VariaveisGlobais.disciplinas.add(disciplina_temp);
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
    }
    static void		carregarInscricoes	(String nomeArquivo){
	File	    in;
	Scanner	    arquivo;
	String	    data;
	Aluno	    aluno;
	Disciplina  disciplina;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: CODIGO MATRICULA "DATA_INSCRICAO"
	    for(int i = 0; arquivo.hasNext(); i++){
		disciplina  = matchCodigoDisciplina(VariaveisGlobais.disciplinas, arquivo.next());  // codigo
		aluno	    = matchMatriculaAluno(VariaveisGlobais.alunos, arquivo.next());	    // matricula
		data	    = arquivo.next();							    // data de inscricao
		VariaveisGlobais.inscricoes.add(criaInscricaoBasica(aluno, disciplina, data));
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
    }
    static Aluno	matchMatriculaAluno	(ArrayList<Aluno> alunos, String matricula){
	for(Aluno a : alunos){
	    if(a.matricula.equals(matricula)){
		return a;
	    }
	}
	System.out.println("Aluno nao encontrado!");
	return null;
    }
    static Disciplina	matchCodigoDisciplina	(ArrayList<Disciplina> disciplinas, String codigo){
	for(Disciplina d : disciplinas){
	    if(d.codigo.equals(codigo)){
		return d;
	    }
	}
	System.out.println("Disciplina nao encontrada!");
	return null;
    }
    static Inscricao	criaInscricaoBasica	(Aluno aluno, Disciplina disciplina, String data){
	Inscricao nova    = new Inscricao();
	nova.aluno	    = aluno;
	nova.disciplina	    = disciplina;
	nova.data_matricula = data;
	return nova;
    }
    static void		informarNotasDeAlunos	(){
	Scanner teclado = new Scanner(System.in);
	ArrayList<String>   matriculas	 = new ArrayList<>();
	ArrayList<String>   disciplinas  = new ArrayList<>();	// Codigo, nao nome
	VariaveisGlobais.alunos.forEach(a -> matriculas.add(a.matricula));
	VariaveisGlobais.disciplinas.forEach(d -> disciplinas.add(d.codigo));
	VariaveisGlobais.inscricoes.forEach(i -> {
	    System.out.println("Digite as notas do aluno " + i.aluno.nome +" (-1 para encerrar): ");
	    i.notas = new ArrayList<>();
	    float nota;
	    nota = teclado.nextFloat();
	    while(nota >= 0){
		i.notas.add(nota);
		nota = teclado.nextFloat();
	    }
	});
    }
    static void		calcularMedias		(){
	VariaveisGlobais.inscricoes.forEach (i -> {
	    System.out.print("\nO aluno" + i.aluno.nome 
		    + " obteve a seguinte media na disciplina" 
		    + i.disciplina.nome + ": ");
	    i.printMedia();
	});
    }
    
    class Pessoa {
	String	nome;
	String	cpf;
    }
    
    static class Aluno extends Pessoa{
	String			matricula;
	String			unidade;
	ArrayList<Inscricao>	inscricoes;
	
	void printAluno(){
	    System.out.print(this.cpf	+ "\t"
		    + this.matricula	+ "\t "
		    + this.unidade	+ "\t\t"
		    + this.nome		+ "\n");
	}
    }
    
    static class Inscricao {
	Aluno		    aluno;
	Disciplina	    disciplina;
	String		    data_matricula;
	String		    data_cancelamento;
	ArrayList<Float>    notas;
	
	void printInscricao(){
	    System.out.print(this.aluno.cpf  + "\t"
		    + this.aluno.matricula   + "\t"
		    + this.data_matricula    + "\n");
	}
	void printNotas(){
	    if(!this.notas.isEmpty()){
		this.notas.forEach(n -> System.out.print(n + "\n"));
	    }
	}
	void printMedia(){
	    float acumulador   = 0;
	    int	  cont_de_avaliacoes = 0;
	    for(float nota : this.notas){
		acumulador += nota;
		cont_de_avaliacoes++;
	    }
	    System.out.print(acumulador / cont_de_avaliacoes);
	}
    }
    
    static class Disciplina {
        String	codigo;
	String	sigla;
	String	nome;
	
	void printDisciplina(){
	    System.out.print(this.codigo    + "\t"
		    + this.sigla	    + "\t\t"
		    + this.nome		    + "\n");
	}
    }

}