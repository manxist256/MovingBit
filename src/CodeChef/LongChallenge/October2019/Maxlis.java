//package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

class Maxlis {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static boolean updated = false;

    // binary search and fix
    private static void fix(int x[], int increasing[], int index[], int parent[], int low, int high, int fixValue, int fixValueIndex) {
        if (updated || fixValue > increasing[high]) {
            return;
        }
        if (low == high && low == 0) {
            if (fixValue < increasing[0]) {
                increasing[0] = fixValue;
                index[0] = fixValueIndex;
                updated = true;
            }
            return;
        }
        if (low == high) {
            if (fixValue <= increasing[low] && fixValue > increasing[low - 1]) { // better position to update
                increasing[low] = fixValue;
                index[low] = fixValueIndex;
                parent[fixValueIndex] = index[low - 1];
                updated = true;
            }
            return;
        }
        int mid = (low + high) / 2;
        fix(x, increasing, index, parent, low, mid, fixValue, fixValueIndex);
        fix(x, increasing, index, parent, mid + 1, high, fixValue, fixValueIndex);
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int input[] = rw.ria();
            int N = rw.gifs(input, 0);
            int K = rw.gifs(input, 1);

            int x[] = rw.ria(); // original array
            int increasing[] = new int[x.length + 1]; // stores LIS of each length
            int index[] = new int[x.length + 1]; // in track of above array // store indexes aligning with above array
            int parent[] = new int[x.length + 1]; // parent array and stores index
            if (N == K) {
                Arrays.sort(x);
                for (int i = 0; i < x.length; i++) {
                    rw.printWriter.print(x[i] + " ");
                }
            }

            int length = 1;

            int v = -1;

            increasing[0] = x[0]; index[0] = 0; parent[0] = -1;

            for (int i = 1; i < N; i++) {
                updated = false;
                if (x[i] > increasing[length - 1]) { // LIS length improves
                    increasing[length] = x[i];
                    index[length] = i;
                    parent[i] = index[length - 1];
                    v = i;
                    ++length;
                } else { // length is not improves, find better position
                    int g = increasing[length - 1];
                    fix(x, increasing, index, parent, 0, length - 1, x[i], i);
                    if (g != increasing[length - 1]) {
                        v = i;
                    }
                }
            }
            int LIS[] = new int[length], pos = length - 1;
            while (pos >= 0) {
                LIS[pos] = x[v];
                v = parent[v];
                --pos;
            }

            if (length == 1) {
                rw.printWriter.print(x[1] + " " + x[0] + " ");
                for (int i = 2; i < N; i++) {
                    rw.printWriter.print(x[i] + " ");
                }
                return;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                if (!map.containsKey(x[i])) {
                    map.put(x[i], 0);
                }
                int ev = map.get(x[i]);
                map.put(x[i], ++ev);
            }
            int k = 0;
            boolean f = false;
            long mx; int b = 0;
            mx = K / 3;
            mx = mx > 20 ? --mx : mx;
            int ms[] = new int[K];
            int in[] = new int[K];
            Arrays.fill(in, -1);
            int mix = 0;
            for (int i = 0; i < N; i++) {
                if (k < length && LIS[k] == x[i]) {
                    k++;
                    f = false;
                    mix = 0;
                }
                if (!f && k >= 1 && k < LIS.length && mx > 0) {
                    for (int start = LIS[k-1] + 1; start < LIS[k]; start++) {
                        if (map.containsKey(start) && map.get(start) > 0) {
                            int ev = map.get(start);
                            map.put(start, --ev);
                            in[b] = k-1;
                            ms[b] = start;
                            b++;
                            mx--;
                            mix++;
                            if (mix == 10)
                                break;
                        }
                    }
                    f = true;
                }
            }
            int l = 0; boolean printed = false;
            int g = 0;
            for (int i = 0; i < N; i++) {
                if (map.get(x[i]) > 0) {
                    rw.printWriter.print(x[i] + " ");
                    int ev = map.get(x[i]);
                    map.put(x[i], --ev);
                }
                if (l < length && LIS[l] == x[i]) {
                    l++;
                    printed = false;
                }
                if (l == in[g]+1 && !printed) {
                    int c = 1;
                    g++;
                    for (int j = 0; j < 10; j++) {
                        if (in[g]+1 == l) {
                            c++;
                            g++;
                            continue;
                        }
                        break;
                    }
                    int[] da = new int[c];
                    for (int m = 0; m < c; m++) {
                        da[m] = ms[(g-1) - m];
                    }
                    Arrays.sort(da);
                    for (int m = 0; m < c; m++) {
                        rw.printWriter.print(da[m] + " ");
                    }
                    printed = true;
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
/*
16 4
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
30 19
3189 1 45 67 10 0 67 89 12 10 22 34 78 90 912 8999 345 12 78 130 122 231 67 89 12 90 909 12222 78 10
*/

/*
40 18
3819 839 8 83 28 0 0 8931 8 8 89 18931 31892 189 391 83289 89389 28932 1892 1902 0 8 8 8 8 8 98 98913 189 8931 89 1388319 8931 8931 1892 42891 89 893 4 5
*/

