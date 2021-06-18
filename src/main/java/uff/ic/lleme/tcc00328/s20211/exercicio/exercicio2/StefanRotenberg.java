package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio2;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int numero = 0, fatorial = 0;
        Numero n = new Numero(0);
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero inteiro positivo: ");
            numero = teclado.nextInt();
        }while(numero <= 0);
        n.numero = numero;
        fatorial = n.fatorial();
        System.out.println(n.numero + "! = " + fatorial);
    }
    static class Numero{
        public int numero;
        Numero(int input){
            this.numero = input;
        }
        public int fatorial(){
            if(this.numero == 1) return 1;
            int resultado = 1, n = 1;
            do{
                resultado *= n++;
            } while(n <= this.numero);
            return resultado;
        }
    }
}
