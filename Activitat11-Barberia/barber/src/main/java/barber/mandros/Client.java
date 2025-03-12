package barber.mandros;

public class Client {
    private int id;

    public Client(int id){
        this.id = id;
    }

    public String getNom(){
        return ""+id;
    }
}
