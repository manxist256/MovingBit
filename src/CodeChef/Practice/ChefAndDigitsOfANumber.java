package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndDigitsOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int z = 0, o = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    z++;
                } else {
                    o++;
                }
            }
            System.out.println((o == 1 || z == 1) ? "Yes" : "No");
        }
    }
}
