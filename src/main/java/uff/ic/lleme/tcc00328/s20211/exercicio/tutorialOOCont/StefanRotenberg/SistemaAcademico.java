package uff.ic.lleme.tcc00328.s20211.exercicio.tutorialOOCont.StefanRotenberg;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class SistemaAcademico {
    
    static class VariaveisGlobais{
	static ArrayList<Aluno>		alunos	    = new ArrayList<Aluno>();
	static ArrayList<Disciplina>	disciplinas = new ArrayList<Disciplina>();
	static ArrayList<Inscricao>	inscricoes  = new ArrayList<Inscricao>();
	static ArrayList<Turma>		turmas	    = new ArrayList<Turma>();
	static String	arquivoAlunos	    = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOOCont/StefanRotenberg/alunos.txt";
	static String	arquivoDisciplinas  = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOOCont/StefanRotenberg/disciplinas.txt";
    	static String	arquivoInscricoes   = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOOCont/StefanRotenberg/inscricoes.txt";
	static String	arquivoTurmas	    = "src/main/java/uff/ic/lleme/tcc00328/s20211/exercicio/tutorialOOCont/StefanRotenberg/turmas.txt";

    }
  
    public static void main(String[] args){
	carregarAlunos(VariaveisGlobais.arquivoAlunos);
	carregarDisciplinas(VariaveisGlobais.arquivoDisciplinas);
	carregarTurmas(VariaveisGlobais.arquivoTurmas);
	carregarInscricoes(VariaveisGlobais.arquivoInscricoes);
	VariaveisGlobais.alunos.forEach	    (a -> a.printAluno());
	VariaveisGlobais.disciplinas.forEach(d -> d.printDisciplina());
	VariaveisGlobais.inscricoes.forEach (i -> i.printInscricao());
	VariaveisGlobais.turmas.forEach	    (t -> t.printTurma());
	
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
		disciplina_temp			    = new Disciplina();
		disciplina_temp.codigoDisciplina    = arquivo.next();
		disciplina_temp.sigla		    = arquivo.next();
		disciplina_temp.nome		    = arquivo.nextLine();
		VariaveisGlobais.disciplinas.add(disciplina_temp);
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
    }
    static void		carregarTurmas		(String nomeArquivo){
	File	    in;
	Scanner	    arquivo;
	Turma	    turma_temp;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: TURMA DISCIPLINA SEMESTRE HORARIO
	    while(arquivo.hasNext()){
		turma_temp = new Turma();
		turma_temp.codigoTurma	= arquivo.next();    
		turma_temp.disciplina	= matchCodigoDisciplina(VariaveisGlobais.disciplinas, arquivo.next());
		turma_temp.semestre	= arquivo.nextInt();
		turma_temp.horario	= arquivo.next();
		VariaveisGlobais.turmas.add(turma_temp);
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
	Turma	    turma;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: TURMA MATRICULA "DATA_INSCRICAO"
	    while(arquivo.hasNext()){
		turma	= matchTurmaDisciplina(VariaveisGlobais.turmas, arquivo.next());    
		aluno	= matchMatriculaAluno(VariaveisGlobais.alunos, arquivo.next());	    
		data	= arquivo.next();
		VariaveisGlobais.inscricoes.add(criaInscricaoBasica(aluno, turma, data));
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
    static Disciplina	matchCodigoDisciplina	(ArrayList<Disciplina> disciplinas, String codigoDisciplina){
	for(Disciplina d : disciplinas){
	    if(d.codigoDisciplina.equals(codigoDisciplina)){
		return d;
	    }
	}
	System.out.println("Disciplina nao encontrada!");
	return null;
    }
    static Turma	matchTurmaDisciplina	(ArrayList<Turma> turmas, String codigoTurma){
	for(Turma t : turmas){
	    if(t.codigoTurma.equals(codigoTurma)){
		return t;
	    }
	}
	System.out.println("Turma nao encontrada!");
	return null;
    }
    static Inscricao	criaInscricaoBasica	(Aluno aluno, Turma turma, String data){
	Inscricao nova    = new Inscricao();
	nova.aluno	    = aluno;
	nova.turma	    = turma;
	nova.data_matricula = data;
	return nova;
    }
    static void		informarNotasDeAlunos	(){
	Scanner teclado = new Scanner(System.in);
	ArrayList<String>   matriculas	 = new ArrayList<>();
	ArrayList<String>   disciplinas  = new ArrayList<>();	// Codigo, nao nome
	VariaveisGlobais.alunos.forEach(a -> matriculas.add(a.matricula));
	VariaveisGlobais.disciplinas.forEach(d -> disciplinas.add(d.codigoDisciplina));
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
	Turma		    turma;
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
        String	codigoDisciplina;
	String	sigla;
	String	nome;
	
	void printDisciplina(){
	    System.out.print(this.codigoDisciplina    + "\t"
		    + this.sigla	    + "\t\t"
		    + this.nome		    + "\n");
	}
    }
    static class Turma{
	String	    codigoTurma;
	Disciplina  disciplina;
	int	    semestre;
	String	    horario;
		
	void printTurma(){
	    System.out.print(this.codigoTurma		+ "\t\t"
		    + this.disciplina.codigoDisciplina	+ "\t"
		    + this.semestre			+ "\t"
		    + this.horario			+ "\n");
	}

    }
}