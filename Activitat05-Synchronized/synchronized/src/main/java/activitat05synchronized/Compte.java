package activitat05synchronized;

public class Compte {
    private float saldo;
    private static Compte compte;

    public static Compte crearCompte(){
        if(compte == null){
            compte = new Compte();
        }
        return compte;
    } 
    public synchronized void transaccio(int k, float aportacio){
        if(k%2==0){
            compte.setSaldo(compte.getSaldo()+aportacio);
        }
        else{
            compte.setSaldo(compte.getSaldo()-aportacio);
        }
    }
    private Compte(){
        setSaldo(0);
    }

    public synchronized  void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public synchronized  float getSaldo(){
        return saldo;
    }
}