package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndCookOff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] competitors = new int[N][5];
        for (int i = 0; i < N; i++) {
            int c = 0;
            for (int j = 0; j < competitors[i].length; j++) {
                competitors[i][j] = scanner.nextInt();
                if (competitors[i][j] == 1) {
                    c++;
                }
            }
            if (c == 0) {
                System.out.println("Beginner");
            } else if (c == 1) {
                System.out.println("Junior Developer");
            } else if (c == 2) {
                System.out.println("Middle Developer");
            } else if (c == 3) {
                System.out.println("Senior Developer");
            } else if (c == 4) {
                System.out.println("Hacker");
            } else {
                System.out.println("Jeff Dean");
            }
        }
    }
}
