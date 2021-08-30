package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio19;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        for(int i = 0; i < 15; i++){
	    System.out.println((i+1) + "º jogo:");
	    Jogo jogo = new Jogo();
	    jogo.jogarJogo();
	}   
    }

    static class Dado{
	int menorFace;	// default = 1
	int maiorFace;	// default = 6
	int atualFace;
	
	Dado(){
	    this.menorFace = 1;
	    this.maiorFace = 6;
	}
	
	Dado(int menorFace, int maiorFace){
	    this.menorFace = menorFace;
	    this.maiorFace = maiorFace;
	}
	
	void lancarDado(){
	    int min = this.menorFace;
	    int max = this.maiorFace + 1;   // O limite superior de random.nextInt é exclusivo
	    Random random = new Random();
	    int resultado = random.nextInt(max - min) + min;
	    this.atualFace  = resultado;
	}
    }
    
    static class Jogo{
	int		quantosDados;	    // default = 2
	boolean		ehPrimeiraRodada;   // default = True
	List<Integer>	vencedores;	    // default = [7, 11]
	List<Integer>	perdedores;	    // default = [2, 3, 12]
	List<Dado>	dados;
	int		rolagem;
	
	Jogo(){
	    this.quantosDados = 2;
	    this.dados = new ArrayList<>();
	    for(int i = 0; i < quantosDados; i++) this.dados.add(new Dado());
	    this.ehPrimeiraRodada = true;
	    this.vencedores = Arrays.asList(7, 11);
	    this.perdedores = Arrays.asList(2, 3, 12);
	}
	
	Jogo(int quantosDados, List<Integer> vencedores, List<Integer> perdedores){
	    this.quantosDados = quantosDados;
	    this.dados = new ArrayList<>();
	    for(int i = 0; i < quantosDados; i++) this.dados.add(new Dado());
	    this.ehPrimeiraRodada = true;
	    this.vencedores = vencedores;
	    this.perdedores = perdedores;
	}
	
	private void rolarJogo(){
	    int soma = 0;
	    for(Dado d : this.dados){
		d.lancarDado();
		soma += d.atualFace;
	    }
	    this.rolagem = soma;
	}
	boolean venceuJogo(){
	    return this.vencedores.contains(this.rolagem);   
	}
	boolean perdeuJogo(){
	    return this.perdedores.contains(this.rolagem);
	}
	boolean terminouJogo(){
	    return this.venceuJogo() || this.perdeuJogo();
	}
	void jogarJogo(){
	    this.rolarJogo();
	    this.printJogo();
	    if(this.terminouJogo()) return;
	    if(this.ehPrimeiraRodada){
		this.vencedores = Arrays.asList(this.rolagem);
		this.perdedores = Arrays.asList(7);
		this.ehPrimeiraRodada = false;
	    }
	    this.jogarJogo();
	}
	void printJogo(){
	    this.printDados();
	    this.printStatusJogo();
	}
	void printVencedores(){
	    System.out.print("V: " + this.vencedores + "\t");
	}
	void printPerdedores(){
	    System.out.print("P: " + this.perdedores + "\t");   
	}
	void printVencedoresEPerdedores(){
	    this.printVencedores();
	    this.printPerdedores();
	    System.out.print("\n");
	}
	void printStatusJogo(){
	    if(this.venceuJogo()) System.out.print("Venceu!\n");
	    if(this.perdeuJogo()) System.out.print("Perdeu!\n");
	    System.out.println();
	}
	void printDados(){
	    System.out.print("Dados:\t");
	    for(Dado d : this.dados) System.out.print(d.atualFace + "\t");
	    System.out.print("(" + this.rolagem + ")\t");   
	}
    }
}