package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LAPD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(strings[0]);
            int B = Integer.parseInt(strings[1]);
            int C = Integer.parseInt(strings[2]);
            long ans = 0;
            for (int i = 1; i <= B; i++) {
                for (int j = 1; j <= A; j++) {
                    for (int k = 1; k <= C; k++) {
                        if (validate(j, i, k)) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }
    private static boolean validate(int A, int B, int C) {
        int x = -1, y = 180;
        for (int i = 0; i < 200; i++) {
            int lhs = ((int)Math.pow(x, 2)*A) + ((int)Math.pow(y, 2)*C) + (2*B*x*y);
            int rhs = (int)Math.pow(x, 2) + (int)Math.pow(y, 2);
            if (!(lhs > rhs)) {
                return false;
            }
            x--;
        }
        int x1 = 180, y1 = -1;
        for (int i = 0; i < 200; i++) {
            int lhs = ((int)Math.pow(x1, 2)*A) + ((int)Math.pow(y1, 2)*C) + (2*B*x1*y1);
            int rhs = (int)Math.pow(x1, 2) + (int)Math.pow(y1, 2);
            if (!(lhs > rhs)) {
                return false;
            }
            y1--;
        }
        return true;
    }
}
