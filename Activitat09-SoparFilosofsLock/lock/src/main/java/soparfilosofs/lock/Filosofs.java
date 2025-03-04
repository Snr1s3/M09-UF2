package soparfilosofs.lock;

import java.util.Random;

public class Filosofs extends Thread {
    private Forquilla fDreta;
    private Forquilla fEsquerra;
    private String nom;
    private int iniciGana;
    private int fiGana;
    private int Gana;
    private Random rnd = new Random();

    public Filosofs(Forquilla fEsquerra, Forquilla fDreta, String nom) {
        this.fEsquerra = fEsquerra;
        this.fDreta = fDreta;
        this.nom = nom;
        this.Gana = 0;
    }


    public Forquilla getfDreta() {
        return fDreta;
    }

    public void setfDreta(Forquilla fDreta) {
        this.fDreta = fDreta;
    }

    public Forquilla getfEsquerra() {
        return fEsquerra;
    }

    public void setfEsquerra(Forquilla fEsquerra) {
        this.fEsquerra = fEsquerra;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIniciGana() {
        return iniciGana;
    }

    public void setIniciGana(int iniciGana) {
        this.iniciGana = iniciGana;
    }

    public int getFiGana() {
        return fiGana;
    }

    public void setFiGana(int fiGana) {
        this.fiGana = fiGana;
    }

    public int getGana() {
        return Gana;
    }

    public void setGana(int gana) {
        Gana = gana;
    }

    public Random getRnd() {
        return rnd;
    }

    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }

    private void sleeping(int time ) throws InterruptedException {
        Thread.sleep(time + rnd.nextInt(time));
    }

    public void menjar() {
        fiGana = (int) (System.currentTimeMillis() / 1000);
        Gana = calcularGana();
        System.out.println(nom + " menjant amb gana " + Gana);
        try {
            sleeping(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resetGana();
        System.out.println(nom + " ha acabat de menjar.");          
    }

    public void agafarForquilles() {
        if(agafarForquillaEsquerra()){
            if(agafarForquillaDreta()){
                System.out.println(nom + " té forquilles esq(" + fEsquerra + ") dreta(" + fDreta + ")");
                menjar();
                dixarForquilles();
            }
            else{
                fEsquerra.deixa(this, "esquerra");
                System.out.println(nom + " deixa forquilla esquerre");
                try {
                    sleeping(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            try {
                sleeping(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean agafarForquillaEsquerra() {
        return fEsquerra.agafa(this, "esquerra");
    }

    public boolean agafarForquillaDreta() {
        return fDreta.agafa(this, "dreta");
    }

    public void dixarForquilles() {
        fDreta.deixa(this, "dreta");
        fEsquerra.deixa(this, "esquerra");
        System.out.println(nom + " deixa forquilles");
    }

    public void pensar() {
        System.out.println(nom + " pensant.");
        resetGana();
        try {
            sleeping(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int calcularGana() {
        return fiGana - iniciGana;
    }

    public void resetGana() {
        iniciGana = (int) (System.currentTimeMillis() / 1000);
        Gana = 0;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            agafarForquilles();
        }
    }
    public String toString() {
        return "Comensal: "+nom+" "+fEsquerra+" "+fDreta;
    }
}
