package sopar.filosofs;

public class Forquilla {
    private int propietari;
    private int Lliure;
    private String nom;

    public Forquilla(String nom) {
        this.nom = nom;
        Lliure = -1;
        propietari = Lliure;
    }

    public int getPropietari() {
        return propietari;
    }

    public void setPropietari(int propietari) {
        this.propietari = propietari;
    }

    public int getLliure() {
        return Lliure;
    }

    public void setLliure(int lliure) {
        Lliure = lliure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }

    public synchronized boolean agafa(Filosofs f, String costat) {
        //System.out.println(costat + "  "+ nom+ "  "+Lliure);
        if (propietari != -1) {
            System.out.println(f.getNom() + " agafa " + nom + " costat " + costat + " ocupada");
            return false;
        }
        propietari = Integer.parseInt(f.getNom().split(" ")[1]);
        System.out.println(f.getNom() + " agafa " + nom + " costat " + costat);
        return true;
    }

    public synchronized void deixa(Filosofs f, String costat) {
        propietari = Lliure;
        System.out.println(f.getNom() + " deixa " + nom + " costat " + costat);
        notifyAll();
    }
}