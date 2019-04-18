package CodeChef.LongChallenge.April2019;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubTreeRemoval {

    public static void findAns(long X, Node root, HashMap<Integer, Node> map) {
        long T = root.data; //initialize profit.
        System.out.println(T - getC(root, X));

    }

    private static long getC(Node node, long X) {

        long c = 0;

        if (node.visited) {
            return c;
        } else {
            node.visited = true;
        }

        //leaf node.
        if (node.childs.isEmpty() && node.data < -X) {
            return node.data + X;
        } else if (node.childs.isEmpty()) {
            return 0;
        }

        for (Node node1 : node.childs) {
            c += getC(node1, X);
        }


        long pf1 = c; //removing all down
        long pf2 = node.data + X; //remove root
        // has to be minimum

        if (pf1 < pf2) {
            return pf1;
        } else {
            return pf2;
        }
    }

    public static void update(HashMap<Integer, Node> map) {
        Node root = map.get(1);
        update(root);
    }

    public static long update(Node node) {
        long cum = 0l;
        if (node == null || node.visited) {
            return 0;
        }
        node.visited = true;
        for (Node n : node.childs) {
            cum += update(n);
        }
        node.data += cum;
        node.visited = false;
        return node.data;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String inp[] = br.readLine().split(" ");
            int N = Integer.parseInt(inp[0]); long X = Long.parseLong(inp[1]);
            long[] a = new long[N];
            String buff[] = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                a[i] = Long.parseLong(buff[i]);
            }
            if (N == 1) {
                System.out.println(a[0] < X ? -X : a[0]);
                continue;
            }
            HashMap<Integer, Node> map = new HashMap<>();
            for (int i = 0; i < N - 1; i++) {
                String in[] = br.readLine().split(" ");
                int u = Integer.parseInt(in[0]), v = Integer.parseInt(in[1]);
                if (!map.containsKey(u)) {
                    map.put(u, new Node(a[u - 1], u));
                }
                if (!map.containsKey(v)) {
                    map.put(v, new Node(a[v - 1], v));
                }
                map.get(u).childs.add(map.get(v));
                map.get(v).childs.add(map.get(u));
            }
            update(map);
            findAns(X, map.get(1), map);
        }
    }
}

class Node implements Comparator {
    long data;
    int pos;
    boolean visited;
    ArrayList<Node> childs;
    public Node(long data, int pos) {
        this.data = data;
        this.pos = pos;
        this.childs = new ArrayList<>();
    }

    public int compare(Object o1, Object o2) {
        Node n1 = (Node) o1;
        Node n2 = (Node) o2;
        return n1.data > n2.data ? +1 : -1;
    }
}
