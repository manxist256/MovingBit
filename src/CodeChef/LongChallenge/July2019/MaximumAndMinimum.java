package CodeChef.LongChallenge.July2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class MaximumAndMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            BigInteger N = new BigInteger(bufferedReader.readLine()); //people
            BigInteger K = new BigInteger(bufferedReader.readLine()); //choco
            BigInteger tx = K.divide(N);
            BigInteger rem = K.subtract(tx.multiply(N));
            BigInteger t1 = rem, t2 = N.subtract(rem);
            if (t1.equals(t2)) {
                System.out.println(t1.add(t2.subtract(BigInteger.ONE)));
            } else if (!t1.equals(t2) && N.equals(BigInteger.valueOf(2))) {
                System.out.println(0);
            } else if (t1.equals(BigInteger.ZERO) ^ t2 .equals(BigInteger.ZERO)) {
                System.out.println(0);
            } else {
                BigInteger min = t1.min(t2);
                System.out.println(min.multiply(BigInteger.valueOf(2)));
            }
        }
    }
}
