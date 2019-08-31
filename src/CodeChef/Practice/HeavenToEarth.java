package CodeChef.Practice;

import java.util.Scanner;

public class HeavenToEarth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            //S = D/T
            double N = scanner.nextDouble(), V1 = scanner.nextDouble(), V2 = scanner.nextDouble();
            System.out.println((1.414*N/V1) <  (N*2/V2) ? "Stairs" : "Elevator");
        }
    }
}
