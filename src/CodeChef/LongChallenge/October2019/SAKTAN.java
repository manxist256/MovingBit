package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SAKTAN {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria();
            int N = rw.gifs(arr, 0);
            int M = rw.gifs(arr, 1);
            int Q = rw.gifs(arr, 2);
            Map<Integer, Integer> rows = new HashMap<>(), columns = new HashMap<>();
            for (int i = 0; i < Q; i++) {
                int[] rc = rw.ria();
                int R = rw.gifs(rc, 0);
                int C = rw.gifs(rc, 1);
                if (!rows.containsKey(R)) {
                    rows.put(R, 0);
                }
                if (!columns.containsKey(C)) {
                    columns.put(C, 0);
                }
                int rev = rows.get(R);
                int cev = columns.get(C);
                rows.put(R, ++rev); columns.put(C, ++cev);
            }
            int evenColumns = M, oddColumns = 0;
            for (Map.Entry<Integer, Integer> entry : columns.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    evenColumns--;
                    oddColumns++;
                }
            }
            long odd = 0;
            for (int i = 1; i <= N; i++) {
                if (!rows.containsKey(i) || rows.get(i) % 2 == 0) { //row shades even
                    odd += oddColumns;
                } else { //row shades odd
                    odd += evenColumns;
                }
            }
            rw.println(odd);
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
