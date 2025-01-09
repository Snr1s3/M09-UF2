
public class Motor extends Thread {
    private int objectiu;
    private int actual = 0;
    public Motor(String name) {
        super(name);
    }
    public synchronized void setPotencia(int p) {
        this.objectiu = p;
        new Thread(() -> {
            while(objectiu != actual){
                if(objectiu > actual){
                    actual++;
                }
                else if(objectiu < actual){
                    actual--;
                }
                System.out.println(getString());
                try{
                    Thread.sleep((long) (Math.random()) + 2000);
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public String getString() {
        return getName()+ " Incre. Objectiu: "+ objectiu + " Actual: "+actual;
    }
}
