package barber.mandros;

import java.util.Random;

public class Barber extends Thread{
    private String nom;
    private Barberia barberia; 

    public Barber(String nom, Barberia barberia) {
        this.nom = nom;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            try {
                barberia.waitForClient();
                Client client = barberia.seguentClient(); 
                if (client != null) {
                    client.tallarseElCabell();
                    Thread.sleep(900 + new Random().nextInt(100));
                }
            } catch (InterruptedException e) {
                System.out.println(nom + " ha estat interromput.");
                break;
            }
        }
    }
}