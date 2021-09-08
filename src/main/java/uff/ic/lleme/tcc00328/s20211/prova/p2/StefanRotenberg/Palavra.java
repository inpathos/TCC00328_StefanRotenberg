package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;

import java.util.*;

public class Palavra {
    public String fonetica;
    public String grafia;
    public Set<Sinonimos> significados;
    
    public Palavra(){
	this.significados = new HashSet<>();
    }
    
    public Palavra(String grafia, String fonetica){
	this.grafia   = grafia;
	this.fonetica = fonetica;
	this.significados = new HashSet<>();
    }
    
    public void printPalavra(){
	System.out.print(this.grafia + " /" + this.fonetica + "/: \n");
	int i = 1;
	for(Sinonimos s : this.significados){
	    System.out.println("\tsignificado " + (i++) + ": " + s.significado);
	}
    }
}
