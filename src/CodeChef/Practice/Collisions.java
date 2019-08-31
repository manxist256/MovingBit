package CodeChef.Practice;

import java.util.Scanner;

public class Collisions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] strings = scanner.nextLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int M = Integer.parseInt(strings[1]);
            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s = scanner.nextLine();
                for (int j = 0; j < M; j++) {
                    arr[i][j] = s.charAt(j) - 48;
                }
            }
            int coll = 0;
            for (int i = 0; i < M; i++) {
                int k = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 1) {
                        k++;
                    }
                }
                coll += (k * (k-1)) / 2;
            }
            System.out.println(coll);
        }
    }
}
