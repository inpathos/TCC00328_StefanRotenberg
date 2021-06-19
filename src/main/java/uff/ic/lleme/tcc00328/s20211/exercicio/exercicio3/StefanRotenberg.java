package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio3;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        Numero n = new Numero();
        int resultado = 0;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite dois numeros: ");
            n.setNumeros(teclado.nextInt(), teclado.nextInt());
        }while(n.saoInteirosPositivos());
        resultado = n.mdc();
        System.out.println("mdc(" + n.numero1 + ", " + n.numero2 + ") = " + resultado);
    }

    static class Numero{
        public int numero1;
        public int numero2;

        Numero(){
            this.numero1 = 0;
            this.numero2 = 0;
        }

        void setNumeros(int input1, int input2){
            this.numero1 = input1;
            this.numero2 = input2;
        }

        int fatorial(){
            if(this.numero1 == 1) return 1;
            int resultado = 1, n = 1;
            do{
                resultado *= n++;
            } while(n <= this.numero1);
            return resultado;
        }

        int mdc(){
            int maior, menor, aux = 1, n1 = this.numero1, n2 = this.numero2;
            maior = n1 > n2 ? n1 : n2;
            menor = n1 < n2 ? n1 : n2;
            while(maior % menor != 0){
                aux = maior % menor;
                maior = menor;
                menor = aux;
            }
            return menor;
            
        }

        boolean saoInteirosPositivos(){
            return this.numero1 <= 0 && this.numero2 <= 0;
        }
    }
}
