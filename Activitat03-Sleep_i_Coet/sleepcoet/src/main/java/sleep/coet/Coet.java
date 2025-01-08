package sleep.coet;
public class Coet {
    public static Motor[] motors = new Motor[4];
    public static void main(String[] args){
        for(int i = 0; i< 4; i++){
            motors[i] = new Motor("Motor "+i);
        }
        for(int i = 0; i< 4; i++){
            motors[i].start();
        }
    }
}
