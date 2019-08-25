package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class ChefAndRainbowStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            boolean varn = false;
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] > 7) {
                    varn = true;
                }
            }
            if (varn) {
                System.out.println("no");
                continue;
            }

            int bitonic = 0; boolean f = false;
            for (int i = 1; i < N; i++) {
                if (!f && arr[i] == 6 && arr[i - 1] == 7) {
                    f = true;
                    bitonic = i;
                }
            }
            if (!f) {
                System.out.println("no");
                continue;
            }
            HashSet<Integer> bb = new HashSet<>();
            bb.add(arr[0]);
            for (int i = 1; i < bitonic; i++) {
                if (!(arr[i] >= arr[i - 1])) {
                    System.out.println("no");
                    continue outer;
                }
                bb.add(arr[i]);
            }
            HashSet<Integer> bb2 = new HashSet<>();
            for (int i = bitonic; i < N; i++) {
                if (!(arr[i] <= arr[i - 1])) {
                    System.out.println("no");
                    continue outer;
                }
                bb2.add(arr[i]);
            }
            if (!(bb.size() == 7 && bb2.size() == 6)) {
                System.out.println("no");
                continue;
            }
            int p1 = 0, p2 = N - 1;
            while (p1 <= p2) {
                if (arr[p1++] != arr[p2--]) {
                    System.out.println("no");
                    continue outer;
                }
            }
            System.out.println("yes");
        }
    }
}
