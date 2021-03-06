package CodeChef.Lunchtime.December2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ProblemB {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static ArrayList<Long> getFactors(long N) {
        long sqrt = (long)Math.sqrt(N) + 1;
        ArrayList<Long> factors = new ArrayList<>();
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                factors.add((long)i);
                if (i == N / i) {
                    continue;
                }
                factors.add(N / i);
            }
        }
        return factors;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            long[] arr = rw.rla();
            long A = arr[0];
            long M = arr[1];
            ArrayList<Long> factorsOfM = getFactors(M);
            ArrayList<Long> finalAnswer = new ArrayList<>();
            for (Long l : factorsOfM) {
                if ((l - 1) % A == 0) {
                    long x = (l-1)/A;
                    long d = M / (A*x  + 1);
                    finalAnswer.add(d*x);
                }
            }
            Collections.sort(finalAnswer);
            if (finalAnswer.contains(0l))
                finalAnswer.remove(0l);
            rw.println(finalAnswer.size());
            for (Long l : finalAnswer) {
                rw.print(l);
            }
            rw.println("");
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

        protected void print(int i) {
            printWriter.print(i + " ");
        }

        protected void print(long l) {
            printWriter.print(l + " ");
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
