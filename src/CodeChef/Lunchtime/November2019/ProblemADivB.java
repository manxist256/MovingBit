package CodeChef.Lunchtime.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class ProblemADivB {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static String get(int contig, int s, int e) {
        if (contig >= 3) {
            return s + "..." + e;
        } else if (contig == 2) {
            return s + "," + e;
        } else {
            return String.valueOf(s);
        }
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            int[] arr = rw.ria();
            int contig = 1;
            ArrayList<String> list = new ArrayList<>();
            int e = arr[0], s = arr[0];
            if (N == 1) { rw.println(s); continue; }
            for (int i = 1; i < N; i++) {
                if (arr[i] == e + 1) {
                    e = e + 1;
                    contig++;
                } else {
                    list.add(get(contig, s, e));
                    contig = 1;
                    s = arr[i];
                    e = arr[i];
                }
                if (i == N - 1) {
                    list.add(get(contig, s, e));
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(list.get(i));
                if (i != list.size() - 1) {
                    stringBuilder.append(",");
                }
            }
            rw.println(stringBuilder.toString());
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
