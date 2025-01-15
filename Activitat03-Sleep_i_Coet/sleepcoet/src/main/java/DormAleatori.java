
public class DormAleatori extends Thread{
    private long tempsConstruccio;
    private long nouTemps;
    private long interval_aleatori;
    public DormAleatori(String name) {
        super(name);
        tempsConstruccio = System.currentTimeMillis();
        nouTemps = 1;
        interval_aleatori = 2000;
    }

    @Override
    public void run(){
        try {
            for(int num_iteració = 0; num_iteració<10; num_iteració++){
                interval_aleatori = (long) (Math.random()*500) + 2000;
                System.out.println(getString(num_iteració));
                Thread.sleep(interval_aleatori);
                nouTemps = System.currentTimeMillis() - tempsConstruccio;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getString(int interactions) {
        return getName()+"("+interactions+") a dormir "+ interval_aleatori + "ms total "+nouTemps;
    }

}