package activitat05synchronized;

import java.util.Random;

public class Soci extends Thread{
    private Compte compte;
    private float aportacio;
    private int esperaMax;
    private int maxAnys;
    private Random rnd;

    public Soci(Compte compte){
        this.compte =compte;
        aportacio = 10f;
        esperaMax = 100;
        maxAnys = 10;
        rnd = new Random();
    }

    @Override
    public void run() {
        for(int i = 1; i<=maxAnys; i++) {
            for(int k = 1; k<=12; k++) {
                try {
                    Thread.sleep(rnd.nextInt(esperaMax));
                    if(k%2==0){
                        compte.setSaldo(compte.getSaldo()+aportacio);
                    }
                    else{
                        compte.setSaldo(compte.getSaldo()-aportacio);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Compte getCompte(){
        return compte;
    }
}
