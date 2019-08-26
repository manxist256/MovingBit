package CodeChef.Practice;

import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int max = 0, balance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    balance++;
                } else {
                    balance--;
                }
                max = Math.max(max, balance);
            }
            for (int i = 0; i < max; i++) {
                System.out.print("(");
            }
            for (int i = 0; i < max; i++) {
                System.out.print(")");
            }
            System.out.println();
        }
    }
}
