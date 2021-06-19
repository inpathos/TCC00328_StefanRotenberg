package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio6;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        Inteiro n = new Inteiro();
        Fracao resultado = new Fracao();
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n.setNumeros(teclado.nextInt(), 1);
        }while(n.saoInteirosPositivos());
        resultado.serie(n.numero1);
        System.out.print("\nO " + n.numero1 + "º termo da série é:  ");
        resultado.printFracao();
    }

    static class Fracao{
        int numerador;
        int denominador;
        
        Fracao(){
            this.numerador = 0;
            this.denominador = 0;
        }
        
        void setFracao(int input1, int input2){
            this.numerador = input1;
            this.denominador = input2;
        }
        
        // TODO: Consertar
        Fracao serie(int n){
            int numerador = 0, denominador = 0, mdc, menosUm = -1;
            Inteiro aux = new Inteiro();
            Fracao resultado = new Fracao();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    menosUm *= menosUm;
                }
                numerador += menosUm;
                denominador += (2 * i) + 1;
            }
            resultado.numerador = numerador * 4;
            aux.setNumeros(numerador, denominador);
            mdc = aux.mdc();
            numerador /= mdc;
            denominador /= mdc;
            resultado.setFracao(numerador, denominador);
            return resultado;
        } 
        
        void printFracao(){
            System.out.print(this.numerador + "/" + this.denominador);
        }
    }
    
    public static class Inteiro{
        public int numero1;
        public int numero2;

        Inteiro(){
            this.numero1 = 0;
            this.numero2 = 0;
        }

        void setNumeros(int input1, int input2){
            this.numero1 = input1;
            this.numero2 = input2;
        }
        
        int fibonacci(){
            int termo1 = 0, termo2 = 1, i = 1;
            while(i < this.numero1){
                termo1 += termo2;
                termo2 += termo1;
                i += 2;
            }
            // O loop incrementa de dois em dois, então é preciso checar
            // se devemos retornar o iésimo ou o (i - 1)ésimo termo.
            if(i == this.numero1)
                return termo2;
            return termo1;
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
