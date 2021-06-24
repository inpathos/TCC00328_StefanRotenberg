package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio9;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n = teclado.nextInt();
        }while(n <= 0);
        System.out.print("\n O " + n + "º termo de Fibonacci é:  " + fibonacciFor(n));
        }
    
	static int fibonacciFor(int n){
            int termo1 = 0, termo2 = 1, i;
	    for(i = 1; i < n; i += 2){
                termo1 += termo2;
                termo2 += termo1;
	    }
            // O loop incrementa de dois em dois, então é preciso checar
            // se devemos retornar o iésimo ou o (i - 1)ésimo termo.
            if(i == n)
                return termo2;
            return termo1;
        }

}
