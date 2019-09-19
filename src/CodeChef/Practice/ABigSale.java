package CodeChef.Practice;

import java.util.Scanner;

public class ABigSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            double loss = 0;
            for (int i = 0; i < N; i++) {
                int p = scanner.nextInt(), qty = scanner.nextInt(), disc = scanner.nextInt();
                double incre = qty * p +  qty * (p * (double)disc/100);
                double decre = incre - (incre * (double)disc/100);
                loss += ((qty * p) - decre);
            }
            System.out.println(loss);
        }
    }
}
