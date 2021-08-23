package uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.view;

import java.awt.event.ActionEvent;

import uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.model.Temporizador;
import uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.controller.Command;
import uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.controller.ResetCommand;

public class BotaoReset extends BotaoTemp {

    private static final long serialVersionUID = -1842445485507380512L;
    private Command tempCommand = null;

    public BotaoReset(Temporizador temporizador) {
        super("Reset", temporizador);
        tempCommand = new ResetCommand(temporizador);
    }

    public void actionPerformed(ActionEvent e) {
        e.getActionCommand();
        tempCommand.execute();
    }

    public void accept(Visitor visitor) {
        visitor.VisitBotaoReset(this);
    }
}
