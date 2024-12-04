public class Fil extends Thread{
    String name;
    public Fil(String name){
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 1; i < 10; i++){
            System.out.println(name + " " + i);
        }
        System.out.println("Termina el fil " + name);
        
    }
}