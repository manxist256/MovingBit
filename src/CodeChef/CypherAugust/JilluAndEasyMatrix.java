package CodeChef.CypherAugust;

import java.io.PrintWriter;
import java.util.Scanner;

public class JilluAndEasyMatrix {

    static PrintWriter printWriter = new PrintWriter(System.out);

    static int[][] transpose(int N, int[][] arr) {
        int[][] newarr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N - 1, p = 0; j >= 0 && p < N; j--, p++) {
                newarr[i][p] = arr[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = newarr[i][j];
                newarr[i][j] = newarr[j][i];
                newarr[j][i] = temp;
            }
        }
        return newarr;
    }

    static void printArray(int[][] array, int N) {
        for (int k = 0; k < N; k++) {
            for (int j = 0; j < N; j++) {
                printWriter.print(array[k][j] + " ");
            }
            printWriter.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s[] = scanner.nextLine().split(" ");
            int N = Integer.parseInt(s[0]), Q = Integer.parseInt(s[1]);
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String row[] = scanner.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(row[j]);
                }
            }
            int[][] ninetyLeft = transpose(N, arr);
            int[][] oneEightlyLeft = transpose(N, ninetyLeft);
            int[][] twoSeventyLeft = transpose(N, oneEightlyLeft);
            int degree = 0;
            for (int i = 0; i < Q; i++) {
                String query[] = scanner.nextLine().split(" ");
                char x = query[0].charAt(0);
                int t = Integer.parseInt(query[1]);
                t %= 4;
                if (x == 'L') {
                    degree += (90 * t);
                    degree = degree % 360;
                } else if (x == 'R') {
                    int r = 4 - t;
                    if (t == 0) {
                        continue;
                    }
                    degree += (90 * (r % 4));
                    degree = degree % 360;
                }
            }
            if (degree == 0) {
                printArray(arr, N);
            }
            else if (degree == 90) {
                printArray(ninetyLeft, N);
            }
            else if (degree == 180) {
                printArray(oneEightlyLeft, N);
            }
            else if (degree == 270) {
                printArray(twoSeventyLeft, N);
            }
        }
        printWriter.flush();
    }
}
