/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mankank
 */

class BinaryTree$3 {
        class Node {
            int data;
            Node left, right;
            public Node(int data) {
                    this.data = data;
            }
        }
        Node root;
        int t = 0;
        Node[] arr = new Node[(int)10e5];
        public BinaryTree$3() {
                this.root = null;
        }
        
        private int getLeftChild(int index) {
                return 2 * index + 1;
        }
        
        private int getRightChild(int index) {
                return 2 * index + 2;
        }
        
        public void insert(int data) {
                Node newnode = new Node(data);
                if (null == root) {
                        this.root = newnode;
                        arr[t++] = newnode;
                        return;
                }
                for (int i = 0; i < t; i++) {
                        if (arr[getLeftChild(i)] == null) {
                                arr[i].left = newnode;
                                arr[t++] = newnode;
                                return;
                        }
                        if (arr[getRightChild(i)] == null) {
                                arr[i].right = newnode;
                                arr[t++] = newnode;
                                return;
                        }
                }
        }
        
        public static void buildTree(int[] in, int[] pre) {
            BinaryTree$3 bt= new BinaryTree$3();
            HashMap<Integer, Node> map = new HashMap<>();
            bt.buildTree(in, pre, 0, in.length - 1, map);
            bt.lot();
        }
        
        private static int position(int[] in, int s, int e, int data) {
            for (int i = s; i <= e; i++) {
                if (in[i] == data) {
                    return i;
                }
            }
            return -1;
        }
        
        int pi = 0;
        
        private void buildTree(int[] in, int[] pre, int s, int e, HashMap<Integer, Node> map) {
            if (pi == in.length) return;
            int x = position(in, s, e, pre[pi]);
            Node node;
            if (!map.containsKey(pre[pi])) {
                map.put(pre[pi], new Node(pre[pi]));
            }
            node = map.get(pre[pi]);
            if (pi == 0) this.root = node;
            if (x != -1) {
                pi += 1;
                int index = pi;
                buildTree(in, pre, s, x - 1, map);
                if (pi > index) {
                    Node left;
                    if (!map.containsKey(pre[index])) {
                        left = new Node(pre[index]);
                        map.put(pre[index], left);
                    }
                    left = map.get(pre[index]);
                    node.left = left;
                    map.put(pre[index], left);
                }
                index = pi;
                buildTree(in, pre, x + 1, e, map);
                if (pi > index) {
                    Node right;
                    if (!map.containsKey(pre[index])) {
                        right = new Node(pre[index]);
                        map.put(pre[index], right);
                    }
                    right = map.get(pre[index]);
                    node.right = right;
                    map.put(pre[index], right);
                }
            }
        }
        
        public void lot() {
            Queue<Node> q = new LinkedList<>();
            ArrayList<Node> lot = new ArrayList<>();
            q.offer(this.root);
            int i = 0;
            while (!q.isEmpty() && !levelComplete(q.toArray())) {
                int t = (int)Math.pow(2, i);
                while (t-- > 0) {
                    Node read = q.poll();
                    lot.add(read);
                    if (read == null) {
                        q.offer(null);
                        q.offer(null);
                    } else {
                        q.offer(read.left);
                        q.offer(read.right);
                    }
                }
                i += 1;
            }
            printResult(lot);
        }
        
        private void printResult(ArrayList<Node> lot) {
            int s = 0, e = 2 * s;
            while (s < lot.size()) {
                for (int k = s; k <= e; k++) {
                    System.out.print((lot.get(k) != null ? lot.get(k).data : null) + " ");
                }
                System.out.println();
                s = e + 1;
                e = 2 * s;
                if (e > lot.size()) {
                    e = lot.size() - 1;
                }
            }
        }
        
        private boolean levelComplete(Object[] array) {
            for (Object node : array) {
                if (node != null) {
                    return false;
                }
            }
            return true;
        }
        
}

public class BinaryTreeFromInOrderAndPreOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] in = new int[N], pre = new int[N];
        for (int i = 0; i < N; i++) {
            in[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            pre[i] = sc.nextInt();
        }
        BinaryTree$3.buildTree(in, pre);
    }
}
