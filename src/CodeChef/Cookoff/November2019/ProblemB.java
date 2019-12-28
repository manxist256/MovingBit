//package CodeChef.Cookoff.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

class ProblemB {

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
                twoD[i] = rw.riamv();
            }
            int[][] currSign = new int[N][M];
            for (int i = 0; i < N; i++) {
                currSign[i] = rw.riamv();
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    builder.append(twoD[i][j]);
                }
            }
            StringBuilder builder1 = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    builder1.append(currSign[i][j]);
                }
            }
            String fg = builder.toString();
            String fg1 = builder1.toString();
            StringBuilder stringBuilder = new StringBuilder();
            int s1 = -1, s2 = -1;
            boolean m = false;
            for (int i = 0; i < fg.length(); i++) {
                char c = fg.charAt(i);
                if (c == '1') {
                    if (!m) {
                        s1 = i;
                    }
                    s2 = i;
                    m = true;
                }
            }
            for (int i = s1; i <= s2; i++) {
                stringBuilder.append(fg.charAt(i));
            }
            String pattern = stringBuilder.toString();
            int length = pattern.length();
            int Min = 1000;
            fg1 = fg1 + fg1;
            for (int i = 0; i < fg1.length() - length; i++) {
                int c = 0, p2 = i;
                for (int j = 0; j < length; j++) {
                    char c1 = pattern.charAt(j);
                    char c2 = fg1.charAt(p2++);
                    if (c1 != c2) {
                        c++;
                    }
                }
                if (c < Min) {
                    Min = c;
                }
            }
            rw.println(Min);
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

        int[] riamv() throws Exception {
            String line = rs();
            int[] arr = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                arr[i] = line.charAt(i)-'0';
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
