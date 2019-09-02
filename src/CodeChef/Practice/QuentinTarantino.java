package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class QuentinTarantino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
                set.add(arr[i] + 1);
            }
            int x = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > N)  {
                    System.out.println("no");
                    continue outer;
                }
                if(i + 1 == arr[i]) {
                    x++;
                }
            }
            System.out.println((set.size() != N || x == N) ? "no" : "yes");
        }
    }
}
