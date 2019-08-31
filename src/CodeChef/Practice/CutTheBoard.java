package CodeChef.Practice;

import java.util.Scanner;

public class CutTheBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), M = scanner.nextInt();
            System.out.println((N-1)*(M-1));
        }
    }
}
