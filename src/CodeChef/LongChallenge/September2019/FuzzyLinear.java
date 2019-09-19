package CodeChef.LongChallenge.September2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FuzzyLinear {

    static long getGCD(long a, long b) {
        if (b == 0) return a;
        else return getGCD(b,a % b);
    }

    private static int find2PowN(int N) {
        int i = 0;
        while (true) {
            if (N <= Math.pow(2, i++)) {
                break;
            }
        }
        return (int)Math.pow(2, i - 1);
    }

    private static void constructSegmentTree(long[] input, long[] segmentTree) {
        constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);
    }

    private static long constructSegmentTree(long[] input, long[] segmentTree, int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = input[low];
            return input[low];
        }
        int mid = (low + high) / 2;
        long l = constructSegmentTree(input, segmentTree, low, mid, 2 * pos + 1);
        long r = constructSegmentTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
        long gcd = getGCD(l, r);
        return segmentTree[pos] = gcd;
    }

    private static long rangedQuery(long[] segmentTree, int low, int high, int pos, long K) {
        if (K % segmentTree[pos] != 0) {
            return 0;
        }
        if (low == high) {
            if (K % segmentTree[pos] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        int mid = (low + high) / 2;
        long l = rangedQuery(segmentTree, low, mid, 2 * pos + 1, K);
        long r = rangedQuery(segmentTree, mid + 1, high, 2 * pos + 2, K);
        long sum, n;
        long k1 = (mid - low) + 1;
        long k2 = (high - (mid + 1)) + 1;
        long b1 = (k1 * (k1 + 1))/2;
        long b2 = (k2 * (k2 + 1))/2;

        if (l != b1 && r != b2) {
            sum = l + r;
            if (K % segmentTree[pos] == 0) {
                sum += (k1 * k2);
            }
            return sum;
        }
        else if (l == b1 && r == b2) {
            n = (high - low) + 1;
            return (n*(n+1))/2;
        } else if (l == b1) {
            sum = b1 + (k1 * k2) + r;
        } else {
            sum = b2 + (k2 * k1) + l;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        long[] input = new long[N];
        for (int i = 0; i < N; i++) {
            input[i] = Long.parseLong(strings[i]);
        }
        long[] segmentTree = new long[find2PowN(strings.length) * 2 - 1];
        constructSegmentTree(input, segmentTree);
        int Q = Integer.parseInt(bufferedReader.readLine());
        while (Q-- > 0) {
            int K = Integer.parseInt(bufferedReader.readLine());
            printWriter.println(rangedQuery(segmentTree, 0, N - 1, 0, K));
        }
        printWriter.flush();
    }
}
