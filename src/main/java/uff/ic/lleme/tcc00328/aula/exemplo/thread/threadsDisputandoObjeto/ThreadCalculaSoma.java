package uff.ic.lleme.tcc00328.aula.exemplo.thread.threadsDisputandoObjeto;

public class ThreadCalculaSoma extends Thread {

    private Tarefa tarefa = null;

    public ThreadCalculaSoma(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void run() {
        tarefa.calculaSoma();
    }
}
