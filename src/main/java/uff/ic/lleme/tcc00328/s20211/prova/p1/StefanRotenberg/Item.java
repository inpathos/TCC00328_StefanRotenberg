package uff.ic.lleme.tcc00328.s20211.prova.p1.StefanRotenberg;


public class Item {
    int	    quantidade;
    Prato   prato;

    void printItem(){
	System.out.print(this.quantidade  + "\t");
	this.prato.printPrato();
    }
}

/*
    a. Item, que tem como atributos o prato pedido e sua quantidade

*/
