package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio13;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = -1;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite n: ");
            n = teclado.nextInt();
        } while(n < 0);
	printMedia(n);        
    }
    
    static void printMedia(int n){
	float acumulador = 0;
	Scanner teclado = new Scanner(System.in);
	for(int i = 1; i <= n; i++){
	    System.out.println("Digite o " + i + "º valor: ");
	    acumulador += teclado.nextInt();
	}
	System.out.println("A média dos valores é: " + (acumulador / n) );
    }
}