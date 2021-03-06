package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class EvenEdges {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] input = rw.ria();
            int N = rw.gifs(input, 0);
            int M = rw.gifs(input, 1);
            int su = -1, sv = -1;
            HashMap<Integer, Integer> degree = new HashMap<>();
            for (int i = 0; i < M; i++) {
                int[] edge = rw.ria();
                int u = rw.gifs(edge, 0);
                int v = rw.gifs(edge, 1);
                if (su == -1 && sv == -1) {
                    su = u; sv = v;
                }
                if (!degree.containsKey(u)) {
                    degree.put(u, 0);
                }
                if (!degree.containsKey(v)) {
                    degree.put(v, 0);
                }
                int eu = degree.get(u);
                degree.put(u, ++eu);
                int ev = degree.get(v);
                degree.put(v, ++ev);
            }
            if (M % 2 == 0) {
                rw.println(1);
                for (int i = 1; i <= N; i++) {
                    rw.printWriter.print(1 + " ");
                }
            } else {
                boolean allEven = true;
                for (Map.Entry<Integer, Integer> entry : degree.entrySet()) {
                    if (entry.getValue() % 2 != 0) {
                        allEven = false;
                        break;
                    }
                }
                if (allEven) {
                    rw.println(3);
                    for (int i = 1; i <= N; i++) {
                        if (su == i) {
                            rw.printWriter.print(1 + " ");
                        } else if (sv == i) {
                            rw.printWriter.print(2 + " ");
                        } else {
                            rw.printWriter.print(3 + " ");
                        }
                    }
                }
                else {
                    rw.println(2);
                    boolean s = false;
                    for (int i = 1; i <= N; i++) {
                        if (degree.containsKey(i) && degree.get(i) % 2 != 0 && !s) {
                            rw.printWriter.print(2 + " ");
                            s = true;
                            continue;
                        }
                        rw.printWriter.print(1 + " ");
                    }
                }
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
