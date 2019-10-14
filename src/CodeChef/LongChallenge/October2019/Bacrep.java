//package CodeChef.LongChallenge.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class Bacrep {

    static class Node {
        Queue<Node> childrens = new LinkedList<>();
        int position;
        public Node(int position) {
            this.position = position;
        }
        long bacterias;
    }

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int[] arr = rw.ria();
            int N = rw.gifs(arr, 0);
            int Q = rw.gifs(arr, 1);
            HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
            Node[] nodeHashMap = new Node[500004];
            for (int i = 0; i < N - 1; i++) {
                int[] edge = rw.ria();
                int u = rw.gifs(edge, 0);
                int v = rw.gifs(edge, 1);
                if (!map.containsKey(u)) {
                    map.put(u, new HashSet<>());
                }
                if (!map.containsKey(v)) {
                    map.put(v, new HashSet<>());
                }
                if (nodeHashMap[u] == null) {
                    nodeHashMap[u] = new Node(u);
                }
                if (nodeHashMap[v] == null) {
                    nodeHashMap[v] = new Node(v);
                }
                HashSet<Integer> uset = map.get(u); uset.add(v);
                HashSet<Integer> vset = map.get(v); vset.add(u);
            }
            boolean[] placed = new boolean[500004];
            buildTree(map, nodeHashMap, placed, 1);
            Node root = nodeHashMap[1];
            long[] initial = rw.rla();
            for (int i = 1; i <= N; i++) {
                nodeHashMap[i].bacterias = initial[i - 1];
            }
            for (int i = 0; i < Q; i++) {
                String[] s = rw.rs().split( " ");
                update(root, 0);
                if (s[0].equals("+")) {
                    nodeHashMap[(Integer.parseInt(s[1]))].bacterias += Long.parseLong(s[2]);
                } else {
                    rw.println(nodeHashMap[(Integer.parseInt(s[1]))].bacterias);
                }
            }
        }
    }

    static void update(Node node, long flown) {
        Queue<Node> childrens = node.childrens;
        if (childrens.size() == 0) {
            node.bacterias += flown;
            return;
        }
        for (Node child : childrens) {
            update(child, node.bacterias);
        }
        node.bacterias = flown;
    }

    static void buildTree(HashMap<Integer, HashSet<Integer>> map, Node[] nodeHashMap, boolean[] placed, int p) {
        placed[p] = true;
        Node node = nodeHashMap[p];
        HashSet<Integer> con = map.get(p);
        Queue<Node> childrens = node.childrens;
        for (Integer pos : con) {
            if (!placed[pos]) {
                childrens.add(nodeHashMap[pos]);
                buildTree(map, nodeHashMap, placed, pos);
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