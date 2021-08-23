package uff.ic.lleme.tcc00328.aula.exemplo.thread.threadsDisputandoObjeto;

import uff.ic.lleme.tcc00328.aula.exemplo.thread.util.Util;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        double[] notas = Util.geraVetorAleatorio();

        Tarefa tarefa = new Tarefa(notas);

        Thread thread1 = new ThreadCalculaMedia(tarefa);
        Thread thread2 = new ThreadCalculaSoma(tarefa);

        // Threads são iniciadas e não processarão em paralelo.
        // Quem pegar primeiro o Monitor de tarefa irá processar primeiro
        thread1.start();
        thread2.start();

        // Thread do programa principal irá esperar cada uma das outras threads terminar
        thread1.join();
        thread2.join();

        System.out.println(tarefa.media);
        System.out.println(tarefa.soma);

    }

}
