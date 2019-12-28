package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class HardSequence {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        int[] arr = new int[130];
        arr[0] = 0;
        HashMap<Integer, Integer[]> lastSeens = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        Integer[] integer = {-1, 0};
        count.put(0, 1);
        lastSeens.put(0, integer);
        for (int i = 1; i < 130; i++) {
            int l = arr[i - 1];
            if (count.containsKey(l) && count.get(l) == 1) {
                arr[i] = 0;
                int ev = count.get(0); count.put(0, ++ev);
                Integer[] ls = lastSeens.get(0);
                ls[0] = ls[1];
                ls[1] = i;
            } else {
                Integer[] ls = lastSeens.get(l);
                int diff = ls[1] - ls[0];
                arr[i] = diff;
                if (!count.containsKey(diff)) {
                    count.put(diff, 0);
                }
                int ev = count.get(diff);
                count.put(diff, ++ev);
                if (!lastSeens.containsKey(diff)) {
                    Integer[] rx = {-1, i};
                    lastSeens.put(diff, rx);
                } else {
                    Integer[] array = lastSeens.get(diff);
                    array[0] = array[1];
                    array[1] = i;
                }
            }
        }
        while (T-- > 0) {
            int N = rw.ri();
            int value = arr[N - 1];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (value == arr[i]) {
                    cnt++;
                }
            }
            rw.println(cnt);
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
