package barber.mandros;

public class Client extends Thread {
    private String nom;
    private Barberia barberia;

    public Client(Barberia barberia, int id) {
        this.nom = "Client " + id;
        this.barberia = barberia;
    }

    public String getNom() {
        return nom;
    }

    public void tallarseElCabell() {
        System.out.println(nom + " s'està tallant el cabell.");
        try {
            Thread.sleep(1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(nom + " ha acabat de tallar-se el cabell.");
    }

    @Override
    public void run() {
        barberia.arribaClient(this); 
    }
}