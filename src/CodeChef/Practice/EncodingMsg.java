package CodeChef.Practice;

import java.util.Scanner;

public class EncodingMsg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            StringBuilder step1 = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2) {
                if (!(s.length() % 2 != 0 && i == s.length() - 1)) {
                    step1.append(s.charAt(i + 1));
                }
                step1.append(s.charAt(i));
            }
            String s1 = step1.toString();
            StringBuilder step2 = new StringBuilder();
            for (int i = 0; i < s1.length(); i++) {
                int sfb = s1.charAt(i) - 97;
                step2.append((char)(122-sfb));
            }
            System.out.println(step2);
        }
    }
}
