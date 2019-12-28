package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class PhysicalExercise {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static class Pair {
        double distance;
        int X;
        int Y;
        public Pair(double distance, int X, int Y) {
            this.distance = distance;
            this.X = X;
            this.Y = Y;
        }
    }

    private static double find(int X, int Y, int[] AP, int[] BP, int[] CP) {
        ArrayList<Pair> BC = new ArrayList<>();
        for (int i = 0; i < BP.length; i += 2) {
            int Bx = BP[i], By = BP[i+1];
            double minimum = Double.MAX_VALUE;
            for (int j = 0; j < CP.length; j += 2) {
                int Cx = CP[j], Cy = CP[j+1];
                double distance = Math.sqrt((Math.pow(Bx-Cx, 2) + (Math.pow(By-Cy, 2))));
                if (distance < minimum) {
                    minimum = distance;
                }
            }
            BC.add(new Pair(minimum, Bx, By));
        }
        ArrayList<Pair> ABC = new ArrayList<>();
        for (int i = 0; i < AP.length; i += 2) {
            int Ax = AP[i], Ay = AP[i+1];
            double minimum = Double.MAX_VALUE;
            for (Pair pair : BC) {
                int Bx = pair.X, By = pair.Y;
                double distance = Math.sqrt((Math.pow(Bx-Ax, 2) + (Math.pow(By-Ay, 2))));
                double otherDistance = pair.distance;
                double total = distance + otherDistance;
                if (total < minimum) {
                    minimum = total;
                }
            }
            ABC.add(new Pair(minimum, Ax, Ay));
        }
        double minimum = Double.MAX_VALUE;
        for (Pair pair : ABC) {
            int Ax = pair.X, Ay = pair.Y;
            double distance = Math.sqrt((Math.pow(X-Ax, 2) + (Math.pow(Y-Ay, 2))));
            double otherDistance = pair.distance;
            double total = distance + otherDistance;
            if (total < minimum) {
                minimum = total;
            }
        }
        return minimum;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] xy = rw.ria();
            int X = rw.gifs(xy, 0);
            int Y = rw.gifs(xy, 1);
            int[] input = rw.ria();
            int A = rw.gifs(input, 0);
            int B = rw.gifs(input, 1);
            int C = rw.gifs(input, 2);
            int[] APoints = rw.ria();
            int[] BPoints = rw.ria();
            int[] CPoints = rw.ria();
            rw.println(Math.min(find(X, Y, APoints, BPoints, CPoints),
                    find(X, Y, BPoints, APoints, CPoints)));
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

        protected void println(double d) {
            printWriter.println(d);
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
