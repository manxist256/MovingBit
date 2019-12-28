package CodeChef.Dcode2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

public class ProblemB {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria();
            int N = rw.gifs(arr, 0);
            int M = rw.gifs(arr, 1);
            int[] XYS = rw.ria();
            int X = rw.gifs(XYS, 0);
            int Y = rw.gifs(XYS, 1);
            int S = rw.gifs(XYS, 2);
            int[] Xs = null;
            if (X > 0) {
                Xs = rw.ria();
                Arrays.sort(Xs);
            }
            int[] Ys = null;
            if (Y > 0) {
                Ys = rw.ria();
                Arrays.sort(Ys);
            }
            int sum = 0;
            int last = 1;
            for (int i = 0; i < Y; i++) {
                int dx = (Ys[i] - last);
                sum += (dx / S);
                last = Ys[i] + 1;
            }
            //sum += ((M - last) + 1);
            int diff = (M - last + 1);
            sum += (diff / S);
            int ans = 0;
            int last2 = 1;
            for (int i = 0; i < X; i++) {
                int dy = (Xs[i] - last2);
                int p = dy / S;
                ans += (p*sum);
                last2 = Xs[i] + 1;
            }
            int diff2 = (N - last2 + 1);
            int p = diff2 / S;
            ans += (p * sum);
            //ans += (((N - last2) + 1)*sum);
            rw.println(ans);
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
