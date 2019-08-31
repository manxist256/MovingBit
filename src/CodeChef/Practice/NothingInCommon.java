package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class NothingInCommon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N1 = scanner.nextInt();
            int N2 = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            int[] arr = new int[N1];
            for (int i = 0; i < N1; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < N2; i++) {
                set.add(scanner.nextInt());
            }
            int c = 0;
            for (int i = 0; i < arr.length; i++) {
                if (set.contains(arr[i])) {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
