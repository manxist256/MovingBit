package CodeChef.Practice;

import java.util.Scanner;

public class LostMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- >  0) {
            String[] strings = scanner.nextLine().split(" ");
            int max = -1, N = strings.length - 1, f = 0;
            for (int i = 0; i < strings.length; i++) {
                int num = Integer.parseInt(strings[i]);
                if (f == 0 && num == N) {
                    f = 1;
                    continue;
                }
                if (num > max) {
                    max = num;
                }
            }
            System.out.println(max);
        }
    }
}
