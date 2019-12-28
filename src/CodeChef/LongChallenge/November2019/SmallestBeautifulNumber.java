package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class SmallestBeautifulNumber {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static HashSet<Integer> powers = new HashSet<>();
    static ArrayList<Integer> dupPowers = new ArrayList<>();
    static boolean f = false;

    static void recurse(long N, long pos, StringBuilder stringBuilder, int total) {
        if (powers.contains(total) && pos == N) {
            f = true;
            return;
        }
        if (pos == N || f) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!f) {
                stringBuilder.append(i);
                recurse(N, pos + 1, stringBuilder, total + (i * i));
            }
            if (!f) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }

    static int[][] poss = new int[20000][50];
    static LinkedList<Integer>[][] state = new LinkedList[20000][50];

    private static LinkedList<Integer> getPowers(int N, int positions) {
        if (positions == 1) {
            if (powers.contains(N) && N <= 81) {
                LinkedList linkedList = new LinkedList();
                linkedList.add((int)Math.sqrt(N));
                return linkedList;
            } else {
                return null;
            }
        }
        if (poss[N][positions] == -1) {
            return null;
        } else if (poss[N][positions] == 1) {
            return state[N][positions];
        }
        LinkedList<Integer> r = new LinkedList<>();
        LinkedList<Integer> eff = null;
        Map<Integer, LinkedList<Integer>> maps = new HashMap<>();
        int newn = -1;
        for (int i = 1; i <= 9; i++) {
            int sq = i * i;
            if (N - sq <= 0) {
                break;
            }
            LinkedList<Integer> get = getPowers(N - sq, positions - 1);
            if (get != null) {
                maps.put(i, get);
//                eff = get;
//                newn = i;
            }
        }
        BigInteger min = new BigInteger("9999999999999999999999999999999999999999");
        for (Map.Entry<Integer, LinkedList<Integer>> entry : maps.entrySet()) {
            int key = entry.getKey();
            LinkedList<Integer> value = entry.getValue();
            Collections.sort(value);
            StringBuilder b = new StringBuilder();
            for (Integer k : value) {
                b.append(k);
            }
            BigInteger f = new BigInteger(b.toString());
            if (f.compareTo(min) < 0) {
                min = f;
                eff = value;
                newn = key;
            }
        }
        if (eff != null) {
            for (Integer integer : eff) {
                r.add(integer);
            }
            r.add(newn);
            state[N][positions] = r;
            poss[N][positions] = 1;
            return r;
        } else {
            poss[N][positions] = -1;
            return null;
        }
    }

//    public static void main(String[] args) {
//        for (int i = 1; i <= 10000; i++) {
//            powers.add(i*i);
//            dupPowers.add(i*i);
//        }
//        System.out.println(getPowers(129, 4));
//    }

    public static void main(String[] args) throws Exception {
        solve(true);
        rw.flush();
    }

    private static String find(int N) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (Integer integer : dupPowers) {
            if (integer >= N) {
                linkedList.add(integer);
            }
            if (linkedList.size() == 4) {
                break;
            }
        }
        TreeSet<String> setB = new TreeSet<>();
        for (Integer integer : linkedList) {
            int req;
            int i = 0;
            int total = N;
            while (true) {
                //System.out.println(total);
                try {
                    total -= 1;
                    req = integer - total;
                    i += 1;
                    List<Integer> masala = getPowers(req, i);
                    StringBuilder stringBuilder = new StringBuilder();
                    if (masala != null) {
                        f = true;
                        for (int j = 0; j < (N - i); j++) {
                            stringBuilder.append(1);
                        }
                        Collections.sort(masala);
                        for (Integer integer1 : masala) {
                            stringBuilder.append(integer1);
                        }
                        setB.add(stringBuilder.toString());
                        break;
                    }
                } catch(Exception e) {
                }
                if (total == 0) {
                    break;
                }
            }
        }
        try {
            return setB.first();
        } catch(Exception e) {
            return null;
        }
    }
//4100
    private static void solve(boolean multipleTC) throws Exception {
        for (int i = 1; i <= 10000; i++) {
            //rw.println(i*i);
            System.out.println(i*i);
            powers.add(i*i);
            dupPowers.add(i*i);
        }
        int T =multipleTC?rw.ri():1;
        int P = 101;
        while (T-- > 0) {
            f = false;
            int N = rw.ri();
            StringBuilder stringBuilder = new StringBuilder();
            if (powers.contains(N)) {
                for (int i = 0; i < N; i++) {
                    rw.printWriter.print(1);
                }
                rw.println("");
                continue;
            }
            if (N < 100) {
                recurse(N, 0, stringBuilder, 0);
                if (f) {
                    rw.println(stringBuilder.toString());
                }
            } else {
//                StringBuilder stringBuilder1 = new StringBuilder();
//                recurse(N, 0, stringBuilder1, 0);
//                rw.println(N);
//                rw.println(stringBuilder1.toString());
//                String s = find(N);
//                rw.println(s);
//                rw.println("-------------------------");
//                //rw.println(find(N));
//                String b1 = stringBuilder1.toString();
//                String b2 = s;
//                if (!b1.equals(b2)) {
//                    rw.println("----------ALERT----------");
//                    rw.println(N);
//                    rw.println("----------ALERT----------");
//                }
                String s = find(N);
                rw.println(s == null ? "-1" : s);
            }
//            if (f) {
//                rw.println(stringBuilder.toString());
//            }
//            else
//                rw.println(-1);
        }
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

//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111112568
//11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111114449