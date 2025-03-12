package fuma.dors;

public class Barri {
    private Estanc estanc;
    private Fumador[] fumadors;

    public Barri() {
        estanc = new Estanc();
        fumadors = new Fumador[3];
        for (int i = 0; i < 3; i++) {
            fumadors[i] = new Fumador(estanc, i + 1);
        }
    }

    public void iniciar() {
        estanc.start();
        for (Fumador fumador : fumadors) {
            fumador.start();
        }
        for (Fumador fumador : fumadors) {
            try {
                fumador.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        estanc.tancarEstanc();
    }

    public static void main(String[] args) {
        Barri barri = new Barri();
        barri.iniciar();
    }
}