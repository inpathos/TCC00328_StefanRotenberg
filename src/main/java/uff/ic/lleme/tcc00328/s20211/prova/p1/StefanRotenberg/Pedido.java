package uff.ic.lleme.tcc00328.s20211.prova.p1.StefanRotenberg;

import java.util.*;

public class Pedido {
    ArrayList<Item> itens;
    
    void printPedido(){
	this.itens.forEach(i -> i.printItem());
    }
    float valorConta(){
	float resultado = 0;
	for(Item i : this.itens){
	    resultado += i.prato.preco * i.quantidade;
	}
	return resultado;
    }
}


/*
    b. Pedido, que tem como atributo uma coleção de itens
*/