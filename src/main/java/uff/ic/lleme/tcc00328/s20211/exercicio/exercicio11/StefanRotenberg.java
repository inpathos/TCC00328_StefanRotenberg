package uff.ic.lleme.tcc00328.s20211.exercicio.exercicio11;

public class StefanRotenberg {

    public static void main(String[] args){
        int n = 50;
        System.out.print("O produto dos numeros primos menores que " + 
		n + " = " + primorial(n));
    }
    
    static long primorial(int n){
	long resultado = 1;
	for(int i = 2; i < n; i++){
	    if(ehPrimoFor(i)){
		resultado *= i;
	    }
	}
	return resultado;
    }
    
    static boolean ehPrimoFor(int n){
	for(int i = 2; i <= n / 2; i++){
	    if(n % i == 0) return false;
	}
	return true;
    }
}