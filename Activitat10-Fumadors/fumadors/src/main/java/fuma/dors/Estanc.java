package fuma.dors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanc extends Thread {
    private List<Tabac> tabacList = new ArrayList<>();
    private List<Paper> paperList = new ArrayList<>();
    private List<Llumi> llumiList = new ArrayList<>();
    private boolean estancObert = true;
    private Random rnd = new Random();

    public Estanc() {
    }

    public synchronized void nouSubministrament() {
        int producte = rnd.nextInt(3);
        switch (producte) {
            case 0:
                addTabac();
                break;
            case 1:
                addPaper();
                break;
            case 2:
                addLlumi();
                break;
        }
    }

    public synchronized void addTabac() {
        tabacList.add(new Tabac());
        System.out.println("Afegint Tabac");
        notifyAll();
    }

    public synchronized void addPaper() {
        paperList.add(new Paper());
        System.out.println("Afegint Paper");
        notifyAll();
    }

    public synchronized void addLlumi() {
        llumiList.add(new Llumi());
        System.out.println("Afegint Llumi");
        notifyAll();
    }

    public synchronized Tabac venTabac() {
        while (tabacList.isEmpty() && estancObert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!tabacList.isEmpty()) {
            tabacList.remove(0);
            return new Tabac();
        }
        return null;
    }

    public synchronized Paper venPaper() {
        while (paperList.isEmpty() && estancObert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!paperList.isEmpty()) {
            paperList.remove(0);
            return new Paper();
        }
        return null;
    }

    public synchronized Llumi venLlumi() {
        while (llumiList.isEmpty() && estancObert) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (!llumiList.isEmpty()) {
            llumiList.remove(0);
            return new Llumi();
        }
        return null;
    }

    public synchronized void tancarEstanc() {
        estancObert = false;
        System.out.println("Estanc tancat");
        notifyAll();
    }

    @Override
    public void run() {
        try {
            while (estancObert) {
                nouSubministrament();
                Thread.sleep(500 + rnd.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}