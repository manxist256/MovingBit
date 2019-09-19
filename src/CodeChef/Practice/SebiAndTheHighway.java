package CodeChef.Practice;

import java.util.Scanner;

public class SebiAndTheHighway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int TC = scanner.nextInt();
        while (TC -- > 0) {
            int S = scanner.nextInt(), SG = scanner.nextInt(), FG = scanner.nextInt(), D = scanner.nextInt(), T = scanner.nextInt();
            float ACKmph = (float)((D*50.0*3600.0)/(1000.0*T)) + S;
            float SebiC = Math.abs(ACKmph - SG);
            float FathC = Math.abs(ACKmph - FG);
            System.out.println(SebiC == FathC ? "DRAW" : (FathC < SebiC ? "FATHER" : "SEBI"));
        }
    }
}
