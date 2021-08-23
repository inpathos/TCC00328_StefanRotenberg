package uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.controller;

import uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.model.Temporizador;

public class StartCommand extends CommandImpl {

    public StartCommand(Temporizador t) {
        super(t);
    }

    public void execute() {
        getReceiver().serviceStart();
    }
}
