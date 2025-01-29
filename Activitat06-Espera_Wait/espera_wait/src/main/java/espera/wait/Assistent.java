package espera.wait;

import java.util.Random;

public class Assistent extends Thread{
    private Esdeveniment esdeveniment;
    private String nom;
    private Random random;

    public Assistent(String nom, Esdeveniment esdeveniment){
        this.nom = nom;
        this.esdeveniment = esdeveniment;
        this.random = new Random();
    }
    public String getNom(){
        return nom;
    }
    @Override
    public void run() {
        while (true) {
            try {
                if (random.nextInt(100) < 70) {
                    esdeveniment.ferReserva(this);
                } else {
                    esdeveniment.cancelaReserva(this);
                }
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
