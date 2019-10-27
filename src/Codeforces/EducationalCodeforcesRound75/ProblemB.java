import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemB {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(rw.rs());
            }
            List<String> sortedByLength = list.stream().sorted((s1, s2) -> s1.length() < s2.length() ? -1 : +1).collect(Collectors.toList());
           int zc = 0; int oc = 0;
           for (String s : sortedByLength) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '0') {
                        zc++;
                    } else {
                        oc++;
                    }
                }
           }
           int ans = 0;
           for (int i = 0; i < sortedByLength.size(); i++) {
               if (zc == 0 || oc == 0) {
                   ans += (sortedByLength.size() - i);
                   break;
               }
               String s = sortedByLength.get(i);
               if (s.length() % 2 == 0) {
                   if (oc >= s.length()) {
                        oc -= s.length();
                        ans++;
                   } else {
                       if (oc % 2 == 0) {
                           int req = s.length() - oc;
                           if (zc >= req) {
                               zc -= req;
                               ans++;
                           } else {
                               break;
                           }
                           oc = 0;
                       } else {
                           int r = oc - 1;
                           int req = s.length() - r;
                           if (zc >= req) {
                               ans++;
                           } else {
                               break;
                           }
                           oc = 1;
                       }
                   }
               } else {
                    if (oc >= s.length()) {
                        int fi = s.length() - oc;
                        if (fi == 1) {
                            oc = oc - (s.length() - 1);
                            zc--;
                            ans++;
                        } else  {
                            oc = 0;
                            ans++;
                        }
                    } else {
                        int b = s.length() - oc;
                        oc = 0;
                        zc -= b;
                        ans++;
                    }
               }
           }
           rw.println(ans);
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
