package CodeChef.EnigmaOLPC2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProbelmC {

    static class G {
        long pos;
        long spos;
        public G(long pos) {
            this.pos = pos;
        }
    }

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static boolean found = false;

    static int find(int[] source, long fix, int low, int high) {
        if (found || fix < source[low]) {
            return -1;
        }
        if (low == high) {
            if (source[low] == 0) {
                return -1;
            }
            if (low == 0) {
                if (fix >= source[0]) {
                    found = true;
                    return low;
                }
            }
            if (low == source.length - 1) {
                if (fix <= source[low] && fix >= source[low - 1]) {
                    found = true;
                    return low - 1;
                }
            }
            if (source[low] <= fix) {
                if (source[low + 1] == 0 || fix <= source[low + 1]) {
                    return low;
                }
            }
            return -1;
        }
        int mid = (low+high)/2;
        int right = find(source, fix, mid+1, high);
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
            long arr[] = rw.rla();
            long x = rw.glfs(arr, 0);
            long n = rw.glfs(arr, 1);
            long lights[] = rw.rla();
            G[] assignPos = new G[(int)n+2];
            G[] assignPosCopy = new G[lights.length];
            for (int i = 1; i < lights.length+1; i++) {
                assignPos[i] = new G(lights[i-1]);
            }
            for (int i = 0; i < lights.length; i++) {
                assignPosCopy[i] = assignPos[i + 1];
            }
            assignPos[0] = new G(1);
            assignPos[assignPos.length - 1] = new G(x);
            Arrays.sort(assignPos, Comparator.comparing(g -> g.pos));
            for (int i = 0; i < assignPos.length; i++) {
                assignPos[i].spos = i;
            }
            int[] fit = new int[assignPos.length];
            int[] nearest = new int[assignPos.length];
            fit[0] = 1; fit[fit.length - 1] = (int)x;
            nearest[0] = (int)x;
            TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            int max = (int)x - 1;
            map.put(max, 1);
            for (int i = 0; i < n; i++) {
                found = false;
                G g = assignPosCopy[i];
                if (g.pos == 1 || g.pos == x) {
                    rw.printWriter.print(map.firstKey() + " ");
                } else {
                    int ni = find(fit, g.pos, 0, fit.length - 1);
                    int l = fit[ni];
                    int near = nearest[ni];
                    int rux = near - l;
                    int c = map.get(rux);
                    if (c == 1) {
                        map.remove(rux);
                    } else{
                        map.put(c, --rux);
                    }
                    int cutl = (int)g.pos - l; int cutr = near - (int)(g.pos);
                    nearest[ni] = (int)g.pos;
                    fit[(int)g.spos] = (int)g.pos;
                    nearest[(int)g.spos] = near;
                    if (!map.containsKey(cutl)) {
                        map.put(cutl, 0);
                    }
                    if (!map.containsKey(cutr)) {
                        map.put(cutr, 0);
                    }
                    int ev = map.get(cutl);
                    map.put(cutl, ++ev);
                    int ex = map.get(cutr);
                    map.put(cutr, ++ex);
                    rw.printWriter.print(map.firstKey() + " ");
                }
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
