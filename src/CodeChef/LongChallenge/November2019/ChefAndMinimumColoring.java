package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ChefAndMinimumColoring {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static class Box {
        int color;
        int value;
        public Box(int color, int value) {
            this.color = color;
            this.value = value;
        }
    }

    private static boolean fulfilled(HashMap<Integer, Integer> colorTracker, int M) {
        return colorTracker.size() >= M;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria();
            int N = rw.gifs(arr, 0);
            int M = rw.gifs(arr, 1);
            int[] balls = rw.ria();
            int k = 0;
            ArrayList<Box> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Box(k++, balls[i]));
                if (k == M) {
                    k = 0;
                }
            }
            ArrayList<Box> sorted = list.stream().sorted((box1, box2) -> { if (box1.value < box2.value) { return -1; } else {
                return +1; } }).collect(Collectors.toCollection(ArrayList::new));
            HashMap<Integer, Integer> colorTracker = new HashMap<>();
            int l = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < sorted.size(); i++) {
                Box box = sorted.get(i);
                int color = box.color;
                if (!colorTracker.containsKey(color)) {
                    colorTracker.put(color, 0);
                }
                int ev = colorTracker.get(color);
                colorTracker.put(color, ++ev);
                boolean fulfilled = fulfilled(colorTracker, M);
                if (fulfilled) {
                    for (int j = l; j < i; j++) {
                        Box innerBox = sorted.get(j);
                        int innerColor = innerBox.color;
                        int innerEv = colorTracker.get(innerColor);
                        if (innerEv > 1) {
                            colorTracker.put(innerColor,  innerEv - 1);
                        } else {
                            l = j;
                            break;
                        }
                    }
                    Box lBox = sorted.get(l);
                    int diff = box.value - lBox.value;
                    if (diff < min) {
                        min = diff;
                    }
                }
            }
            rw.println(min);
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
