/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mankank
 */
class BST$24 {
    
        static class Node {
                int data;
                Node left, right, nextRight;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$24() {
                this.root = null;
        }
        
        public void insert(int data) {
                Node newnode = new Node(data);
                if (this.root == null) {
                        this.root = newnode;
                        return;
                }
                Node traverse = this.root;
                while (traverse != null) {
                        if (data <= traverse.data) {
                                if (traverse.left == null) {
                                        traverse.left = newnode;
                                        return;
                                }
                                traverse = traverse.left;
                        } else {
                                if (traverse.right == null) {
                                        traverse.right = newnode;
                                        return;
                                }
                                traverse = traverse.right;
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
        
        public void levelOrderTraversal() {
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
            int s = 0, e = 2 * s;
            while (s < lot.size()) {
                Node lastnode = null;
                for (int k = s; k <= e; k++) {
                    if (lot.get(k) != null) {
                        if (lastnode != null)
                            lastnode.nextRight = lot.get(k);
                        lastnode = lot.get(k);
                    }
                }
                if (lastnode != null)
                    lastnode.nextRight = null;
                s = e + 1;
                e = 2 * s;
                if (e > lot.size()) {
                    e = lot.size() - 1;
                }
            }
            printResult(lot);
        }
        
        private void printResult(ArrayList<Node> lot) {
            int s = 0, e = 2 * s;
            while (s < lot.size()) {
                Node lastnode = null;
                for (int k = s; k <= e; k++) {
                    Node node = lot.get(k);
                    if (node != null) {
                        System.out.print(node.data + "->" + (node.nextRight != null ? node.nextRight.data : null) + "   ");
                    }
                }
                System.out.println();
                if (lastnode != null)
                    lastnode.nextRight = null;
                s = e + 1;
                e = 2 * s;
                if (e > lot.size()) {
                    e = lot.size() - 1;
                }
            }
        }
        
}
public class ConnectNodesAtSameLevel {
    public static void main(String[] args) {
        BST$24 bst = new BST$24();
        bst.insert(1000);
        bst.insert(500);
        bst.insert(1500);
        bst.insert(250);
        bst.insert(750);
        bst.insert(1250);
        bst.insert(1750);
        bst.insert(125);
        bst.insert(375);
        bst.insert(625);
        bst.insert(875);
        bst.insert(1125);
        bst.insert(1375);
        bst.insert(1625);
        bst.insert(1875);
        bst.levelOrderTraversal();
    }
}
