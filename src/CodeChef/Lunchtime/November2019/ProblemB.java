package CodeChef.Lunchtime.November2019;

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
            int[] ints = rw.ria();
            int N = rw.gifs(ints, 0);
            int M = rw.gifs(ints, 1);
            int[][] twoD = new int[N][M];
            for (int i = 0; i < N; i++) {
                twoD[i] = rw.ria();
            }
            int[] ia = new int[N*M];
            int[] ja = new int[N*M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int value = twoD[i][j];
                    ia[value - 1] = i;
                    ja[value - 1] = j;
                }
                Arrays.fill(twoD[i], -1);
            }
            for (int i = 0; i < N*M; i++) {
                int iaxis = ia[i];
                int jaxis = ja[i];
                twoD[iaxis][jaxis] = 1;
                if (iaxis+1 < N && jaxis+1 < M) {
                    twoD[iaxis+1][jaxis+1] = 7;
                }
                if (iaxis+1 < N) {
                    twoD[iaxis+1][jaxis] = 7;
                }
                if (iaxis+1 < N && jaxis-1 >= 0) {
                    twoD[iaxis+1][jaxis-1] = 7;
                }
                resolve(twoD, N, M);
            }
            for (int i = 0; i < N; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < M; j++) {
                    if (twoD[i][j] == 7 || twoD[i][j] == 0) {
                        stringBuilder.append(0);
                    } else if (twoD[i][j] == 1) {
                        stringBuilder.append(1);
                    }
                }
                rw.println(stringBuilder.toString());
            }
        }
    }

    private static void resolve(int[][] twoD, int N, int M) {
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                int value = twoD[i][j];
                if (value != 7) {
                    continue;
                } else {
                    twoD[i][j] = 0;
                    if (i+1 < N && j+1 < M) {
                        twoD[i+1][j+1] = 7;
                    }
                    if (i+1 < N) {
                        twoD[i+1][j] = 7;
                    }
                    if (i+1 < N && j-1 >= 0) {
                        twoD[i+1][j-1] = 7;
                    }
                }
            }
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
