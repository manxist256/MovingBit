//source : https://www.geeksforgeeks.org/compute-ncr-p-set-3-using-fermat-little-theorem/
//package CodeChef.LongChallenge.December2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

class BinaryXOR {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();
    static long mod = 1000000007;

    private static int count(String s, int matcher) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 48 == matcher) {
                count++;
            }
        }
        return count;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        long[] factorial = fact();
        while (T-- > 0) {
            int N = rw.ri();
            String A = rw.rs();
            String B = rw.rs();
            int az = count(A, 0), ao = count(A, 1);
            int bz = count(B, 0), bo = count(B, 1);

            int cO = Math.min(ao, bo), cZ = Math.min(az, bz);
            int maxZ = cO + cZ, minO = N - maxZ;

            int traverse = Math.min(cO, cZ);

            long num = factorial[N];

            long ans = 0;

            for (int i = 0; i <= traverse; i++) {
                long den = factorial[maxZ] * factorial[minO];
                ans = ((ans % mod) + (divide(num, den) % mod)) % mod;
                maxZ -= 2; minO += 2;
            }
            rw.println(ans);
        }
    }

    private static long[] fact() {
        long fact []= new long[100001];
        fact[0] = 1;

        for (int i = 1; i <= 100000; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }

        return fact;
    }

    //source : https://www.geeksforgeeks.org/compute-ncr-p-set-3-using-fermat-little-theorem/
    private static long divide(long numerator, long denominator) {
        denominator = fermat(denominator)%mod;
        return (numerator*denominator) % mod;
    }

    private static long pow(long x, long y,long p) {
        long res = 1;

        x = x % p;

        while (y > 0)
        {

            if (y % 2 == 1)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }

    private static long fermat(long n) {
        return pow(n,mod - 2, mod);
    }

    public static void main(String[] args) throws Exception {
        solve(true);
        rw.flush();
    }

    static class Helpers {

        static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
        }

        static <T> HashMap<T, Integer> freqMap(T[] array) {
            HashMap<T, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[i])) {
                    map.put(array[i], 0);
                }
                int ev = map.get(array[i]);
                map.put(array[i], ++ev);
            }
            return map;
        }

    }

    static class ReaderWriter {
        static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter printWriter = new PrintWriter(System.out);

        protected void flush() throws Exception {
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
        }

        protected void println(String s) {
            printWriter.println(s);
        }

        protected void println(int i) {
            printWriter.println(i);
        }

        protected void println(long l) {
            printWriter.println(l);
        }

        int ri() throws Exception {
            return Integer.parseInt(bufferedReader.readLine());
        }

        long rl() throws Exception {
            return Long.parseLong(bufferedReader.readLine());
        }

        String rs() throws Exception {
            return bufferedReader.readLine();
        }

        double rd() throws Exception {
            return Double.parseDouble(bufferedReader.readLine());
        }

        int[] ria() throws Exception {
            String[] line = rs().split(" ");
            int[] arr = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            return arr;
        }

        long[] rla() throws Exception {
            String[] line = rs().split(" ");
            long[] arr = new long[line.length];
            for (int i = 0; i < line.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            return arr;
        }

        int gifs(int[] line, int index) {
            return line[index];
        }

        long glfs(long[] line, int index) {
            return line[index];
        }

        void pia(int[] array) {
            for (int i = 0; i < array.length; i++) {
                printWriter.print(array[i] + " ");
            }
            printWriter.println();
        }

        void pla(long[] array) {
            for (int i = 0; i < array.length; i++) {
                printWriter.print(array[i] + " ");
            }
            printWriter.println();
        }
    }
}
