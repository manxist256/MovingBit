package CodeChef.Lunchtime.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProblemBDivB {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int ints[] = rw.ria();
            int N = rw.gifs(ints, 0);
            int K = rw.gifs(ints, 1);
            String s = rw.rs();
            int[] leftP = new int[N];
            int[] rightP = new int[N];
            int contig = 0;
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - 48;
                if (curr == 1) {
                    contig++;
                } else {
                    contig = 0;
                }
                leftP[i] = contig;
            }
            contig = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curr = s.charAt(i) - 48;
                if (curr == 1) {
                    contig++;
                } else {
                    contig = 0;
                }
                rightP[i] = contig;
            }
            int max = 0;
            for (int i = 0; i <= (N - K); i++) {
                int tk = K;
                if (i != 0) {
                    tk += leftP[i - 1];
                }
                int rightW = i + K;
                if (rightW < N) {
                    tk += rightP[rightW];
                }
                if (tk > max) {
                    max = tk;
                }
            }
            rw.println(max);
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
