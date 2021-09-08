package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;
import java.util.*;

public class Dicionario {
    List<Palavra>   palavras;
    List<Sinonimos> significados;
    
    public Dicionario(){
	palavras = new ArrayList<>();
	significados = new ArrayList<>();
    }
    
    public void criarNovaEntrada(String grafia, 
			     String fonetica,
			     String morfologia,
			     List<String> significados){
	Palavra novaPalavra = new Palavra(grafia, fonetica);
	List<Sinonimos> novosSignificados = criarListaDeSignificados(morfologia, significados);
	for(Sinonimos s: novosSignificados){
	    s.palavras.add(novaPalavra);
	    novaPalavra.significados.add(s);
	    this.significados.add(s);
	}
	this.palavras.add(novaPalavra);
    }
    
    public List<Sinonimos> criarListaDeSignificados(String morfologia, List<String> significados){
	List<Sinonimos> listaDeSignificados = new ArrayList<>();
	for(String s : significados){
	    switch(morfologia){
		case "s":
		    listaDeSignificados.add(new Substantivo(s));
		    break;
		case "v":
		    listaDeSignificados.add(new Verbo(s));
		    break;
		/*
		case "a":
		    novosSignificados.add(new Adjetivo(s));
		    break;
		*/
		default:
		    listaDeSignificados.add(new Substantivo(s));
		    break;
	    }
	}
	return listaDeSignificados;
    }
    
    public void printDicionario(){
	for(Palavra p : this.palavras){
	    p.printPalavra();
	    System.out.println();
	}
	for(Sinonimos s : this.significados){
	    s.printSinonimos();
	    System.out.println();
	}
    }
    
    public static void main(String[] args) {
	Dicionario dicionario = new Dicionario();
	dicionario.criarNovaEntrada("livro",
			 "LHI.vru",
			 "s",
			 Arrays.asList("coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
"meio de cola, costura etc., formando um volume que se recobre com capa resistente.",
			  "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."));
	dicionario.criarNovaEntrada("obra",
			 "Ó.br(a)",
			 "s",
			 Arrays.asList("aquilo que resulta de um trabalho, de uma ação.",
			  "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."));
	dicionario.printDicionario();
    }
}
