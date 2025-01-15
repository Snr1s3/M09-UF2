import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Coet {
    public static Motor[] motors;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int numPropulsors = 4;
    public static int velocitatObjectiu = 0;
    public static void main(String[] args){
        motors = new Motor[numPropulsors];
        for(int i = 0; i< numPropulsors; i++){
            motors[i] = new Motor("Motor "+i);
        }
        velocitatObjectiu = readUserInput();
        if(velocitatObjectiu == 0){
            return;
        }
        passaAPotencia(velocitatObjectiu);
        for (Motor motor : motors) {
            motor.start();
        }
        while(velocitatObjectiu != 0){
            velocitatObjectiu = readUserInput();
            passaAPotencia(velocitatObjectiu);
        }
    }

    public static void passaAPotencia(int p) {
        if (p >= 0 && p <= 10) {
            for (Motor motor : motors) {
                motor.setPotencia(p);
                
            }
        System.out.println("Passant a potència " + p);
        } else {
            System.out.println("Error: La potència ha de ser entre 0 i 10.");
        }
    }
    public static int readUserInput() {
        int num = 0;
        boolean validNum = false;
        while (!validNum) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    throw new RuntimeException("Line == Null");
                }
                num = Integer.parseInt(line);
                validNum = true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return num;
    }
}
