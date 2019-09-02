package CodeChef.Practice;

import java.util.Scanner;

public class IPLandRCB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int X = scanner.nextInt(), Y = scanner.nextInt();
            System.out.println(X-Y > 0 ? X - Y : 0);
        }
    }
}
