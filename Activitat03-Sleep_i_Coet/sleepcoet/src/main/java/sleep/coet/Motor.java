package sleep.coet;
public class Motor extends Thread {
    private int objective;
    private int actual;
    public Motor(String name) {
        super(name);
    }
    @Override
    public void run(){
        System.out.println(getString());
    }
    public String getString(int interactions) {
        return getName()+ "Incre. Objectiu: "+ objective + "Actual: "+actual;
    }
}
