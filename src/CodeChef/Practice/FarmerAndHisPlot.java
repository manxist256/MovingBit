package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FarmerAndHisPlot {

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
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            Set<Long> factorsN = factors(N);
            Set<Long> factorsM = factors(M);
            long gcd = getGCD(factorsN, factorsM);
            System.out.println((N/gcd) * (M/gcd));
        }
    }
}
