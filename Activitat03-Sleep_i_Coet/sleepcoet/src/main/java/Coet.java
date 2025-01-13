import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coet {
    public static Motor[] motors;
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static int numPropulsors = 4;
    public static int velocitatObjectiu = 1;
    public static void main(String[] args){
        motors = new Motor[numPropulsors];
        for(int i = 0; i< numPropulsors; i++){
            motors[i] = new Motor("Motor "+i);
        }
        while(velocitatObjectiu >= 0){
            velocitatObjectiu = isInt();
            while(!passaApotencia(velocitatObjectiu)){
                velocitatObjectiu = isInt();
            }
            System.out.println("Passant a potència: "+ velocitatObjectiu);
            for (int i = 0; i < numPropulsors; i++) {
                motors[i].setPotencia(velocitatObjectiu);
            }
            if(velocitatObjectiu == 0){
                break;
            }
        }
    }
    public static boolean passaApotencia(int p){
        if(p >=0 && 10 >= p){
            return true;
        }
        else{
            System.out.println("Nombre invàlid!!");
            return false;
        }
    }

    public static String readUserInput() {
        try {
            String line = reader.readLine();
            if (line == null) {
                throw new RuntimeException("Line == Null");
            }
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int isInt() {
        int num = 0;
        boolean validNum = false;
        while (!validNum) {
            try {
                String userInput = readUserInput();
                num = Integer.parseInt(userInput);
                validNum = true;
            } catch (NumberFormatException e) {
                System.out.println("L'entrada no és un número vàlid.");
            }
        }
        return num;
    }
}
