package soparfilosofs.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int propietari;
    private int Lliure;
    private String nom;
    private int num;
    private final ReentrantLock bloqueig = new ReentrantLock();

    public Forquilla(String nom) {
        this.nom = nom;
        Lliure = -1;
    }

    public Forquilla(int num) {
        this.num = num;
        Lliure = -1;
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

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return nom;
    }

    public boolean agafa(Filosofs f, String costat) {
        bloqueig.lock();
        try {
            if (Lliure != -1) {
                return false;
            }
            String[] numF = f.getNom().split(" ");
            propietari = Integer.parseInt(numF[1]);
            return true;
        } finally {
            bloqueig.unlock();
        }
    }

    public void deixa(Filosofs f, String costat) {
        bloqueig.lock();
        try {
            propietari = Lliure;
        } finally {
            bloqueig.unlock();
        }
    }
}