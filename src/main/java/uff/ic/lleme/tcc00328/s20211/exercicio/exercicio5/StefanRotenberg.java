package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio5;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n = teclado.nextInt();
        }while(n <= 0);
        System.out.print("\n O " + n + "º termo de Fibonacci é:  " + fibonacciWhile(n));
        }
    
	static int fibonacciWhile(int n){
            int termo1 = 0, termo2 = 1, i = 1;
            while(i < n){
                termo1 += termo2;
                termo2 += termo1;
                i += 2;
            }
            // O loop incrementa de dois em dois, então é preciso checar
            // se devemos retornar o iésimo ou o (i - 1)ésimo termo.
            if(i == n)
                return termo2;
            return termo1;
        }

}
