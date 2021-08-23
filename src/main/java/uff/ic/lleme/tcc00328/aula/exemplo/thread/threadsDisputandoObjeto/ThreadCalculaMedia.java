package uff.ic.lleme.tcc00328.aula.exemplo.thread.threadsDisputandoObjeto;

public class ThreadCalculaMedia extends Thread {

    private Tarefa tarefa = null;

    public ThreadCalculaMedia(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public void run() {
        tarefa.calculaMedia();
    }

}
