package uff.ic.lleme.tcc00328.aula.exemplo.thread.threadSimplesRunnable;

import uff.ic.lleme.tcc00328.aula.exemplo.thread.util.Util;

public class Main {

    public static void main(String args[]) throws InterruptedException {
        double[] notas1 = Util.geraVetorAleatorio();
        double[] notas2 = Util.geraVetorAleatorio();

        Tarefa tarefa1 = new Tarefa(notas1);
        Tarefa tarefa2 = new Tarefa(notas2);

        Thread thread1 = new Thread(new ThreadSimplesRunnable(tarefa1));
        Thread thread2 = new Thread(new ThreadSimplesRunnable(tarefa2));

        // Threads são iniciadas e processarão em paralelo
        thread1.start();
        thread2.start();

        // Thread do programa principal irá esperar cada uma das outras threads terminar
        thread1.join();
        thread2.join();

        System.out.println(tarefa1.resultado);
        System.out.println(tarefa2.resultado);

    }

}
