package CodeChef.LongChallenge.July2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefAndMean {

    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        while (N-- > 0) {
            int K = Integer.parseInt(bufferedReader.readLine());
            String[] s = bufferedReader.readLine().split(" ");
            long total = 0;
            Integer[] integers = new Integer[s.length];
            for (int i = 0; i < s.length; i++) {
                integers[i] = Integer.parseInt(s[i]);
                total += integers[i];
            }
            double mean = (double)total / integers.length;
            long smallest = Long.MAX_VALUE;
            int ans = 0;
            for (int i = 0; i < integers.length; i++) {
                if (((total - integers[i]) / ((double)integers.length - 1)) == mean) {
                    if (integers[i] < smallest) {
                        smallest = integers[i];
                        ans = i + 1;
                    }
                }
            }
            if (smallest == Long.MAX_VALUE) {
                System.out.println("Impossible");
            } else {
                System.out.println(ans);
            }
        }
    }

}
