public class Futbolista extends Thread {
    private static final int NUM_Jugadors = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;
    
    private int ngols;
    private int ntirades;

    public Futbolista(String name) {
        super(name);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override
    public void run() {
        MainDemoFil.demoFil();
        for (int i = 0; i < NUM_TIRADES; i++) {
            ntirades++;
            if (Math.random() < PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public static void main(String[] args){
        Futbolista[] jugadors = new Futbolista[NUM_Jugadors];
        for (int i = 0; i < NUM_Jugadors; i++) {
            jugadors[i] = new Futbolista("Jugador " + i);
            jugadors[i].start();
        }
        for (int i = 0; i < NUM_Jugadors; i++) {
            try {
                jugadors[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("Inici dels xuts --------------------");
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------------------");
        for (int i = 0; i < NUM_Jugadors; i++) {
            System.out.println(jugadors[i].getName() + " -> " + jugadors[i].getNgols() + " gols");
        }
    }
}