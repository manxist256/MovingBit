package CodeChef.CypherNovember;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

//10 10
//1 2
//1 3
//1 4
//9 10
//5 6
//7 8
//5 7
//2 5
//3 7
//5 8

public class CaseyAndGifts {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] ints = rw.ria();
            int N = rw.gifs(ints, 0);
            int M = rw.gifs(ints, 1);
            HashSet<HashSet<Integer>> sets = new HashSet<>();
            for (int i = 1; i <= N; i++) {
                HashSet<Integer> dj = new HashSet<>();
                dj.add(i);
                sets.add(dj);
            }
            for (int i = 0; i < M; i++) {
                int[] edge = rw.ria();
                int e1 = rw.gifs(edge, 0);
                int e2 = rw.gifs(edge, 1);
                HashSet<Integer> s1 = find(e1, sets);
                HashSet<Integer> s2 = find(e2, sets);
                if (s1 == s2) {
                    continue;
                }
                merge(s1, s2, sets);
            }
            int c = 0;
            for (HashSet<Integer> set : sets) {
                if (set.size() > 0) {
                    c++;
                }
            }
            rw.println(c);
        }
    }

    private static HashSet<Integer> find(int vertex, HashSet<HashSet<Integer>> sets) {
        for (HashSet<Integer> set : sets) {
            if (set.contains(vertex)) {
                return set;
            }
        }
        return null;
    }

    private static void merge(HashSet<Integer> s1, HashSet<Integer> s2, HashSet<HashSet<Integer>> sets) {
        s1.addAll(s2);
        s2.clear();
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
