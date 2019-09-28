package CodeChef.Lunchtime.September2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class AllSubstrings {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static TreeMap<Character, Integer> fm(char[] array) {
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 0);
            }
            int ev = map.get(array[i]);
            map.put(array[i], ++ev);
        }
        return map;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        outer : while (T-- > 0) {
            String S1 = rw.rs();
            char[] S = S1.toCharArray();
            char[] R = rw.rs().toCharArray();
            TreeMap<Character, Integer> mapS = fm(S);
            TreeMap<Character, Integer> mapR = fm(R);
            for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (!mapR.containsKey(key) || mapR.get(key) < value) {
                    rw.println("Impossible");
                    continue outer;
                }
                int ev = mapR.get(key);
                int cv = ev - value;
                mapR.put(key, cv);
            }
            int cv = S1.charAt(0);
            for (Map.Entry<Character, Integer> entry : mapR.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (key < cv) {
                    for (int i = 0; i < value; i++) {
                        rw.printWriter.print(key);
                    }
                }
            }
            StringBuilder builder = new StringBuilder();
            int c = mapR.get((char)cv);
            for (int i = 0; i < c; i++) {
                builder.append((char)cv);
            }
            String common = builder.toString();
//            if (common.compareTo(S1) <= 0) {
//                rw.printWriter.print(common+S1);
//            } else {
//                rw.printWriter.print(S1+common);
//            }
            boolean np = false;
            for (int i = 0; i < S1.length(); i++) {
                if (S1.charAt(i) < (char)cv) {
                    rw.printWriter.print(S1 + common);
                    np = true;
                    break ;
                } else if (S1.charAt(i) > (char)cv) {
                    rw.printWriter.print(common + S1);
                    np = true;
                    break;
                }
            }
            if (!np) {
                rw.printWriter.print(common+S1);
            }
            for (Map.Entry<Character, Integer> entry : mapR.entrySet()) {
                char key = entry.getKey();
                int value = entry.getValue();
                if (key > cv) {
                    for (int i = 0; i < value; i++) {
                        rw.printWriter.print(key);
                    }
                }
            }
            rw.println("");
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

        <T> HashMap<T, Integer> freqMap(T[] array) {
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
