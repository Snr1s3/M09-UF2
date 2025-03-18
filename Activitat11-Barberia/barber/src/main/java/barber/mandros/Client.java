package barber.mandros;

public class Client extends Thread {
    private String nom;

    public Client(int id) {
        this.nom = "Client-" + id;
    }

    public void tallarseElCabell() {
        System.out.println("Li toca al client " + nom);
        System.out.println("Tallant cabell a " + nom);
    }

    public String getNom() {
        return nom;
    }
}