package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;
import java.util.*;

public class Dicionario {
    List<Palavra>   palavras;
    
    public Dicionario(){
	this.palavras	  = new ArrayList<>();
    }
    
    public void criaNovaEntrada(String grafia, 
			     String fonetica,
			     // String morfologia,
			     List<String> significados){
	Palavra palavra = this.criaNovaPalavra(grafia, fonetica);
	for(String s : significados){
	    Sinonimos sinonimo = this.criaNovoSignificado(s);
	    sinonimo.palavras.add(palavra);
	    palavra.sinonimos.add(sinonimo);
	}
	this.palavras.add(palavra);
    }
    
    public boolean contemSinonimo(String significado){
	for(Palavra p : this.palavras){
	    for(Sinonimos s : p.sinonimos){
		if(s.significado.equals(significado)) return true;
	    }
	}
	return false;
    }
    
    public Sinonimos buscaSinonimo(String significado){
	for(Palavra p : this.palavras){
	    for(Sinonimos s : p.sinonimos){
	        if(s.significado.equals(significado)) return s;
	    }
	}
	return null;
    }
    
    public Sinonimos criaNovoSignificado(String significado){
	return this.contemSinonimo(significado)
	    ? this.buscaSinonimo(significado)
	    : new Substantivo(significado);
    }
    
    public Palavra criaNovaPalavra(String grafia, String fonetica){
	return this.contemPalavra(grafia) 
	    ? this.buscaPalavra(grafia)
	    : new Palavra(grafia, fonetica);
    }
 
    public boolean contemPalavra(String grafia){
	for(Palavra p : this.palavras){
	    if(p.grafia.equals(grafia)) return true;
	}
	return false;
    }
    
    public Palavra buscaPalavra(String grafia){
	for(Palavra p : this.palavras){
	    if(p.grafia.equals(grafia))	return p;
	}
	return new Palavra();
    }
    
    public void printDicionario(){
	for(Palavra p : this.palavras){
	    p.printPalavra();
	    System.out.println();
	}
    }
   
    
    public static void main(String[] args) {
	Dicionario dicionario = new Dicionario();
	dicionario.criaNovaEntrada("livro",
		"LHI.vr(u)",
		Arrays.asList("coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por\n" +
				"meio de cola, costura etc., formando um volume que se recobre com capa resistente.",
				"obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
				"documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."));
	dicionario.criaNovaEntrada("obra",
		"Ó.br(a)",
		Arrays.asList("aquilo que resulta de um trabalho, de uma ação.",
		       "obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de\n" +
		       "documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.]."));
	dicionario.printDicionario();
    }
}
