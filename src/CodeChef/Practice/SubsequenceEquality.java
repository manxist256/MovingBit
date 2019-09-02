package CodeChef.Practice;

import java.util.Scanner;

public class SubsequenceEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String s = scanner.nextLine();
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 97]++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 1) {
                    System.out.println("yes");
                    continue outer;
                }
            }
            System.out.println("no");
        }
    }
}
