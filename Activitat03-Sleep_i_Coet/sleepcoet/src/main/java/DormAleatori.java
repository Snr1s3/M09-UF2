
public class DormAleatori extends Thread{
    private long time;
    private long newT;
    private long sleepT;
    public DormAleatori(String name) {
        super(name);
        time = System.currentTimeMillis();
        newT = 1;
        sleepT = 2000;
    }

    @Override
    public void run(){
        try {
            for(int i = 0; i<10; i++){
                sleepT = (long) (Math.random()*500) + 2000;
                System.out.println(getString(i));
                Thread.sleep(sleepT);
                newT = System.currentTimeMillis() - time;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getString(int interactions) {
        return getName()+"("+interactions+") a dormir "+ sleepT + "ms total "+newT;
    }

}