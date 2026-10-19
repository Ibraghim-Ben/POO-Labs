import java.util.Scanner;

public class Problema3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduceți vârsta primului copil a (1 ≤ a ≤ 100): ");
        int a = sc.nextInt();

        System.out.print("Introduceți vârsta de-al doilea copil b (1 ≤ b ≤ 100): ");
        int b = sc.nextInt();

        int x;

        if (a > b) {
            x = a - b;
            System.out.println("Primul copil este mai mare cu " + x + " ani");
        }
        else if (b > a) {
            x = b - a;
            System.out.println("Al doilea copil este mai mare cu " + x + " ani");
        }
        else {
            System.out.println("Copiii au varste egale");
        }
    }
}
