package CodeChef.Practice.Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class NarutoRun {

    static class Node {
        Queue<Node> childrens = new LinkedList<>();
        int position;
        public Node(int position) {
            this.position = position;
        }
    }

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            HashMap<Integer, Queue<Integer>> map = new HashMap<>();
            Node[] arr = new Node[500004];
            for (int i = 0; i < N - 1; i++) {
                int[] edge = rw.ria();
                int u = rw.gifs(edge, 0);
                int v = rw.gifs(edge, 1);
                if (!map.containsKey(u)) {
                    map.put(u, new LinkedList<>());
                }
                if (!map.containsKey(v)) {
                    map.put(v, new LinkedList<>());
                }
                if (arr[u] == null) {
                    arr[u] = new Node(u);
                }
                if (arr[v] == null) {
                    arr[v] = new Node(v);
                }
                Queue<Integer> uset = map.get(u); uset.add(v);
                Queue<Integer> vset = map.get(v); vset.add(u);
            }
            boolean[] placed = new boolean[500004];
            buildTree(map, arr, placed, 1);
            Node node = arr[1];
            Map<Integer, HashSet<Node>> setMap = new HashMap<>();
            dfs(setMap, node, 1);
            int max = 0, day = 0;
            for (Map.Entry<Integer, HashSet<Node>> entry : setMap.entrySet()) {
                if (entry.getValue().size() > max) {
                    max = entry.getValue().size();
                    day = entry.getKey();
                }
            }
            rw.println(day);
        }
    }

    private static void dfs(Map<Integer, HashSet<Node>> setMap, Node node, int level) {
        if (!setMap.containsKey(level)) {
            setMap.put(level, new HashSet<>());
        }
        HashSet<Node> set = setMap.get(level);
        set.add(node);
        Queue<Node> queue = node.childrens;
        for (Node n : queue) {
            dfs(setMap, n, level + 1);
        }
    }

    static void buildTree(HashMap<Integer, Queue<Integer>> map, Node[] arr, boolean[] placed , int p) {
        placed[p] = true;
        Node node = arr[p];
        Queue<Integer> con = map.get(p);
        Queue<Node> childrens = node.childrens;
        for (Integer pos : con) {
            if (!placed[pos]) {
                childrens.add(arr[pos]);
                buildTree(map, arr, placed, pos);
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
