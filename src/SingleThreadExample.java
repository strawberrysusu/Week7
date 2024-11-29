import static java.lang.Math.PI;

public class SingleThreadExample {
    public static void main(String[] args) {
        while(true){
            System.out.println("Task1 : "+Math.random() / PI);
        }
    }
}