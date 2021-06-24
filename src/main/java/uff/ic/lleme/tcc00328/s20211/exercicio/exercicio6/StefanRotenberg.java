package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio6;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        Inteiro n = new Inteiro();
        Fracao resultado = new Fracao();
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n.setInteiro(teclado.nextInt(), 1);
        }while(n.saoInteirosPositivos());
        resultado = resultado.serie(n.numero1);
        System.out.print("\nO " + n.numero1 + "º termo da série é:\t");
        resultado.printFracao();
        
    }

    static class Fracao{
        int parteInteira;
        int numerador;
        int denominador;
        
        Fracao(){
            this.numerador = 0;
            this.denominador = 1;
            this.parteInteira = 0;
        }
        
        void setFracao(int input1, int input2){
            this.numerador = input1;
            this.denominador = input2;
            this.parteInteira = 0;
        }
        
        Fracao serie(int n){
            // Serie = 4 * SUM(i = 0; i < n; i++){(-1)**i / (2i + 1)}
            int denominador = 1, umOuMenosUm;
            Fracao aux = new Fracao(), resultado = new Fracao();
            for(int i = 0; i < n; i++){
                umOuMenosUm = i % 2 == 0 ? 1 : -1;
                aux.setFracao(umOuMenosUm, (2 * i) + 1);
                resultado.somaFracao(aux);
            }
            resultado.numerador *= 4;
            resultado.simplifica();
            return resultado;
        } 
        
        void somaFracao(Fracao parcela){
            int denominador1 = parcela.denominador, denominador2 = this.denominador;
            this.numerador *= denominador1;
            this.denominador *= denominador1;
            this.numerador += parcela.numerador * denominador2;
            this.simplifica();
        }
        
        void simplifica(){
            int mdc = this.mdc();
            this.numerador /= mdc;
            this.denominador /= mdc;
        }
        
        int mdc(){
            int maior, menor, aux = 1, n1 = this.numerador, n2 = this.denominador;
            maior = n1 > n2 ? n1 : n2;
            menor = n1 < n2 ? n1 : n2;
            while(maior % menor != 0){
                aux = maior % menor;
                maior = menor;
                menor = aux;
            }
            return menor;
        }
        
        void separaParteInteira(){
            while(this.numerador >= this.denominador){
                this.parteInteira++;
                this.numerador -= this.denominador;
            }
        }
        
        void printFracao(){
            System.out.print(this.numerador + "/" + this.denominador);
        }
        
        void printFracaoImpropria(){
            this.separaParteInteira();
            if(this.parteInteira > 0){ 
                System.out.print(this.parteInteira);
                if(this.numerador != 0){
                    System.out.print(" + ");
                }
            }
            if(this.numerador != 0){
                System.out.print(this.numerador + "/" + this.denominador);
            }         
        }
    }
    
    public static class Inteiro{
        public int numero1;
        public int numero2;

        Inteiro(){
            this.numero1 = 0;
            this.numero2 = 0;
        }

        void setInteiro(int input1, int input2){
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
