package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio4;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        Numero n = new Numero();
        boolean resultado;
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n.setNumeros(teclado.nextInt(), 1);
        }while(n.saoInteirosPositivos());
        resultado = n.ehPrimo();
        System.out.print("\n" + n.numero1 + " ");
        if(!resultado){
            System.out.print("nao ");
        }
        System.out.print("eh primo.");
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
        
        boolean ehPrimo(){
            for(int i = 2; i < this.numero1 / 2; i++){
                if(this.numero1 % i == 0) return false;
            }
            return true;
        }

        boolean saoInteirosPositivos(){
            return this.numero1 <= 0 && this.numero2 <= 0;
        }
    }
}
