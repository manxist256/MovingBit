//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.HashMap;
//
//public class ProblemD {
//
//    static ReaderWriter rw = new ReaderWriter();
//    static Helpers hp = new Helpers();
//
//    private static void solve(boolean multipleTC) throws Exception {
//        int T = multipleTC ? rw.ri() : 1;
//        while (T-- > 0) {
//            long[] arr = rw.rla();
//            long N = rw.glfs(arr, 0);
//            long P = rw.glfs(arr, 1);
//            long[] twoPowMinusPokemon = new long[35];
//            for (int i = 0; i < 35; i++) {
//                long twoP = (long)Math.pow(2, i);
//                twoPowMinusPokemon[i] = twoP - P;
//            }
//            long b = N == 1 ? 1 : N - 1;
//            long twoD[][] = new long[35][1];
//            for () {
//
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        solve(false);
//        rw.flush();
//    }
//
//    static class Helpers {
//
//        static long gcd(long a, long b) {
//            if (b == 0) {
//                return a;
//            }
//            return gcd(b, a % b);
//        }
//
//        static long lcm(long a, long b) {
//            return (a / gcd(a, b)) * b;
//        }
//
//        static <T> HashMap<T, Integer> freqMap(T[] array) {
//            HashMap<T, Integer> map = new HashMap<>();
//            for (int i = 0; i < array.length; i++) {
//                if (!map.containsKey(array[i])) {
//                    map.put(array[i], 0);
//                }
//                int ev = map.get(array[i]);
//                map.put(array[i], ++ev);
//            }
//            return map;
//        }
//
//    }
//
//    static class ReaderWriter {
//        static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        static PrintWriter printWriter = new PrintWriter(System.out);
//
//        protected void flush() throws Exception {
//            printWriter.flush();
//            printWriter.close();
//            bufferedReader.close();
//        }
//
//        protected void println(String s) {
//            printWriter.println(s);
//        }
//
//        protected void println(int i) {
//            printWriter.println(i);
//        }
//
//        protected void println(long l) {
//            printWriter.println(l);
//        }
//
//        int ri() throws Exception {
//            return Integer.parseInt(bufferedReader.readLine());
//        }
//
//        long rl() throws Exception {
//            return Long.parseLong(bufferedReader.readLine());
//        }
//
//        String rs() throws Exception {
//            return bufferedReader.readLine();
//        }
//
//        double rd() throws Exception {
//            return Double.parseDouble(bufferedReader.readLine());
//        }
//
//        int[] ria() throws Exception {
//            String[] line = rs().split(" ");
//            int[] arr = new int[line.length];
//            for (int i = 0; i < line.length; i++) {
//                arr[i] = Integer.parseInt(line[i]);
//            }
//            return arr;
//        }
//
//        long[] rla() throws Exception {
//            String[] line = rs().split(" ");
//            long[] arr = new long[line.length];
//            for (int i = 0; i < line.length; i++) {
//                arr[i] = Long.parseLong(line[i]);
//            }
//            return arr;
//        }
//
//        int gifs(int[] line, int index) {
//            return line[index];
//        }
//
//        long glfs(long[] line, int index) {
//            return line[index];
//        }
//
//        void pia(int[] array) {
//            for (int i = 0; i < array.length; i++) {
//                printWriter.print(array[i] + " ");
//            }
//            printWriter.println();
//        }
//
//        void pla(long[] array) {
//            for (int i = 0; i < array.length; i++) {
//                printWriter.print(array[i] + " ");
//            }
//            printWriter.println();
//        }
//    }
//}
