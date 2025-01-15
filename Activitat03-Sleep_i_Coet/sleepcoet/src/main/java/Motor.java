public class Motor extends Thread {
    private int objectiu;
    private int actual;

    public Motor(String name) {
        super(name);
        this.objectiu = 0;
        this.actual = 0;
    }

    public void setPotencia(int p) {
        this.objectiu = p;
    }

    @Override
    public void run() {
        try {
            while (true) {
                while (objectiu != actual) {
                    if (objectiu > actual) {
                        actual++;
                        System.out.println(getString(2));
                    } else if (objectiu < actual) {
                        actual--;

                    System.out.println(getString(1));
                    }
                    Thread.sleep((long) (Math.random() * 1000) + 1000); // Temps aleatori entre 1000 i 2000 mil·lisegons (1 i 2 segons)
                }
                Thread.sleep(100);
                //System.out.println(getName()+"hola");
                if (objectiu == 0 && actual == 0) {
                    System.out.println(getName() + " ha arribat a la potència 0 i surt.");
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getString(int n) {
        if(n == 1){
            return getName() + " Decre. Objectiu: " + objectiu + " Actual: " + actual;
        }
        else{
            return getName() + " Incre. Objectiu: " + objectiu + " Actual: " + actual;
        }
        
    }
}