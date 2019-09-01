package CodeChef.Practice;

import java.util.Scanner;

public class UniformTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int c = 0;
            if (s.charAt(0) != s.charAt(s.length() - 1)) {
                c++;
            }
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    c++;
                }
            }
            System.out.println(c <= 2 ? "uniform" : "non-uniform");
        }
    }
}
