package CodeChef.Encoding2019;

import java.util.Scanner;

public class ADDI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long num = scanner.nextLong();
            String s = Long.toBinaryString(num);
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
