
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number");
            int s=sc.nextInt();
            if(s%2!=0){
                System.out.println("good bye");
                break;
            }
            else
            {
                System.err.println("congrats:you won");
            }
            
        }
    }
    
}
