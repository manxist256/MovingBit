package CodeChef.LongChallenge.November2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

class SinglePointOfFailure {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static class Node {
        int i;
        List<Node> adjacencies;
        boolean visited;
        public Node(int i) {
            this.i = i;
            this.adjacencies = new ArrayList<>();
        }
    }

    static int cycleCount = 0;
    static boolean noWay;
    static HashMap<Integer, Integer> map;

    static boolean cycleFormed;
    static void recurse(Node node, int incoming) {
        if (node.visited) {
            cycleFormed = true;
            return;
        }
        node.visited = true;
        List<Node> adjacencies = node.adjacencies;
        for (Node adj : adjacencies) {
            if (incoming == -1 || adj.i != incoming) {
                recurse(adj, node.i);
            }
        }
    }

    static boolean minF = false;
    static Node getMinUnVisitedNode(Node[] nodes, int low, int high) {
        if (minF) {
            return null;
        }
        if (low == high) {
            if (!nodes[low].visited) {
                return nodes[low];
            }
            return null;
        }
        int mid = (low + high) / 2;
        Node left = getMinUnVisitedNode(nodes, low, mid);
        Node right = getMinUnVisitedNode(nodes, mid + 1, high);
        if (left != null && right != null) {
            return left.i < right.i ? left : right;
        }
        return left == null ? right : left;
    }

    static Node getSingleGraph(Node[] nodes) {
        Map<Node, Boolean> map = new HashMap<>();
        while (true) {
            cycleFormed = false;
            minF = false;
            Node node = getMinUnVisitedNode(nodes, 0, nodes.length - 1);
            if (node == null) {
                break;
            }
            recurse(node, -1);
            if (cycleFormed) {
                map.put(node, true);
            }
            if (map.size() > 1) {
                break;
            }
        }
        return (map.size() == 0 || map.size() > 1) ? null : map.keySet().iterator().next();
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            reset();
            int[] input = rw.ria();
            int N = rw.gifs(input, 0);
            int M = rw.gifs(input, 1);
            Node[] nodes = new Node[N];
            for (int i = 0; i < N; i++) {
                nodes[i] = new Node(i + 1);
            }
            for (int i = 0; i < M; i++) {
                int[] edge = rw.ria();
                int e1 = rw.gifs(edge, 0);
                int e2 = rw.gifs(edge, 1);
                Node nodeE1 = nodes[e1 - 1];
                Node nodeE2 = nodes[e2 - 1];
                nodeE1.adjacencies.add(nodeE2);
                nodeE2.adjacencies.add(nodeE1);
            }
            if (M <= 2) {
                rw.println(-1);
                continue;
            }
            Node singleConnectedGraph = getSingleGraph(nodes);
            if (singleConnectedGraph == null) {
                rw.println(-1);
            } else {
                Arrays.asList(nodes).forEach(node -> node.visited = false);
                recurse2(singleConnectedGraph, -1, new LinkedList<>());
                if (noWay) {
                    rw.println(-1);
                } else {
                    int min = 100005;
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        int key = entry.getKey();
                        int value = entry.getValue();
                        if (value == cycleCount) {
                            if (key < min) {
                                min = key;
                            }
                        }
                    }
                    //rw.println(cycleCount);
                    rw.println(min);
                }
            }
        }
    }

    public static void recurse2(Node node, int incoming, List<Integer> traces) {
        if (noWay) {
            return;
        }
        if (node.visited) {
            try {
                cycleCount++;
                updateAndValidate(traces, node.i);
            } catch(Exception e) {
                cycleCount--;
            }
            return;
        }
        node.visited = true;
        traces.add(node.i);
        List<Node> adjacencies = node.adjacencies;
        for (Node adj : adjacencies) {
            if (incoming == -1 || adj.i != incoming) {
                recurse2(adj, node.i, traces);
            }
            if (noWay) {
                break;
            }
        }
        if (!noWay) {
            node.visited = false;
            traces.remove(traces.size() - 1);
        }
    }

    private static void updateAndValidate(List<Integer> traces, int begin) {
        int re = -1;
        for (int i = 0; i < traces.size(); i++) {
            int ss = traces.get(i);
            if (ss == begin) {
                re = i;
                break;
            }
        }
        for (int i = re; i < traces.size(); i++) {
            int ss = traces.get(i);
            if (!map.containsKey(ss)) {
                map.put(ss, 0);
            }
            int ev = map.get(ss);
            map.put(ss, ++ev);
        }
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == cycleCount) {
                c++;
            }
        }
        if (c == 0) {
            noWay = true;
        }
    }

    static void reset() {
        cycleCount = 0;
        noWay = false;
        map = new HashMap<>();
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
