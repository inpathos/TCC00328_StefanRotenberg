package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio12;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = -1;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero inteiro positivo: ");
            n = teclado.nextInt();
        } while(n < 0);
        System.out.print("\nOs divisores de " + n + " são: ");
	printDivisores(n);
        
    }
    
    static void printDivisores(int n){
	System.out.print("{");
	for(int i = 1; i <= n / 2; i++){
	    if(n % i == 0){
		System.out.print(i + ", ");
	    }
	}
	System.out.print(n + "}");
    }
}