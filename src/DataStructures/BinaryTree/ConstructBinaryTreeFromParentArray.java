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
//multiple trees are possible / each tree created will be isomorphic to other tree.
//tree-ambiguity will happen. 
class BinaryTree$2 {
        class Node {
            int data;
            Node left, right;
            public Node(int data) {
                    this.data = data;
            }
        }

        Node root;
        public BinaryTree$2() {
                this.root = null;
        }
 
        public void insert(int[] array) {
            HashMap<Integer, Node> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                insertNode(map, i, array[i]);
            }
            //System.out.println(this.root.data);
            //verify
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
        
        private void insertNode(HashMap<Integer, Node> map, int child, int parent) {
            if (!map.containsKey(child)) {
                map.put(child, new Node(child));
            }
            if (!map.containsKey(parent) && parent != -1) {
                map.put(parent, new Node(parent));
            }
            if (parent == -1) {
                this.root = map.get(child);
                return;
            }
            Node p = map.get(parent), c = map.get(child);
            if (p.left == null) {
                p.left = c;
            } else {
                p.right = c;
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

public class ConstructBinaryTreeFromParentArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        BinaryTree$2 bt = new BinaryTree$2();
        bt.insert(array);
    }
}
