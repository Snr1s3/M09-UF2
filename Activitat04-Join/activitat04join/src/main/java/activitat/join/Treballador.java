package activitat.join;

import java.util.Random;

public class Treballador extends Thread {
    private float sou_anual_brut;
    private int edat_inici_treball;
    private int edat_fi_treball;
    private String nom;
    private int edat_actual;
    private float cobrat;
    private Random rnd;

    public Treballador(float sou_anual_brut, int edat_inici_treball, int edat_fi_treball, String nom) {
        super(nom);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici_treball = edat_inici_treball;
        this.edat_fi_treball = edat_fi_treball;
        this.edat_actual = 0;
        this.cobrat = 0.0f;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        while (edat_actual < edat_fi_treball) {
            try {
                Thread.sleep(rnd.nextInt(200));
                cobra();
                pagaImpostos();
                edat_actual++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void cobra(){
        cobrat += sou_anual_brut / 12;
    }

    public void pagaImpostos(){
        cobrat -= cobrat * 0.24;
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edat_actual;
    }
}
