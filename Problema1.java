import java.util.Scanner;
import java.util.Arrays;

public class Problema1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceți numărul de elemente n în vector (1 ≤ n ≤ 1000): ");
        int n = sc.nextInt();

        System.out.println("Introduceți " + n + " elemente ale vectorului (numere naturale mai mici decât 1.000.000):");
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
            int x = vector[i];
            boolean prim = true;

            if (x < 2) {
                prim = false;
            } else {
                for (int d = 2; d < x; d++) {
                    if (x % d == 0) {
                        prim = false;
                        break;
                    }
                }
            }

            if (prim) {
                vector[i] = 0;
                break;
            }
        }

        System.out.println("Vectorul după înlocuire este:");
        System.out.println(Arrays.toString(vector));
    }
}
