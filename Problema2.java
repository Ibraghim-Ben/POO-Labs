import java.util.Scanner;

public class Problema2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceți numărul natural nenul n (1 ≤ n ≤ 100): ");
        int n = sc.nextInt();

        System.out.println("Perechile x y cu proprietatea că x + y = " + n + " și 0 < x ≤ y sunt:");
        for (int x = 1; x <= n / 2; x++) {
            int y = n - x;
            if (x <= y) {
                System.out.println(x + " " + y);
            }
        }
    }
}