package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;

import java.util.*;

public class Palavra {
    public String fonetica;
    public String grafia;
    public Set<Sinonimos> sinonimos;
    
    public Palavra(){
	this.sinonimos = new HashSet<>();
    }
    
    public Palavra(String grafia){
	this.sinonimos = new HashSet<>();
	this.grafia = grafia;
    }
    
    public Palavra(String grafia, String fonetica){
	this.grafia   = grafia;
	this.fonetica = fonetica;
	this.sinonimos = new HashSet<>();
    }
    
    public void printPalavra(){
	System.out.print(this.grafia + " /" + this.fonetica + "/: \n");
	int i = 1;
	for(Sinonimos s : this.sinonimos){
	    System.out.print("\n\tsignificado " + (i++) + ": ");
	    s.printSinonimos();
	}
    }
}
