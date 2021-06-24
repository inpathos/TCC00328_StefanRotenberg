package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio8;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero inteiro positivo: ");
            n = teclado.nextInt();
        }while(n < 0);
        System.out.print(n + (ehPrimoFor(n) ? " é " : " não é ") + "primo");
    }
    
    static boolean ehPrimoFor(int n){
	for(int i = 2; i <= n / 2; i++){
	    if(n % i == 0) return false;
	}
	return true;
    }
    
}
