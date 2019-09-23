package Codeforces2.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class MultiplicationTable {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static int[] getFactors(int X) {
        int sq = (int)Math.sqrt(X) + 1;
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 1; i <= sq; i++) {
            if (X % i == 0) {
                treeSet.add(i);
                treeSet.add(X/i);
            }
        }
        int[] arr = new int[treeSet.size()];
        int k = 0;
        for (Integer integer : treeSet) {
            arr[k++] = integer;
        }
        Arrays.sort(arr);
        return arr;
    }

    private static int getAns(int N, int X) {
        int[] factors = getFactors(X);
        int t = factors.length % 2 != 0 ? (factors.length / 2) + 1 : factors.length / 2;
        int ln = factors.length - 1;
        int ans = 0;
        for (int i = 0; i < t; i++) {
            if (factors[ln] <= N) {
                ans += 2;
            }
            ln--;
        }
        return factors.length % 2 != 0 ? ans - 1 : ans;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] array = rw.ria();
            int N = rw.gifs(array, 0);
            int X = rw.gifs(array, 1);
            int ans = getAns(N, X);
            rw.println(ans > 0 ? ans : 0);
        }
    }

    public static void main(String[] args) throws Exception {
        solve(false);
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
