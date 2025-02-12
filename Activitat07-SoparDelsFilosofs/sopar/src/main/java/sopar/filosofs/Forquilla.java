package sopar.filosofs;

public class Forquilla {
    private boolean enUs = false;
    private String nom;

    public Forquilla(boolean enUs, String nom) {
        this.enUs = enUs;
        this.nom = nom;
    }

    public boolean isEnUs() {
        return enUs;
    }

    public void setEnUs(boolean enUs) {
        this.enUs = enUs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public synchronized  boolean agafa(Filosofs f, String costat){
        boolean disponible = !enUs;
        if(enUs){
            return disponible;
        }
        enUs = disponible;
        System.out.println(f.getNom()+ " Agafa "+nom+" Costat"+ costat);
        return disponible;
    }
    public synchronized  void deixa(Filosofs f, String costat){
        enUs = false;
        System.out.println(f.getNom()+ " Deixa "+nom+" Costat"+ costat);
        notifyAll();
    }
    @Override
    public String toString() {
        return nom;
    }
}