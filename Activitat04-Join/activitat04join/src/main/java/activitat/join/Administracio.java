package activitat.join;

public class Administracio {

    private int num_poblacio_activa = 4;
    private Treballador[] poblacio_activa;

    public Administracio() {
        poblacio_activa = new Treballador[num_poblacio_activa];
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador(25000.0f, 20, 65, "Ciutadà " + i);
        }
    }

    public static void main(String[] args) {
        Administracio adm = new Administracio();
        for (Treballador tre : adm.poblacio_activa) {
            tre.start();
        }
        for (Treballador tre : adm.poblacio_activa) {
            try {
                tre.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Treballador tre : adm.poblacio_activa) {
            System.out.println(tre.getName() + "  -> edat: " + tre.getEdat() +" / total: " + String.format("%.2f", tre.getCobrat()));
        }
        System.out.println("Tots els treballadors han acabat.");
    }
}