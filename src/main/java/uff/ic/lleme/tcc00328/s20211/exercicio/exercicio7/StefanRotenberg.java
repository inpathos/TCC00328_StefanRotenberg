package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio7;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n1 = 0, n2 = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite dois numeros: ");
            n1 = teclado.nextInt();
	    n2 = teclado.nextInt();
        }while(n1 <= 0 && n2 <= 0);
        System.out.println("mdc(" + n1 + ", " + n2 + ") = " + mdcFor(n1, n2));
    }

    static int mdcFor(int n1, int n2){
	int maior = n1 > n2 ? n1 : n2;
	int menor = n1 < n2 ? n1 : n2;
	for(int aux = maior % menor; aux != 0; aux = maior % menor){
	    maior = menor;
	    menor = aux;
	}
	return menor;
    }
}
