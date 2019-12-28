package CodeChef.LongChallenge.December2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class CHFRAN {

    static class Range {
        int L;
        int R;
        public Range(int L, int R) {
            this.L = L;
            this.R = R;
        }
    }

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            ArrayList<Range> ranges = new ArrayList<>();
            int maxS = 0;
            HashMap<Integer, Integer> start = new HashMap<>();
            HashMap<Integer, Integer> end = new HashMap<>();
            for (int i = 0; i < N; i++) {
                int[] range = rw.ria();
                int L = rw.gifs(range, 0);
                int R = rw.gifs(range, 1);
                ranges.add(new Range(L, R));
                if (L > maxS) {
                    maxS = L;
                }
                if (!start.containsKey(L)) {
                    start.put(L, 0);
                }
                if (!end.containsKey(R)) {
                    end.put(R, 0);
                }
                int eL = start.get(L);
                start.put(L, ++eL);
                int eR = end.get(R);
                end.put(R, ++eR);
            }
            TreeSet<Integer> combined = new TreeSet<>();
            combined.addAll(start.keySet());
            combined.addAll(end.keySet());
            int minDeletion = Integer.MAX_VALUE;
            int tot = 0;
            for (Integer integer : combined) {
                if (end.containsKey(integer)) {
                    tot -= end.get(integer);
                }
                if (start.containsKey(integer)) {
                    tot += start.get(integer);
                }
                if (end.containsKey(integer) && integer < maxS && tot < minDeletion) {
                    minDeletion = tot;
                }
            }

            rw.println(minDeletion == Integer.MAX_VALUE ? -1 : minDeletion);
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
