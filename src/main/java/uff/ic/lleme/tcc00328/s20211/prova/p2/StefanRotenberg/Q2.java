package uff.ic.lleme.tcc00328.s20211.prova.p2.StefanRotenberg;

import java.util.*;
import java.lang.Thread;

public class Q2 {
    List<Double> valores;
    
    public double calcularSoma(){
	double acumulador = 0;
	for(Double x : this.valores){
	    acumulador += x;
	}
	return acumulador;
    }
    
    public double calcularMedia(){
	return this.calcularSoma() / this.valores.size();
    }
    
    public static void main(String[] args) {
	Q2 exemplo = new Q2();
	exemplo.valores = new ArrayList<>();
	Collections.addAll(exemplo.valores, 7.5, 9.1, 1.0, 5.5, 4.4, 8.3, 10.0, 9.2, 3.7, 1.9);
	System.out.println(exemplo.calcularMedia());
    }
}
