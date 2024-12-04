public class Fil extends Thread{
    String name;
    public Fil(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 1; i < 10; i++){
            System.out.println(name + " " + i);
        }
        System.out.println("Termina el fil " + name);
        
    }
}