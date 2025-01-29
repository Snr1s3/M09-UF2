package espera.wait;

import java.util.ArrayList;
import java.util.List;

public class Esdeveniment {
    private List<Assistent> assistents = new ArrayList<>();
    private int placesDisponbles;

    public Esdeveniment(int placesDisponbles){
        this.placesDisponbles = placesDisponbles;
    }

    public synchronized void ferReserva(Assistent assistent){
        if(placesDisponbles== 0){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        assistents.add(assistent);
        System.out.println(assistent.getNom()+" ha fet una reserva. Places disponibles: "+placesDisponbles);
        placesDisponbles--;
        notifyAll();
    }

    public synchronized void cancelaReserva(Assistent assistent){
        if(assistents.equals(assistent)){
            assistents.remove(assistent);
            System.out.println(assistent.getNom()+" no ha pogut cancel·lar una reserva inexistent. Places disponibles: "+placesDisponbles);
            placesDisponbles++;
            notifyAll();
        }
        else{
            System.out.println(assistent.getNom()+" no ha pogut cancel·lar una reserva inexistent. Places disponibles: "+placesDisponbles);
        }
    }
}