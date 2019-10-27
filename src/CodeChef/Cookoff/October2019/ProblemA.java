package CodeChef.Cookoff.October2019;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProblemA {

    static long[] two = new long[64];

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static long getTwoPow(long L) {
        for (int i = 0; i < 64; i++) {
            long j = two[i];
            long j1 = two[i+1];
            if (L >= j && L < j1) {
                return i+1;
            }
        }
        return -1;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            long[] range = rw.rla();
            long L = rw.glfs(range, 0);
            long R = rw.glfs(range, 1);
            if (L == R) {
                rw.println(L|R); continue;
            }
            long twoPow_L = getTwoPow(L);
            long twoPow_R = getTwoPow(R);
            if (twoPow_L != twoPow_R) {
                rw.println(two[(int)twoPow_R] - 1);
            } else {
                String binaryL = Long.toBinaryString(L);
                String binaryR = Long.toBinaryString(R);
                int Length = binaryL.length();
                int k = 0;
                while (k <= Length) {
                    if (binaryL.charAt(k) != binaryR.charAt(k)) {
                        break;
                    }
                    k++;
                }
                int bk = Length - k;
                rw.println(R|(two[bk]-1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 64; i++) {
            two[i] = (long)Math.pow(2, i);
        }
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
                arr[i] = Long.parseLong(line[i]);
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
