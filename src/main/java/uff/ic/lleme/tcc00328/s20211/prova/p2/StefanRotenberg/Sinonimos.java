package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;

import java.util.*;

public abstract class Sinonimos {
    public String significado;
    public Set<Palavra> palavras;
    
    public Sinonimos(){
	this.palavras = new HashSet<>();
    }
    
    public Sinonimos(String significado){
	this.significado = significado;
    	this.palavras = new HashSet<>();
    }
    
    public void printSinonimos(){
	System.out.print("\"" + this.significado + "\":");
	System.out.print("\n\tSinonimos com esse significado: ");
	for(Palavra p : this.palavras){
	    System.out.print(p.grafia + "\t");
	}
	System.out.println();
    }
}
