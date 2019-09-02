package CodeChef.Practice;

import java.util.Scanner;

public class SecretRecipe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int X1 = scanner.nextInt(), X2 = scanner.nextInt(), X3 = scanner.nextInt();
            int V1 = scanner.nextInt(), V2 = scanner.nextInt();
            int d1 = X3 - X1, d2 = X2 - X3;
            double t1 = (double)d1 / V1, t2 =(double) d2 / V2;
            System.out.println(t1 < t2 ? "Chef" : (t1 == t2 ? "Draw" : "Kefa"));
        }
    }
}
