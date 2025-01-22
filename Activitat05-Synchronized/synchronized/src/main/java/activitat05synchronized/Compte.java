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

    public static Compte crearCompte(float saldo){
        if(compte == null){
            compte = new Compte(saldo);
        }
        return compte;
    } 

    private Compte(){
        setSaldo(0);
    }
    private Compte(float saldo){
        setSaldo(saldo);
    }

    public void setSaldo(float saldo){
        this.saldo = saldo;
    }

    public float getSaldo(){
        return saldo;
    }
}