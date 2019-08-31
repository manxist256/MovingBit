package CodeChef.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class ChefAndEmploymentTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[(arr.length + K) / 2]);
        }
    }
}
