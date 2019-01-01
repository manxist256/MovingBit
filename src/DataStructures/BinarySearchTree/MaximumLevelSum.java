/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mankank
 */

class BST$19 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$19() {
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
        
        public void maxlevelSum() {
            Queue<Node> queue = new LinkedList();
            queue.offer(this.root);
            int max = 0, i = 0;
            while (!queue.isEmpty()) {
                int twoPow = (int)Math.pow(2, i++), sum = 0;
                for (int j = 0; j < twoPow; j++) {
                    Node node = queue.poll();
                    if (node != null) { 
                        sum += node.data;
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        queue.offer(null);
                        queue.offer(null);
                    }
                }
                if (sum > max) {
                    max = sum;
                }
                Object[] array = queue.toArray();
                
                if (maxlevelReached(array)) {
                    queue.clear();
                }
            }
            System.out.println(max);
        }
        
        private boolean maxlevelReached(Object[] array) {
            for (Object object : array) {
                if (object != null) {
                    return false;
                }
            }
            return true;
        }
        
}

public class MaximumLevelSum {
    public static void main(String[] args) {
        BST$19 bst = new BST$19();
        bst.insert(10);
        bst.insert(3);
        bst.insert(15);
        bst.insert(1);
        bst.insert(7);
        bst.insert(12);
        bst.insert(14);
        bst.maxlevelSum();
    }
}
