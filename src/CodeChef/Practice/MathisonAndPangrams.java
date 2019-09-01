package CodeChef.Practice;

import java.util.Scanner;

public class MathisonAndPangrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] prices = scanner.nextLine().split(" ");
            String s = scanner.nextLine();
            int[] arr = new int[26];
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i)-97]++;
            }
            int c = 0;
            for (int i = 0; i < 26; i++) {
                if (arr[i] == 0) {
                    c += Integer.parseInt(prices[i]);
                }
            }
            System.out.println(c);
        }
    }
}
