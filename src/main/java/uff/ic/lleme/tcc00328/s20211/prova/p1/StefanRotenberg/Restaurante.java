package uff.ic.lleme.tcc00328.s20211.prova.p1.StefanRotenberg;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Restaurante {

    static class VariaveisGlobais {
	static ArrayList<Item>	    pedido	    = new ArrayList<Item>();
	static ArrayList<Prato>	    pratos	    = new ArrayList<Prato>();
	static String		    arquivoPedido  = "src/main/java/uff/ic/lleme/tcc00328/s20211/prova/p1/StefanRotenberg/pedido.txt";
	static String		    arquivoPratos   = "src/main/java/uff/ic/lleme/tcc00328/s20211/prova/p1/StefanRotenberg/pratos.txt";
    }
    
    public static void main(String[] args) {
	// Q1:
	carregarPratos(VariaveisGlobais.arquivoPratos);
	carregarPedido(VariaveisGlobais.arquivoPedido);
	// Opcionalmente imprimir os vetores:
	// VariaveisGlobais.pratos.forEach(p -> p.printPrato());
	// VariaveisGlobais.pedidos.forEach(p -> p.printItem());
	System.out.printf("\nO valor da conta eh: R$ %.2f.\n", valorConta(VariaveisGlobais.pedido));
	
	// Q2:
	// Incompleta e incorreta. Nao consegui desvendar o enunciado.
	percentualPedidosPorPrato(VariaveisGlobais.pratos, VariaveisGlobais.pedido);
    }
    
    static void	    carregarPratos  (String nomeArquivo){
	File	in;
	Scanner	arquivo;
	Prato	prato_temp;
	try{
	    in   = new File(nomeArquivo);
	    arquivo = new Scanner(in);
	    // Arquivo está no formato: NOME PRECO
	    while(arquivo.hasNext()){
		prato_temp	    = new Prato();
		prato_temp.nome	    = arquivo.next();
		prato_temp.preco    = arquivo.nextFloat();
		VariaveisGlobais.pratos.add(prato_temp);
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
    }
    static void	    carregarPedido  (String nomeArquivo){
	File	in;
	Scanner	arquivo;
	Item	item_temp;
	try{
	    in		= new File(nomeArquivo);
	    arquivo	= new Scanner(in);
	    // Arquivo está no formato: QUANTIDADE PRATO
	    while(arquivo.hasNext()){
		item_temp		= new Item();
		item_temp.quantidade	= arquivo.nextInt();
		item_temp.prato		= matchNomePrato(VariaveisGlobais.pratos, arquivo.next());
		VariaveisGlobais.pedido.add(item_temp);
	    }
	    arquivo.close();
	} 
	catch (FileNotFoundException e){
	    System.out.println("Arquivo não encontrado!");
	    System.exit(1);
	}
	
    }
    static Prato    matchNomePrato  (ArrayList<Prato> pratos, String nome){
	for(Prato p : pratos){
	    if(p.nome.equals(nome)){
		return p;
	    }
	}
	System.out.println("Prato nao encontrado!");
	return null;
    }
    static float    valorConta	    (ArrayList<Item> pedido){
	float resultado = 0;
	for(Item i : pedido){
	    resultado += i.prato.preco * i.quantidade;
	}
	return resultado;
    }
    static void	    percentualPedidosPorPrato(ArrayList<Prato> pratos, ArrayList<Item> pedidos){
	int quantidadePratosPedidos = 0;
	for(Item i : pedidos){
	    quantidadePratosPedidos += 1 * i.quantidade;
	}
	for(Prato p : pratos){
	    for(Item i: pedidos){
		float porcentagem;
		if(i.prato.nome.equals(p.nome)){
		    porcentagem = ((float) i.quantidade) / quantidadePratosPedidos;
		}
		else{
		    porcentagem = 0;
		}
		System.out.printf("\n%s %.2f por centodos pedidos.", p.nome, porcentagem);
		
	    }
	}
    }
}

/*
1)  Uma aplicação para gestão de restaurante registra os pedidos dos clientes em uma visita ao
    restaurante informando a quantidade pedida de cada prato. Projete uma aplicação Java para ler
    uma coleção de pedidos de um arquivo e armazená-las em um vetor [3,0 pontos] e depois emitir
    o valor da conta para um pedido informado [3,0 pontos]. A aplicação deverá utilizar as seguintes
    classes:

	a. Item, que tem como atributos o prato pedido e sua quantidade
	b. Pedido, que tem como atributo uma coleção de itens
	c. Prato, que tem como atributo seu nome e preço

    Você deverá propor o formato dos arquivos a serem lidos. Deverá haver um arquivo para pedido
    e outro para pratos.
    
2)  [4,0 pontos] Escreva programa Java que calcule o percentual de pedidos por prato da aplicação
    da questão 1. Para isso, você deverá percorrer o vetor de pedidos, contar a quantidade de pedidos
    que contém cada prato de depois calcular o percentual de pedidos que corresponde a cada
    quantidade. As classes que devem ser usadas são as mesmas da questão 1.
*/