package sopar.filosofs;

import java.util.Random;

public class Filosofs extends Thread {
    private Forquilla fDreta;
    private Forquilla fEsquerra;
    private int gana = 0;
    private String nom;
    private Random rnd = new Random();

    public Filosofs(Forquilla fEsquerra, Forquilla fDreta, String nom) {
        this.fDreta = fDreta;
        this.fEsquerra = fEsquerra;
        this.nom = nom;
    }

    public Forquilla getfDreta() {
        return fDreta;
    }
    public void setfDreta(Forquilla fDreta) {
        this.fDreta = fDreta;
    }
    public int getGana() {
        return gana;
    }
    public void setGana(int gana) {
        this.gana = gana;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Forquilla getfEsquerra() {
        return fEsquerra;
    }

    public void setfEsquerra(Forquilla fEsquerra) {
        this.fEsquerra = fEsquerra;
    }

    private void sleeping(int sleepTime) throws InterruptedException {
        Thread.sleep(sleepTime);
        Thread.sleep(rnd.nextInt(sleepTime));
    }
    public void menjar() throws InterruptedException {
        System.out.println(nom + " menja.");
        sleeping(1000);
        gana++;
    }
    public void pensar() throws InterruptedException {
        System.out.println(nom + " pensa.");
        sleeping(1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                while (true) {
                    if (fEsquerra.agafa(this, "Esquerra")) {
                        if (fDreta.agafa(this, "Dreta")){
                            menjar();
                            fDreta.deixa(this, "Dreta");
                            fEsquerra.deixa(this, "Esquerra");
                            break;
                        } else {
                            fEsquerra.deixa(this, "Esquerra");
                        }
                    }
                    sleeping(500);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return "Nom: "+nom+ ", Forquilla Esquerra: "+fEsquerra+", Forquilla Esquerra: "+ fDreta;
    }
}
