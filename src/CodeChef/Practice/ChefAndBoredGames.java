package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndBoredGames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int i = 1;
            long ans = 0;
            while (i <= N) {
                ans += ((N-i)+1)*((N-i)+1);
                i += 2;
            }
            System.out.println(ans);
        }
    }
}
