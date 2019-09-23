package CodeChef.Cookoff.September2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class TwoGroups {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        outer : while (T-- > 0) {
            int[] arr = rw.ria();
            int A = rw.gifs(arr, 0);
            int B = rw.gifs(arr, 1);
            int C = rw.gifs(arr, 2);
            int sum = A + (2 * B) + (3 * C);
            if (sum % 2 != 0) {
                rw.println("NO");
                continue outer;
            }
            int req = sum / 2;
            if (A > 0 && B > 0 && C > 0) {//1 and 2 and 3
                if (A >= req) {
                    rw.println("YES");
                    continue outer;
                }
                rw.println("YES");
                continue outer;
            } else {
                if (A > 0 && B > 0) { //1 and 2
                    rw.println("YES");
                    continue outer;
                } else if (B > 0 && C > 0) { //2 and 3
                    if (req % 2 == 0) {
                        int bk = req / 2;
                        if (B >= bk) {
                            rw.println("YES");
                            continue outer;
                        }
                        int rem = req - (2 * B);
                        int mod = rem % 3;
                        if ((mod == 0) || (mod == 2 && B >= 2) || (mod == 1)) {
                            rw.println("YES");
                            continue outer;
                        }
                    } else { //req is mod
                        if (req % 3 == 0) {
                            int kp = req / 3;
                            if (C >= kp) {
                                rw.println("YES");
                                continue outer;
                            }
                        }
                        int bx = 2 * B;
                        int cx = 3 * C;
                        if (bx < req) {
                            int rem = req - 2*B;
                            int mod = rem % 3;
                            if ((mod == 0) || (mod == 2 && B >= 2) || (mod == 1 && B >= 1)) {
                                rw.println("YES");
                                continue outer;
                            }
                        } else if (cx < req) {
                            int rem = req - 3*C;
                            int mod = rem % 2;
                            if ((mod == 0)) {
                                rw.println("YES");
                                continue outer;
                            } else if (mod == 1) {
                                rw.println("YES");
                                continue outer;
                            }
                        }
                    }
                } else if (C > 0 && A > 0) { //3 and 1
                    if (A >= req) {
                        rw.println("YES");
                        continue outer;
                    }
                    int rem = req - A;
                    int mod = rem % 3;
                    if ((mod == 1 && A >= 2) || (mod == 2 && A >= 1) || (mod == 0)) {
                        rw.println("YES");
                        continue outer;
                    }
                }
            }
            if (A > 0 && B == 0 && C == 0) {
                if (A % 2 == 0) {
                    rw.println("YES");
                    continue outer;
                }
            } else if (B > 0 && C == 0 && A == 0) {
                if (B % 2 == 0) {
                    rw.println("YES");
                    continue outer;
                }
            } else if (C > 0 && A == 0 && B == 0) {
                if (C % 2 == 0) {
                    rw.println("YES");
                    continue outer;
                }
            }
            rw.println("NO");
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
