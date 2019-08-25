package CodeChef.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class ChefColoring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            int[] arr = new int[3];
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'G') {
                    arr[0]++;
                } else if (s.charAt(i) == 'R') {
                    arr[1]++;
                } else if (s.charAt(i) == 'B') {
                    arr[2]++;
                }
            }
            Arrays.sort(arr);
            System.out.println(arr[0] + arr[1]);
        }
    }
}
