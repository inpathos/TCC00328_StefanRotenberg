package uff.ic.lleme.tcc00328.aula.exemplo.thread.util;

public class Util {

    public static double[] geraVetorAleatorio() {
        int limMax = 100;
        int limMin = 20;
        int tamanho = (int) (((limMax + 1) - limMin) * Math.random() + limMin);
        double[] numeros = new double[tamanho];
        limMax = 10;
        limMin = 0;
        for (int i = 0; i < numeros.length; i++)
            numeros[i] = (((limMax + 1) - limMin) * Math.random() + limMin);
        return numeros;
    }

}
