package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio3;
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
        System.out.println("mdc(" + n1 + ", " + n2 + ") = " + mdcWhile(n1, n2));
    }
    
    static int mdcWhile(int n1, int n2){
	int maior = n1 > n2 ? n1 : n2;
	int menor = n1 < n2 ? n1 : n2;
	int aux = maior % menor;
	while(aux != 0){
	    maior = menor;
	    menor = aux;
	    aux = maior % menor;
	}
	return menor;   
    }
}