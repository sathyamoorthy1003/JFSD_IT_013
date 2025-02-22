
import java.util.Scanner;

public class evennomatrix {

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        int i, j;
        Scanner sc = new Scanner(System.in);
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.println("Enter the number");
                arr[i][j] = sc.nextInt();
            }
        }
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (arr[i][j] % 2 == 0) {
                    System.out.println(arr[i][j]);
                }
            }
        }
    }
}
