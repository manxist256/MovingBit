package CodeChef.Practice;

import java.util.Scanner;

public class RootsOfAQuadraticEq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt(), B = scanner.nextInt(), C = scanner.nextInt();
        double x1 = ((-1 * B) + Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
        double x2 = ((-1 * B) - Math.sqrt(Math.pow(B, 2) - (4 * A * C))) / (2 * A);
        System.out.println(x1);
        System.out.println(x2);
    }
}
