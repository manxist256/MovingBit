package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAnd2Strings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();
            int d = 0; int m = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != '?' && s2.charAt(i) != '?' && s1.charAt(i) != s2.charAt(i)) {
                    d++;
                } else if (s1.charAt(i) == '?' || s2.charAt(i) == '?') {
                    m++;
                }
            }
            System.out.println(d + " " + (d + m));
        }
    }
}
