package CodeChef.Practice;

import java.util.Scanner;

public class Workers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int m1 = 10000000, m2 = 10000000, m3 = 10000000;
        int[] cost = new int[N];
        int[] type = new int[N];
        for (int i = 0; i < N; i++) {
            cost[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            type[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            if (type[i] == 1) {
                if (cost[i] < m1) m1 = cost[i];
            } else if (type[i] == 2) {
                if (cost[i] < m2) m2 = cost[i];
            }  else {
                if (cost[i] < m3) m3 = cost[i];
            }
        }
        System.out.println(Math.min(m3, m1 + m2));
    }
}
