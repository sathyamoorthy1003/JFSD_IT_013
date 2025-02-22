
import java.util.Scanner;

public class Prime {
    // prime number
    public static void main(String[] args) {
        System.out.print("enter a number");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2;
        boolean isPrime = true;
        while (i <= Math.sqrt(n)) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
            i++;
        }

        if (isPrime && n > 1) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
