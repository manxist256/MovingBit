package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ChefAndHisCake {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria();
            int R = rw.gifs(arr, 0);
            int C = rw.gifs(arr, 1);
            char[][] chars = rw.r2dia(R, C);
            char[][] type1 = new char[R][C];
            char s1 = 'G';
            for (int i = 0; i < R; i++) {
                char s11 = s1;
                for (int j = 0; j < C; j++) {
                    type1[i][j] = s11;
                    s11 = s11 == 'G' ? 'R' : 'G';
                }
                s1 = s1 == 'G' ? 'R' : 'G';
            }
            char s2 = 'R';
            char[][] type2 = new char[R][C];
            for (int i = 0; i < R; i++) {
                char s22 = s2;
                for (int j = 0; j < C; j++) {
                    type2[i][j] = s22;
                    s22 = s22 == 'G' ? 'R' : 'G';
                }
                s2 = s2 == 'G' ? 'R' : 'G';
            }
            int c1 = 0, c2 = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (type1[i][j] != chars[i][j]) {
                        if (type1[i][j] == 'G') {
                            c1 += 5;
                        } else {
                            c1 += 3;
                        }
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (type2[i][j] != chars[i][j]) {
                        if (type2[i][j] == 'G') {
                            c2 += 5;
                        } else {
                            c2 += 3;
                        }
                    }
                }
            }
            rw.println(Math.min(c1,c2));
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

        char[][] r2dia(int R, int C) throws Exception {
            char[][] array = new char[R][C];
            for (int i = 0; i < R; i++) {
                String line = bufferedReader.readLine();
                for (int j = 0; j < C; j++) {
                    array[i][j] = line.charAt(j);
                }
            }
            return array;
        }
    }
}
