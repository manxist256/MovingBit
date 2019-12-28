//package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

class WEIRDO {

    static MathContext mathContext = new MathContext(7);
    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();
    static int[] aliceC;
    static int[] aliceWC;
    static int[] bobC;
    static int[] bobWC;

    private static void by(List<String> list, int[] charCount, int[] wordCount) {
        for (String s : list) {
            boolean[] ac = new boolean[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                charCount[c-97]++;
                if (!ac[c - 97]) {
                    ac[c - 97] = true;
                    wordCount[c-97]++;
                }
            }
        }
    }

    private static double log(long base, long exp) {
        return exp * Math.log10(base);
    }

    private static double get(int[] charCount, int[] wordCount, List<String> list) {
        double sum = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0) {
                continue;
            }
            sum += log(wordCount[i], 1);
            sum -= log(charCount[i], list.size());
        }
        return sum;
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (T-- > 0) {
            aliceC = new int[26];
            aliceWC = new int[26];
            bobC = new int[26];
            bobWC = new int[26];
            int L = rw.ri();
            String[] strings = new String[L];
            for (int i = 0; i < L; i++) {
                strings[i] = rw.rs();
            }
            List<String> alice = new Vector<>();
            List<String> bob = new Vector<>();
            int max = 0;
            outer : for (int i = 0; i < L; i++) {
                String s = strings[i];
                if (s.length() > max) {
                    max = s.length();
                }
                if (s.length() == 2) {
                    if (!isVowel(s.charAt(0)) && !isVowel(s.charAt(1))) {
                        bob.add(s);
                    } else {
                        alice.add(s);
                    }
                    continue;
                }
                for (int j = 0; j < s.length() - 2; j++) {
                    int c = 0;
                    c = isVowel(s.charAt(j)) ? ++c : c;
                    c = isVowel(s.charAt(j+1)) ? ++c : c;
                    c = isVowel(s.charAt(j+2)) ? ++c : c;
                    if (!(c >= 2)) {
                        bob.add(s);
                        continue outer;
                    }
                }
                alice.add(s);
            }

            if (L >= 1000) {
                int N = alice.size();
                int M = bob.size();
                if ((N - M) >= 20) {
                    stringBuilder.append("Infinity");
                    stringBuilder.append("\n");
                    continue;
                }
            }

            by(alice, aliceC, aliceWC);
            by(bob, bobC, bobWC);
            try {
                double numSum = get(aliceC, aliceWC, alice);
                double denSum = get(bobC, bobWC, bob);
                double total = numSum - denSum;
                double pow = Math.pow(10, total);
                if (pow == Double.POSITIVE_INFINITY || pow > 10000000) {
                    stringBuilder.append("Infinity");
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(pow);
                    stringBuilder.append("\n");
                }
            } catch (Exception e) {
                stringBuilder.append("Infinity");
                stringBuilder.append("\n");
            }
        }
        rw.println(stringBuilder.toString());
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
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

        protected void println(double d) {
            printWriter.println(d);
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