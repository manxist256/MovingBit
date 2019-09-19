package CodeChef.Practice;

import java.util.Scanner;

public class BalsaForTheThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            long N = scanner.nextLong();
            while (true) {
                N += 1;
                long K = N;
                int c = 0;
                while (K > 0) {
                    long r = K % 10;
                    K /= 10;
                    if (r == 3) {
                        c++;
                    }
                }
                if (c >= 3) {
                    System.out.println(N);
                    break;
                }
            }
        }
    }
}
