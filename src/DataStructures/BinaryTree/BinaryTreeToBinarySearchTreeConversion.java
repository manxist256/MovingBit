/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author mankank
 */

class BinaryTree$1 {
        class Node {
            int data;
            Node left, right;
            public Node(int data) {
                    this.data = data;
            }
        }
        class Pair {
            int lc, rc;
            public Pair(int lc, int rc) {
                this.lc = lc;
                this.rc = rc;
            }
        }
        Node root;
        ArrayList<Node> nodelist = new ArrayList<>();
        int t = 0;
        Node[] arr = new Node[(int)10e5];
        public BinaryTree$1() {
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
                nodelist.add(newnode);
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
        
        public void convertToBst() {
            int[] array = new int[nodelist.size()];
            fillarray(this.root, array, 0);
            Arrays.sort(array);
            HashMap<Node, Pair> map = new HashMap<>();
            fillmap(map, this.root);
            converttoBST(this.root, map, array, 0, array.length - 1);
        }
        
        private void converttoBST(Node node, HashMap<Node, Pair> map, int[] array, int low, int high) {
            if (node == null) return;
            int lc = map.get(node).lc;
            if (low == high) {
                node.data = array[low + lc];
                return;
            }
            node.data = array[low + lc];
            converttoBST(node.left, map, array, low, (low + lc) - 1);
            converttoBST(node.right, map, array, (low + lc) + 1 , high);
        }
        
        private int fillmap(HashMap<Node, Pair> map, Node node) {
            if (node != null) {
                int lc = fillmap(map, node.left);
                int rc = fillmap(map, node.right);
                map.put(node, new Pair(lc, rc));
                return lc + rc + 1;
            }
            return 0;
        }
        
        private static void fillarray(Node node, int[] array, int i) {
            if (node != null) {
                fillarray(node.left, array, 2 * i + 1);
                array[i] = node.data;
                fillarray(node.right, array, 2 * i + 2);
            }
        }
        
        public void treeTravesal() {
                for (int i = 0; i < t; i++) {
                        System.out.println(arr[i].data + " LeftChild : " + (arr[i].left != null ? arr[i].left.data : -1) + " RightChild : " + (arr[i].right != null ? arr[i].right.data : -1));
                }
                System.out.println("----------");
        }
        
}

public class BinaryTreeToBinarySearchTreeConversion {
    public static void main(String[] args) {
        BinaryTree$1 bt = new BinaryTree$1();
        bt.insert(10);
        bt.insert(2);
        bt.insert(7);
        bt.insert(8);
        bt.insert(4);
        bt.treeTravesal();
        bt.convertToBst();
        bt.treeTravesal();
    }
}
