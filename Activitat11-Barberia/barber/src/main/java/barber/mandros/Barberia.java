package barber.mandros;

import java.util.LinkedList;
import java.util.Queue;

public class Barberia {
    private Queue<Client> salaEspera; 
    private int maxCadires; 
    private final Object condBarber = new Object(); 
    private static Barberia instancia; 

    public Barberia(int maxCadires) {
        this.salaEspera = new LinkedList<>();
        this.maxCadires = maxCadires;
    }

    public static synchronized Barberia getInstancia(int maxCadires) {
        if (instancia == null) {
            instancia = new Barberia(maxCadires);
        }
        return instancia;
    }

    public Client seguentClient() {
        synchronized (condBarber) {
            return salaEspera.poll();
        }
    }

    public void entrarClient(Client client) {
        synchronized (condBarber) {
            if (salaEspera.size() < maxCadires) {
                salaEspera.add(client); 
                System.out.println("Client " + client.getNom() + " en espera");
                condBarber.notify(); 
            } else {
                System.out.println("No queden cadires, client " + client.getNom() + " se'n va");
            }
        }
    }

    public void waitForClient() throws InterruptedException {
        synchronized (condBarber) {
            while (salaEspera.isEmpty()) {
                System.out.println("Ningú en espera");
                System.out.println("Barber " + Thread.currentThread().getName() + " dormint");
                condBarber.wait();
            }
        }
    }

    public void executar() {
        Thread thread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    entrarClient(new Client(i));
                    Thread.sleep(500); 
                }
                Thread.sleep(10000);
                for (int i = 11; i <= 20; i++) {
                    entrarClient(new Client(i));
                    Thread.sleep(500); 
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });
        thread.start();
    }

    public static void main(String[] args) {
        Barberia barberia = Barberia.getInstancia(3);
        Barber barber = new Barber("Barber-Mandros", barberia);
        barber.start();
        barberia.executar();
    }
}