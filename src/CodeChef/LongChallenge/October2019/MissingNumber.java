package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MissingNumber {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static long get(int b, String Y) {
        long max = 1000000000000L;
        long total = 0;
        for (int j = 0; j < Y.length(); j++) {
            int pk = Y.length() - j - 1;
            long pow = (long)Math.pow(b, pk);
            if (pow > max || pow < 0) {
                return -2;
            }
            int gp;
            if (Y.charAt(j) >= 48 && Y.charAt(j) <= 57) {
                gp = Y.charAt(j) - 48;
            } else {
                gp = Y.charAt(j) - 65 + 10;
            }
            long g = (pow * gp);
            total += g;
            if (total > max || total < 0 || g > max || g < 0) {
                return -2;
            }
        }
        return total;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        outer : while (T-- > 0) {
            int N = rw.ri();
            int[] b = new int[N];
            String[] y = new String[N];
            for (int i = 0; i < N; i++) {
                String[] line = rw.rs().split(" ");
                b[i] = Integer.parseInt(line[0].trim());
                y[i] = line[1].trim();
            }
            boolean xyz = false;
            long total = 0;
            for (int i = 0; i < N; i++) {
                if (b[i] != -1) {
                    total = get(b[i], y[i]);
                    if (total == -2) {
                        rw.println(-1);
                        continue outer;
                    }
                    xyz = true;
                    break;
                }
            }
            if (xyz) {
                inner:
                for (int i = 0; i < N; i++) {
                    long m;
                    if (b[i] == -1) {
                        for (int B = max(y[i]); B <= 36; B++) {
                            m = get(B, y[i]);
                            if (m == -2 || total != m) {
                                continue;
                            }
                            continue inner;
                        }
                        rw.println(-1);
                        continue outer;
                    } else {
                        m = get(b[i], y[i]);
                        if (m == -2 || total != m) {
                            rw.println(-1);
                            continue outer;
                        }
                    }
                }
                rw.println(total);
            } else {
                HashMap<Long, Integer> map = new HashMap<>();
                for (int i = 0; i < N; i++) {
                    long m;
                    HashSet<Long> set = new HashSet<>();
                    for (int B = max(y[i]); B <= 36; B++) {
                        m = get(B, y[i]);
                        if (m == -2) {
                            continue;
                        }
                        if (set.contains(m)) {
                            continue;
                        }
                        if (!map.containsKey(m)) {
                            map.put(m, 0);
                        }
                        set.add(m);
                        int ev = map.get(m);
                        map.put(m,++ev);
                    }
                }
                long min = Long.MAX_VALUE;
                for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == N) {
                        if (entry.getKey() < min) {
                            min = entry.getKey();
                        }
                    }
                }
                rw.println(min == Long.MAX_VALUE ? -1 : min);
            }
        }
    }

    private static int max(String Y) {
        int max = 0;
        for (int j = 0; j < Y.length(); j++) {
            int gp;
            if (Y.charAt(j) >= 48 && Y.charAt(j) <= 57) {
                gp = Y.charAt(j) - 48;
            } else {
                gp = Y.charAt(j) - 65 + 10;
            }
            if (gp > max) {
                max = gp;
            }
        }
        return max + 1;
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
