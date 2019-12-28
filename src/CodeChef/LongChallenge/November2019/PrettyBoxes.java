package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class PrettyBoxes {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static class Box {
        long beauty;
        long size;
        public Box(long size, long beauty) {
            this.beauty = beauty;
            this.size = size;
        }
        @Override
        public String toString() {
            return size+" "+beauty;
        }
    }

    static class Pair {
        long i, j;
        long diff;
        public Pair(long i,  long j, long diff) {
            this.i = i;
            this.j = j;
            this.diff = diff;
        }
        @Override
        public String toString() {
            return i+" "+j+" "+diff;
        }
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            List<Box> boxes = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                long[] arr = rw.rla();
                boxes.add(new Box(arr[0], arr[1]));
            }
            List<Box> sorted = boxes.stream().sorted(
                    (box1, box2) -> {
                        if (box1.size == box2.size) {
                            if (box1.beauty < box2.beauty) {
                                return -1;
                            } else {
                                return +1;
                            }
                        }
                        if (box1.size < box2.size) {
                            return -1;
                        } else {
                            return +1;
                        }
                    }
            ).collect(Collectors.toList());
            ArrayList<Pair> arrayList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    arrayList.add(new Pair(i, j, sorted.get(j).beauty - sorted.get(i).beauty));
                }
            }
            int l = N / 2;
            HashSet<Long> usedTrack = new HashSet<>();
            long total = 0;
            for (int i = 0; i < l; i++) {
                 while (true) {
                    long max = Long.MIN_VALUE;
                    Pair fp = null;
                    for (int j = 0; j < arrayList.size(); j++) {
                        Pair pair = arrayList.get(j);
                        if (usedTrack.contains(pair.i) || usedTrack.contains(pair.j))
                            continue;
                        long diff = pair.diff;
                        if (diff > max) {
                            max = diff;
                            fp = pair;
                        }
                    }
                    if (fp != null && max > 0) {
                        usedTrack.add(fp.i);
                        usedTrack.add(fp.j);
                        total += fp.diff;
                    }
//                    if (fp != null) {
//                        usedTrack.add(fp.i);
//                        usedTrack.add(fp.j);
//                    }
                    break;
                }
                rw.println(total);
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
