//package CodeChef.LongChallenge.August2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class DistributeApples {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            long N = Long.parseLong(input[0]), K = Long.parseLong(input[1]);
            long numberOfIterations = N / K;
            System.out.println(numberOfIterations % K == 0 ? "NO" : "YES");
        }
    }
}
