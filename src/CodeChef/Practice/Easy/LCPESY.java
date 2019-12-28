package CodeChef.Practice.Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LCPESY {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            String Manikandan = rw.rs();
            String Vaishnavi = rw.rs();
            HashMap<Character, Integer> map1 = new HashMap<>();
            HashMap<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < Manikandan.length(); i++) {
                char c = Manikandan.charAt(i);
                if (!map1.containsKey(c)) {
                    map1.put(c, 0);
                }
                int ev = map1.get(c);
                map1.put(c, ++ev);
            }
            for (int i = 0; i < Vaishnavi.length(); i++) {
                char c = Vaishnavi.charAt(i);
                if (!map2.containsKey(c)) {
                    map2.put(c, 0);
                }
                int ev = map2.get(c);
                map2.put(c, ++ev);
            }
            int weds = 0;
            for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (!map2.containsKey(key)) {
                    continue;
                }
                int map2V = map2.get(key);
                weds += Math.min(value, map2V);
            }
            rw.println(weds);
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
