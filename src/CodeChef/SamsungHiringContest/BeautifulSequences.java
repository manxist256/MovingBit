package CodeChef.SamsungHiringContest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;

class BeautifulSequences {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        long mod = 100_00_00_000 + 7;
        while (T-- > 0) {
            long[] input = rw.rla();
            long N = rw.glfs(input, 0);
            long K = rw.glfs(input, 1);
            long P = rw.glfs(input, 2);
            long[] arr = rw.rla();
            N = arr.length;
            Arrays.sort(arr);
            int[] cuz = new int[(int)N];
            Arrays.fill(cuz, -1);
            for (int i = 0; i < N; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] - arr[j] > P) {
                        cuz[i] = j;
                        break;
                    }
                }
            }
            long[][] dp = new long[(int)K][(int)N];
            for (int i = 0; i < N; i++) {
                dp[0][i] = i + 1;
            }
            for (int k = 1; k < K; k++) {
                for (int i = k; i < N; i++) {
                    if (cuz[i] != -1) {
                        dp[k][i] = ((dp[k][i - 1] % mod) + (((dp[k - 1][i - 1] % mod) - (dp[k - 1][cuz[i]] % mod)) % mod)) % mod;
                    } else {
                        dp[k][i] = ((dp[k][i - 1] % mod) + (dp[k - 1][i - 1] % mod)) % mod;
                    }
                }
            }
            rw.println(dp[(int)K - 1][(int)N - 1] % mod);
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
