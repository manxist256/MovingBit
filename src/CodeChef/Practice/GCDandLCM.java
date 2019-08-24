package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GCDandLCM {

    static Set<Long> factors(long number) {
        Set<Long> factors = new HashSet<>();
        long sqrt = (long)(Math.sqrt(number) + 1);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                factors.add((long)i);
                factors.add((long)number / i);
            }
        }
        return factors;
    }

    static long getGCD(Set<Long> factorsA, Set<Long> factorsB) {
        long max = 0;
        for (Long integer : factorsA) {
            if (factorsB.contains(integer) && integer > max) {
                max = integer;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long A = scanner.nextLong(), B = scanner.nextLong();
            Set<Long> factorsA = factors(A);
            Set<Long> factorsB = factors(B);
            long gcd = getGCD(factorsA, factorsB);
            System.out.println(gcd + " " + ((A / gcd) * B));
        }
    }
}
