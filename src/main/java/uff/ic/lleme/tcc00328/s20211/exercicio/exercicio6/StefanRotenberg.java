package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio6;
import java.util.*;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = -1;
        Fracao resultado = new Fracao();
        Scanner teclado = new Scanner(System.in);
        do{
            System.out.println("Digite um numero: ");
            n = teclado.nextInt();
        } while(n < 0);
        resultado = serieWhile(n);
        System.out.print("\nO " + n + "º termo da série é:\t");
        resultado.printFracao();
        
    }
    
    static Fracao serieWhile(int n){
	// Serie = 4 * (SUM(i=0 até n-1){(-1)**i / (2i + 1)})
	int umOuMenosUm, i = 0;
	Fracao aux = new Fracao(), resultado = new Fracao();
	while(i < n){
	    umOuMenosUm = i % 2 == 0 ? 1 : -1;
	    aux.setFracao(umOuMenosUm, (2 * i) + 1);
	    resultado.somaFracao(aux);
	    i++;
	}
	resultado.numerador *= 4;
	resultado.simplifica();
	return resultado;
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
        	        
        void somaFracao(Fracao parcela){
            int denominador1 = parcela.denominador, denominador2 = this.denominador;
            this.numerador *= denominador1;
            this.denominador *= denominador1;
            this.numerador += parcela.numerador * denominador2;
            this.simplifica();
        }
        
	int mdcDosDenominadores(){
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
	
        void simplifica(){
            int mdc = this.mdcDosDenominadores();
            this.numerador /= mdc;
            this.denominador /= mdc;
        }
        
        void printFracao(){
            System.out.print(this.numerador + "/" + this.denominador);
        }
        
	
        void separaParteInteira(){
            while(this.numerador >= this.denominador){
                this.parteInteira++;
                this.numerador -= this.denominador;
            }
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
}