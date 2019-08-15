package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dilemma {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String sc = bufferedReader.readLine();
            int no1 = 0;
            for (int i = 0; i < sc.length(); i++) {
                if (sc.charAt(i) - 49 == 0) {
                    no1++;
                }
            }
            if (no1 % 2 == 0) {
                System.out.println("LOSE");
            } else {
                System.out.println("WIN");
            }
        }
    }
}
