import java.util.Scanner;
public class Divisible{
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = sc.nextInt();
        Scanner kc = new Scanner(System.in);
        System.out.println("Enter a divider: ");
        int k = kc.nextInt();
        int i = 0;
        for (i = 0; i <= n; i++) {
            if (i % k == 0) {
                System.out.println("fizz");
            }
            else
            {
                System.out.println(i);
            }
        }
    }

    
}
