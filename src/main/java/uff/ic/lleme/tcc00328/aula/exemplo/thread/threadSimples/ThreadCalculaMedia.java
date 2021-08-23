package uff.ic.lleme.tcc00328.aula.exemplo.thread.threadSimples;

public class ThreadCalculaMedia extends Thread {

    private Tarefa tarefa = null;

    public ThreadCalculaMedia(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void run() {
        tarefa.resultado = 0.0;
        for (Double numero : tarefa.numeros)
            tarefa.resultado += numero;
        tarefa.resultado /= tarefa.numeros.length;
    }
}
