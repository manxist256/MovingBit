package CodeChef.Practice;

import java.util.Scanner;

public class HeavenToEarth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            double N = scanner.nextDouble(), V1 = scanner.nextDouble(), V2 = scanner.nextDouble();
            System.out.println((N*V1*1.414) >  (N*V2) ? "Stairs" : "Elevator");
        }
    }
}
