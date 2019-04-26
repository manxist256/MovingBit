package CodeChef.Dementia2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxScoringPos {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine();
            String s1[] = bufferedReader.readLine().split(" ");
            int[] kp = new int[8];
            for (int i = 0; i < 8; i++) {
                kp[i] = Integer.parseInt(s1[i]);
            }
            long max = 0;
            for (int i = 0; i <= s.length() - 8; i++) {
                long calc = 0;
                int DC = 0, TC = 0;
                for (int j = i; j < i + 8; j++) {
                    char c = s.charAt(i + (j - i));
                    if (c == 'D') {
                        DC++;
                        calc += kp[j-i];
                    } else if (c == 'T') {
                        TC++;
                        calc += kp[j-i];
                    } else if (c == 'd') {
                        calc += (kp[j-i] * 2);
                    } else if (c == 't') {
                        calc += (kp[j-i] * 3);
                    } else {
                        calc += kp[j-i];
                    }
                }

                for (int i1 = 0; i1 < TC; i1++) {
                    calc *= 3;
                }for (int i1 = 0; i1 < DC; i1++) {
                    calc *= 2;
                }
                if (calc > max) {
                    max = calc;
                }
            }
            System.out.println(max);
        }
    }
}
