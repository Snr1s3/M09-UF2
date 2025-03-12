package fuma.dors;


public class Fumador extends Thread {
    private Estanc estanc;
    private int id;
    private Tabac tabac;
    private Llumi llumi;
    private Paper paper;
    private int numFumades;

    public Fumador(Estanc estanc, int id) {
        this.estanc = estanc;
        this.id = id;
        numFumades=0;
    }

    public void fuma() throws InterruptedException {
        if (tabac != null && paper != null && llumi != null) {
            System.out.println("Fumador " + id + " està fumant.");
            Thread.sleep(500 + (int) (Math.random() * 500));
            numFumades++;
            tabac = null;
            paper = null;
            llumi = null;
            System.out.println("Fumador " + id + " ha fumat " + numFumades + " vegades");
        }
    }

    public void compraTabac() {
        System.out.println("Fumador " + id + " compra tabac.");
        tabac = estanc.venTabac();
    }

    public void compraPaper() {
        System.out.println("Fumador " + id + " compra paper.");
        paper = estanc.venPaper();
    }

    public void compraLlumi() {
        System.out.println("Fumador " + id + " compra llumi.");
        llumi = estanc.venLlumi();
    }

    @Override
    public void run() {
        try {
            while (numFumades < 3) {
                compraTabac();
                compraPaper();
                compraLlumi();
                fuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}