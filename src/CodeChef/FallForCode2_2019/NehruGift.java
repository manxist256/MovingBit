package CodeChef.FallForCode2_2019;

import java.io.*;
import java.util.InputMismatchException;

public class NehruGift {

    static InputReader in = new InputReader(System.in);

    private static void solve() {
        TrieDictionary trieDictionary = new TrieDictionary();
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            trieDictionary.insertWord(in.next());
        }
        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            String prefix = in.next();
            Node walker = trieDictionary.buildPossibilities(prefix);
            if (walker == null) {
                printWriter.println(-1);
                continue;
            }
            printWriter.print(walker.count);
            printWriter.print(" ");
            trieDictionary.asLeftAsPossible(walker, prefix, printWriter);
            printWriter.print(" ");
            trieDictionary.asRightAsPossible(walker, prefix, printWriter);
            printWriter.println();
        }
        printWriter.flush();
    }

    public static void main(String[] args) throws Exception {
        solve();
    }
}

class Node {
    char c;
    Node[] arr;
    int count = 0;
    boolean word;
    public Node () {
        this.arr = new Node[5];
    }
}

class TrieDictionary {
    Node root;
    public TrieDictionary() {
        root = new Node();
    }

    public void insertWord(String word) {
        int i = 0, max = word.length();
        Node walker = root;
        walker.count += max;
        while (i < max) {
            char c = word.charAt(i);
            int index = c - 97;
            if (walker.arr[index] == null) {
                Node newnode = new Node();
                newnode.c = c;
                walker.arr[index] = newnode;
            }
            walker = walker.arr[index];
            walker.count += ((max-1) - i);
            if (i == word.length() - 1) {
                walker.word = true;
            }
            i++;
        }
    }

    public Node buildPossibilities(String pattern) {
        Node walker = root;
        int i = 0;
        try {
            while (i < pattern.length()) {
                walker = walker.arr[pattern.charAt(i) - 97];
                i++;
            }
        } catch (Exception e) {
            return null;
        }
        return walker;
    }

    public void asLeftAsPossible(Node walker, String prefix, PrintWriter printWriter) {
        printWriter.print(prefix);
        outer : while (true) {
            if (walker.word) {
                return;
            }
            for (int i = 0; i < 5; i++) {
                if (walker.arr[i] != null) {
                    printWriter.print(walker.arr[i].c);
                    walker = walker.arr[i];
                    continue outer;
                }
            }
            break;
        }
    }

    public void asRightAsPossible(Node walker, String prefix, PrintWriter printWriter) {
        printWriter.print(prefix);
        outer : while (true) {
            for (int i = 4; i >= 0; i--) {
                if (walker.arr[i] != null) {
                    printWriter.print(walker.arr[i].c);
                    walker = walker.arr[i];
                    continue outer;
                }
            }
            break;
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public interface SpaceCharFilter {

        public boolean isSpaceChar(int ch);
    }

    public String next() {
        return nextString();
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public Long nextLong() {
        return Long.parseLong(nextString());
    }

    public Double nextDouble() {
        return Double.parseDouble(nextString());
    }

    public int[] nextIntArray(int N) {
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = nextInt();
        }
        return A;
    }

    public long[] nextLongArray(int N) {
        long A[] = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = nextLong();
        }
        return A;
    }

    public double[] nextDoubleArray(int N) {
        double A[] = new double[N];
        for (int i = 0; i < N; i++) {
            A[i] = nextDouble();
        }
        return A;
    }
}