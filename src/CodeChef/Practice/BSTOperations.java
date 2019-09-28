package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

class BSTOperations {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    static class Node {
        long data;
        long pos;
        Node left, right;
        Node parent;
        public Node(long x, long pos) {
            this.data = x;
            this.pos = pos;
        }
    }
    static class BST {
        Node head = null;
        public void insert(long x) {
            if (head == null) {
                this.head = new Node(x, 1);
                rw.println(1);
                return;
            }
            Node traverse = this.head;
            while (true) {
                if (x < traverse.data) {
                    if (traverse.left == null) {
                        traverse.left = new Node(x, traverse.pos * 2);
                        traverse.left.parent = traverse;
                        rw.println(traverse.pos * 2);
                        break;
                    }
                    traverse = traverse.left;
                } else {
                    if (traverse.right == null) {
                        traverse.right = new Node(x, traverse.pos * 2 + 1);
                        rw.println(traverse.pos * 2 + 1);
                        traverse.right.parent = traverse;
                        break;
                    }
                    traverse = traverse.right;
                }
            }
        }

        public Node search(long x) {
            Node traverse = this.head;
            while (true) {
                if (traverse.data == x) {
                    return traverse;
                }
                if (x < traverse.data) {
                    traverse = traverse.left;
                } else {
                    traverse = traverse.right;
                }
            }
        }

        public long getSearchPos(long x) {
            long pos = 1;
            Node traverse = this.head;
            while (true) {
                if (traverse.data == x) {
                    return pos;
                }
                if (x < traverse.data) {
                    traverse = traverse.left;
                    pos *= 2;
                } else {
                    traverse = traverse.right;
                    pos = pos * 2 + 1;
                }
            }
        }

        public Node getRightMost(Node node) {
            while (true) {
                if (node.right == null) {
                    return node;
                }
                node = node.right;
            }
        }

        public Node getLeftMost(Node node) {
            while (true) {
                if (node.left == null) {
                    return node;
                }
                node = node.left;
            }
        }

        public void delete(long x) {
            if (head.data == x && head.left == null && head.right == null) {
                this.head = null;
                rw.println(1);
                return;
            }
            Node node = search(x);
            long pk = getSearchPos(x);
            rw.println(node.pos);
            if (node.left == null && node.right == null) {
                if (pk % 2 == 0) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
                return;
            }
            if (node.left != null) {
                Node rightMost = getRightMost(node.left);
                long pk1 = getSearchPos(rightMost.data);
                if (pk1 % 2 != 0) {
                    Node rnleft = rightMost.left;
                    rightMost.left = null;
                    if (rnleft != null) {
                        rightMost.parent.right = rnleft;
                        rnleft.parent = rightMost.parent;
                    }
                    rightMost.parent = node.parent;
                    rightMost.left = node.left;
                    rightMost.right = node.right;
                } else {
                    rightMost.right = node.right;
                    if (node.right != null)
                        node.right.parent = rightMost;
                    rightMost.parent = node.parent;
                }
            } else {
                Node leftMost = getLeftMost(node);
                long pk1 = getSearchPos(leftMost.data);
                if (pk1 % 2 == 0) {
                    Node rnright = leftMost.right;
                    leftMost.right = null;
                    if (rnright != null) {
                        leftMost.parent.left = rnright;
                        rnright.parent = leftMost.parent;
                    }
                    leftMost.parent = node.parent;
                    leftMost.right = node.right;
                    leftMost.left = node.left;
                } else {
                    leftMost.left = node.left;
                    if (node.left != null)
                        node.left.parent = leftMost;
                    leftMost.parent = node.parent;
                }
            }
        }
    }

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            int N = rw.ri();
            BST bst = new BST();
            for (int i = 0; i < N; i++) {
                String[] input = rw.rs().split(" ");
                switch(input[0].trim().charAt(0)) {
                    case 'i' : bst.insert(Long.parseLong(input[1].trim()));
                        break;
                    case 'd' : bst.delete(Long.parseLong(input[1].trim()));
                }
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
