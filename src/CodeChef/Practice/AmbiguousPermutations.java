package CodeChef.Practice;

import java.util.Scanner;

public class AmbiguousPermutations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        outer : while (true) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;
            }
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                if (arr[arr[i] - 1] != i + 1) {
                    System.out.println("not ambiguous");
                    continue outer;
                }
            }
            System.out.println("ambiguous");
        }
    }
}
