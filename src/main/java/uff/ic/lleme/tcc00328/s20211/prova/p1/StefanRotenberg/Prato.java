package uff.ic.lleme.tcc00328.s20211.prova.p1.StefanRotenberg;

public class Prato {
    String  nome;
    float   preco;
    
    void printPrato(){
	System.out.printf("%.2f\t%s\t", this.preco, this.nome);
    }
}

/*
    c. Prato, que tem como atributo seu nome e preço
*/