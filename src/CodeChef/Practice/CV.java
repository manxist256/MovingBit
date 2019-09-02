package CodeChef.Practice;

import java.util.Scanner;

public class CV {

    static boolean vowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String s = scanner.nextLine();
            int ans = 0;
            for (int i = 0; i < s.length() - 1; i++) {
                if (!vowel(s.charAt(i)) && vowel(s.charAt(i + 1))) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
