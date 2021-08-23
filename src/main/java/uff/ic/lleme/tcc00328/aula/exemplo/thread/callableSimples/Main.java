package uff.ic.lleme.tcc00328.aula.exemplo.thread.callableSimples;

import java.util.concurrent.Callable;
import uff.ic.lleme.tcc00328.aula.exemplo.thread.util.Util;

public class Main {

    public static void main(String[] args) throws Exception {
        double[] notas1 = Util.geraVetorAleatorio();
        double[] notas2 = Util.geraVetorAleatorio();

        Callable<Double> thread1 = new CallableCalculaMedia(notas1);
        Callable<Double> thread2 = new CallableCalculaMedia(notas2);

        //Não há processamento paralello porque o call() espera a thread terminar
        System.out.println(thread1.call());
        System.out.println(thread2.call());
    }
}
