package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio2;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero inteiro positivo: ");
            n = teclado.nextInt();
        }while(n <= 0);
        System.out.println(n + "! = " + fatorialWhile(n));
    }
    
    static int fatorialWhile(int n){
	int resultado = 1, aux = 1;
	while(aux <= n){ 
	    resultado *= aux++;
	} 
	return resultado;
    }
}