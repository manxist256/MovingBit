//package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

class ChefAndMaxStarValue {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static HashMap<Integer, HashSet<Integer>> sieve() {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int sqrt = (int)Math.sqrt(1000001) + 1;
        for (int i = 1; i <= sqrt; i++) {
            for (int j = i; j <= 1000000; j += i) {
                if (!map.containsKey(j)) {
                    map.put(j, new HashSet<>());
                }
                HashSet<Integer> arrayList = map.get(j);
                arrayList.add(i);
            }
        }
        return map;
    }

    private static HashSet<Integer> getFactors(int n) {
        HashSet<Integer> factors = new HashSet<>();
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n/i);
            }
        }
        return factors;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        //HashMap<Integer, HashSet<Integer>> sieved = sieve();
        while (T-- > 0) {
            int N = rw.ri();
            int[] ai = rw.ria();
            int max = 0;
            HashMap<Integer, Integer> counter = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (counter.containsKey(ai[i])) {
                    if (counter.get(ai[i]) > max) {
                        max = counter.get(ai[i]);
                    }
                }
                HashSet<Integer> gset = getFactors(ai[i]);
                for (Integer integer : gset) {
                    if (!counter.containsKey(integer)) {
                        counter.put(integer, 0);
                    }
                    int ev = counter.get(integer);
                    counter.put(integer, ++ev);
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
