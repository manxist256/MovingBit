package CodeChef.LongChallenge.December2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class STICNOT {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            int[] edgeWeights = new int[N-1];
            for (int i = 0; i < N - 1; i++) {
                int[] edge = rw.ria();
                edgeWeights[i] = rw.gifs(edge, 2);
            }
            int[] verticeWeights = rw.ria();
            Arrays.sort(edgeWeights);
            Arrays.sort(verticeWeights);
            rw.println(getAns(verticeWeights, edgeWeights, N));
        }
    }

    private static int getAns(int[] verticeWeights, int[] edgeWeights, int N) {
        int ans = 0;
        int verticeTracker = 0;
        for (int i = 0; i < N - 1; i++) {
            int edgeWt = edgeWeights[i];
            boolean y = false;
            for (int j = verticeTracker; j < verticeWeights.length; j++) {
                verticeTracker = j;
                if (edgeWt <= verticeWeights[j]) {
                    y = true;
                    break;
                }
            }
            verticeTracker++;
            if (verticeTracker == N) {
                ans = ((N-1) - i);
                if (!y) {
                    ans++;
                }
                break;
            }
        }
        return ans;
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
//1
//10
//1 2 4
//1 3 6
//2 4 10
//2 5 23
//3 6 40
//3 7 41
//3 8 49
//4 9 52
//4 10 59
//1 7 11 15 21 30 45 63 90 128
