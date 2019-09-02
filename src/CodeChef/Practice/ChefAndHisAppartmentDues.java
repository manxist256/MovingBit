package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndHisAppartmentDues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] track = new int[N];
            int fine = 0; int backlog = 0;
            for (int i = 0; i < N; i++) {
                track[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                if (track[i] == 0) {
                    backlog++;
                    fine += 100;
                } else if (track[i] == 1 && backlog > 0) {
                    fine += 100;
                }
            }
            System.out.println(fine + backlog*1000);
        }
    }
}
