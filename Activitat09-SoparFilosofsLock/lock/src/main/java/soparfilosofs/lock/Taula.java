package soparfilosofs.lock;

import java.util.ArrayList;

public class Taula {
    private static ArrayList<Forquilla> forquillesList = new ArrayList<>();
    private static ArrayList<Filosofs> filosofsList = new ArrayList<>();

    public static void main(String[] args) {
        showTaula();
        cridarTaula();
    }

    public static void showTaula(){
        for (int i = 1; i <= 5; i++) {
            forquillesList.add(new Forquilla("For " + i));
        }

        for (int i = 0; i < 5; i++) {
            if (i == 4) {
                filosofsList.add(new Filosofs(forquillesList.get(i), forquillesList.get(5-i), "Fil " + (i + 1)));
            } else {
                filosofsList.add(new Filosofs(forquillesList.get(i), forquillesList.get(i + 1), "Fil " + (i + 1)));
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (Filosofs f : filosofsList) {
            System.out.println("+ "+f+" +");
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    public static void cridarTaula(){
        for (Filosofs f : filosofsList) {
            f.start();
        }
    }
}