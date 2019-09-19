package CodeChef.Practice;

import java.util.Scanner;

public class Trisq {

    private static int rec(int B) {
        if (B <= 0) {
            return 0;
        }
        return (B-2)/2 + rec(B-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int B = scanner.nextInt();
            System.out.println(rec(B));
        }
    }
}
