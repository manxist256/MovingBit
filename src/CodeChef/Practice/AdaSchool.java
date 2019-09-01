package CodeChef.Practice;

import java.util.Scanner;

public class AdaSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), M = scanner.nextInt();
            if ((N*M)%2==0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
