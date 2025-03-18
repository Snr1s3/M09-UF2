package barber.mandros;

import java.util.Random;

public class Barber {
    private String nom;
 private Barberia barberia;
    private Random random = new Random();

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            Client client = barberia.agafaClient();
            if (client != null) {
                try {
                    System.out.println(nom + " està tallant el cabell del client " + client.getId() + ".");
                    Thread.sleep(900 + random.nextInt(100));
                    System.out.println(nom + " ha acabat de tallar el cabell del client " + client.getId() + ".");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                barberia.acabaTall(); 
            } else {
                try {
                    System.out.println(nom + " està dormint esperant clients.");
                    synchronized (barberia) {
                        barberia.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}