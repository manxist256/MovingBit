
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProblemC {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static boolean visible(double xA, double yA, double x1, double y1, double x2, double y2) {
        if (xA >= x1 && xA <= x2 && yA >= y1 && yA <= y2) {
            return false;
        }
        return true;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria(); int[] arr2 = rw.ria(); int[] arr3 = rw.ria();
            int x1 = rw.gifs(arr, 0); int y1 = rw.gifs(arr, 1);
            int x2 = rw.gifs(arr, 2); int y2 = rw.gifs(arr, 3);
            int x5 = rw.gifs(arr2, 0); int y5 = rw.gifs(arr2, 1);
            int x6 = rw.gifs(arr2, 2); int y6 = rw.gifs(arr2, 3);
            int x9 = rw.gifs(arr3, 0); int y9 = rw.gifs(arr3, 1);
            int x10 = rw.gifs(arr3, 2); int y10 = rw.gifs(arr3, 3);
            for (double i = x1; i <= x2; i += 0.5) {
                double xaxis = i, yaxis = y2;
                double xaxis1 = i, yaxis1 = y1;
                if ((visible(xaxis, yaxis, x5, y5, x6, y6) && visible(xaxis, yaxis, x9, y9, x10, y10))
                || (visible(xaxis1, yaxis1, x5, y5, x6, y6) && visible(xaxis1, yaxis1, x9, y9, x10, y10))) {
                    rw.println("YES");
                    return;
                }
            }
            for (double i = y1; i <= y2; i += 0.5) {
                double xaxis = x1, yaxis = i;
                double xaxis1 = x2, yaxis1 = i;
                if ((visible(xaxis, yaxis, x5, y5, x6, y6) && visible(xaxis, yaxis, x9, y9, x10, y10))
                || (visible(xaxis1, yaxis1, x5, y5, x6, y6) && visible(xaxis1, yaxis1, x9, y9, x10, y10))) {
                    rw.println("YES");
                    return;
                }
            }
            rw.println("NO");
        }
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
