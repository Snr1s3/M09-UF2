package espera.wait;

public class Organitzador {
    public static void main(String[] args){
        Esdeveniment esd = new Esdeveniment(5);
        Assistent[] assistents = new Assistent[10];
        for(int num = 0; num < 10; num++){
            assistents[num] = new Assistent("Assistent " + (num + 1), esd);
        }
        for(Assistent a: assistents){
            a.start();
        }
    }
}
