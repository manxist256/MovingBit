package CodeChef.Practice;

import java.util.Scanner;

public class Stipendum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            boolean fs = false; double sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 2) {
                    System.out.println("No"); continue outer;
                }
                if (arr[i] == 5) {
                    fs = true;
                }
                sum += arr[i];
            }
            System.out.println(fs && (sum/arr.length) >= 4 ? "Yes" : "No");
        }
    }
}
