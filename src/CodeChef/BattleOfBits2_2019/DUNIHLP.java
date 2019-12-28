// source : https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/
package CodeChef.BattleOfBits2_2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class DUNIHLP {

    // source : https://www.geeksforgeeks.org/primality-test-set-3-miller-rabin/

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static long power(long x, long y, long p) {
        long res = 1;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = (x * x) % p;
        }

        return res;
    }

    static boolean miillerTest(long d, long n) {

        long a = 2 + ((long)Math.random() % (n - 4));

        long x = power(a, d, n);

        if (x == 1 || x == n - 1)
            return true;
        while (d != n - 1) {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }

        return false;
    }

    static boolean isPrime(long n, long k) {
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        long d = n - 1;

        while (d % 2 == 0)
            d /= 2;
        for (int i = 0; i < k; i++)
            if (!miillerTest(d, n))
                return false;

        return true;
    }

    private static long binaryToDecimal(String b) {
        long result = 0;
        int i = 0;
        for (int j = b.length() - 1; j >= 0; j--) {
            result += ((long)(b.charAt(j) - 48) * (long)Math.pow(2, i++));
        }
        return result;
    }
    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            String s = rw.rs();
            int c = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    c++;
                }
            }
            long num = binaryToDecimal(s);
            rw.println(c + " " + (isPrime(num, 4) ? "Lucky day" : "Unucky day"));
        }
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
