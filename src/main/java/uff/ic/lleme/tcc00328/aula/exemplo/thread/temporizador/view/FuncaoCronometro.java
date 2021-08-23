package uff.ic.lleme.tcc00328.aula.exemplo.thread.temporizador.view;

public class FuncaoCronometro extends Funcao {

    private static final long serialVersionUID = 1L;

    public FuncaoCronometro() {
        super("Cronometro");
        setMostrador(new MostradorCronometro(200));
        setBotoeira(new Botoeira(getMostrador().getTemporizador()));
        initComponents();
    }

    private void initComponents() {
        add(getMostrador());
        add(getBotoeira());
    }
}
