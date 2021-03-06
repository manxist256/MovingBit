package CodeChef.EnigmaOLPC2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProbelmC {

    static class G {
        int pos;
        int spos;
        public G(int pos) {
            this.pos = pos;
        }
        boolean placed;
    }

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static boolean found = false;

    static int find(G[] source, long fix, int low, int high) {
        if (found || fix <= source[low].pos) {
            return -1;
        }
        if (low == high) {
            if (source[low].pos < fix) {
                if (!source[low].placed) {
                    return -1;
                }
                found = true;
                return low;
            }
        }
        int mid = (low+high)/2;
        int right = find(source, fix, mid + 1, high);
        int left = find(source, fix, low, mid);
        if (right == -1) {
            return left;
        }
        else {
            return right;
        }
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] input = rw.ria();
            int x = rw.gifs(input, 0);
            int n = rw.gifs(input, 1);
            int[] lights = rw.ria();
            int max = x;
            G[] toS = new G[n+2];
            G[] queries = new G[n];
            for (int i = 1; i <= n; i++) {
                toS[i] = new G(lights[i-1]);
                queries[i-1] = toS[i];
            }
            toS[0] = new G(0);
            toS[0].placed = true;
            toS[toS.length - 1] = new G(x+1);
            Arrays.sort(toS, Comparator.comparing(g -> g.pos));
            toS[0].pos = 0; toS[toS.length - 1].pos = x;
            for (int i = 0; i < toS.length; i++) {
                toS[i].spos = i;
            }
            int[] position = new int[n+2];
            position[0] = 0; position[position.length - 1] = x;
            int[] near = new int[n+2];
            near[0] = x;
            TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            map.put(max, 1);
            for (int i = 0; i < n; i++) {
                found = false;
                G g = queries[i];
                int nearestToPos = find(toS, g.pos, 0, position.length - 1);
                int rangeLeft = position[nearestToPos];
                int rangeRight = near[nearestToPos];
                int newLeft = g.pos - rangeLeft;
                int newRight = rangeRight - g.pos;
                position[g.spos] = g.pos;
                near[nearestToPos] = g.pos;
                near[g.spos] = rangeRight;
                int remove = rangeRight - rangeLeft;
                if (map.get(remove) > 1) {
                    int ev = map.get(remove); map.put(remove, --ev);
                } else {
                    map.remove(remove);
                }
                if (!map.containsKey(newLeft)) {
                    map.put(newLeft, 0);
                }
                if (!map.containsKey(newRight)) {
                    map.put(newRight, 0);
                }
                int ev1 = map.get(newLeft);
                map.put(newLeft, ++ev1);
                int ev2 = map.get(newRight);
                map.put(newRight, ++ev2);
                g.placed = true;
                rw.printWriter.print(map.firstEntry().getKey() + " ");
            }
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
                arr[i] = Long.parseLong(line[i]);
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
//20 17
//8 1 2 3 4 5 6 7 10 11 12 13 14 20 17 19 16
