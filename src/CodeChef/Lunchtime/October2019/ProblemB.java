package CodeChef.Lunchtime.October2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ProblemB {

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
            int[] input = rw.ria();
            int N = rw.gifs(input, 0);
            int Q = rw.gifs(input, 1);
            HashMap<Integer, Queue<Integer>> map = new HashMap<>();
            Node[] arr = new Node[N + 1];
            for (int i = 0; i < N - 1; i++) {
                int[] read = rw.ria();
                int u = rw.gifs(read, 0);
                int v = rw.gifs(read, 1);
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
                Node b1 = arr[u], b2 = arr[v];
                Queue<Node> uset = arr[u].childrens;
                uset.add(b2);
                Queue<Node> vset = arr[v].childrens;
                vset.add(b1);
            }
            outer: for (int i = 0; i < Q; i++) {
                int[] query = rw.ria();
                int a = rw.gifs(query, 0);
                int da = rw.gifs(query, 1);
                int b = rw.gifs(query, 2);
                int db = rw.gifs(query, 3);
                HashSet<Node> b1 = new HashSet<>();
                HashSet<Node> b2 = new HashSet<>();
                boolean[] pl1 = new boolean[N+1];
                boolean[] pl2 = new boolean[N+1];
                update(b1, arr[a], da, 0, pl1);
                update(b2, arr[b], db, 0, pl2);
                for (Node nkp : b1) {
                    if (b2.contains(nkp)) {
                        rw.println(nkp.position);
                        continue outer;
                    }
                }
                rw.println(-1);
            }
        }
    }

    static void update(HashSet<Node> b1, Node node, int dist, int u, boolean[] visited) {
        visited[node.position] = true;
        if (u == dist) {
            b1.add(node);
        }
        Queue<Node> childrens = node.childrens;
        for (Node n : childrens) {
            if (!visited[n.position]) {
                update(b1, n, dist, u + 1, visited);
            }
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
