package activitat05synchronized;

import java.util.Random;

public class Associacio {
    private static int numSocis;
    private static Soci[] Socis;

    public Associacio(Compte compte){
        numSocis= 1000;
        Socis = new Soci[numSocis];
        for(int i = 0; i < numSocis; i++){
            Socis[i] = new Soci(compte);
        }
    }

    private void iniciaCompteTempsSocis(){
        for(Soci soci: Socis){
            soci.start();
        }
    }
    private void esperaPeriodeSocis(){
        for(Soci soci: Socis){
            try {
                soci.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
    private void mostraBalancComptes(){
        Random rand = new Random();
        System.out.println("Saldo: " + Socis[rand.nextInt(1000)].getCompte().getSaldo());
        /*for(Soci i: Socis){
            System.out.println("Saldo: " + i.getCompte().getSaldo());
        }*/
    }
    public static void main(String[] Bondia){
        Compte compte = Compte.crearCompte();
        Associacio a = new Associacio(compte);
        a.iniciaCompteTempsSocis();
        a.esperaPeriodeSocis();
        a.mostraBalancComptes();
    }

}
