//package CodeChef.Exun2019;
//
//import java.io.*;
//import java.util.*;
//
//public class ProblemC {
//
//    static class Node {
//        Queue<Node> childrens = new LinkedList<>();
//        int position;
//        public Node(int position) {
//            this.position = position;
//        }
//    }
//
//    static InputReader inputReader = new InputReader(System.in);
//    static PrintWriter printWriter = new PrintWriter(System.out);
//
//    private static void solve(boolean multipleTC) {
//        int T = multipleTC ? inputReader.nextInt() : 0;
//        while (T-- > 0) {
//            int N = inputReader.nextInt();
//            int Q = inputReader.nextInt();
//            HashMap<Integer, Queue<Integer>> map = new HashMap<>();
//            Node[] arr = new Node[500004];
//            for (int i = 0; i < N - 1; i++) {
//                int u = inputReader.nextInt();
//                int v = inputReader.nextInt();
//                if (!map.containsKey(u)) {
//                    map.put(u, new LinkedList<>());
//                }
//                if (!map.containsKey(v)) {
//                    map.put(v, new LinkedList<>());
//                }
//                if (arr[u] == null) {
//                    arr[u] = new Node(u);
//                }
//                if (arr[v] == null) {
//                    arr[v] = new Node(v);
//                }
//                Queue<Integer> uset = map.get(u); uset.add(v);
//                Queue<Integer> vset = map.get(v); vset.add(u);
//            }
//            boolean[] placed = new boolean[500004];
//            buildTree(map, arr, placed, 1);
//            Node root = arr[1];
//            TreeMap<Integer, Queue<Node>> map1 = new TreeMap<>();
//            update(root, map1);
//            long ans = 0;
//            for (int i = 0; i < Q; i++) {
//                if (!map1.containsKey(i)) {
//                    break;
//                }
//                ans += (map1.get(i).size());
//            }
//            printWriter.println(ans);
//        }
//    }
//
//    static int update(Node node, TreeMap<Integer, Queue<Node>> map) {
//        Queue<Node> childrens = node.childrens;
//        if (childrens.size() == 0) {
//            if (!map.containsKey(0)) {
//                map.put(0, new LinkedList<>());
//            }
//            map.get(0).add(node);
//            return 0;
//        }
//        int max = 0;
//        for (Node child : childrens) {
//            int p = update(child, map);
//            if (p > max) {
//                max = p;
//            }
//        }
//        max++;
//        if (!map.containsKey(max)) {
//            map.put(max, new LinkedList<>());
//        }
//        map.get(max).add(node);
//        return max;
//    }
//
//    static void buildTree(HashMap<Integer, Queue<Integer>> map, Node[] arr, boolean[] placed , int p) {
//        placed[p] = true;
//        Node node = arr[p];
//        Queue<Integer> con = map.get(p);
//        Queue<Node> childrens = node.childrens;
//        for (Integer pos : con) {
//            if (!placed[pos]) {
//                childrens.add(arr[pos]);
//                buildTree(map, arr, placed, pos);
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        solve(true);
//        printWriter.flush();
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
//                arr[i] = Integer.parseInt(line[i]);
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
//class InputReader {
//    private InputStream stream;
//    private byte[] buf = new byte[1024];
//    private int curChar;
//    private int numChars;
//
//    public InputReader(InputStream stream) {
//        this.stream = stream;
//    }
//
//    public int read() {
//        if (numChars == -1) {
//            throw new UnknownError();
//        }
//        if (curChar >= numChars) {
//            curChar = 0;
//            try {
//                numChars = stream.read(buf);
//            } catch (IOException e) {
//                throw new UnknownError();
//            }
//            if (numChars <= 0) {
//                return -1;
//            }
//        }
//        return buf[curChar++];
//    }
//
//    public int nextInt() {
//        return Integer.parseInt(next());
//    }
//
//    public String next() {
//        int c = read();
//        while (isSpaceChar(c)) {
//            c = read();
//        }
//        StringBuffer res = new StringBuffer();
//        do {
//            res.appendCodePoint(c);
//            c = read();
//        } while (!isSpaceChar(c));
//
//        return res.toString();
//    }
//
//    private boolean isSpaceChar(int c) {
//        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
//    }
//}
