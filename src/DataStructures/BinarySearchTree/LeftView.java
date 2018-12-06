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

class BST$1 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$1() {
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
        
        public void inOrder() {
                this.inOrder(this.root);
                System.out.println();
        }
        
        private void inOrder(Node node) {
                if (node != null) {
                        this.inOrder(node.left);
                        System.out.print(node.data + " ");
                        this.inOrder(node.right);
                }
        }
        
        private boolean maxLevelReached(Object[] q) {
                for (Object q1 : q) {
                        if (q1 != null) {
                                return false;
                        }
                }
                return true;
        }
        
        public void computeLeftView() {
                Node traverse = this.root;
                Queue<Node> queue = new LinkedList();
                queue.offer(this.root);
                ArrayList<Integer> leftView = new ArrayList();
                
                while (!maxLevelReached(queue.toArray())) {
                        int size = queue.size();
                        boolean nodefound = false;
                        while (size-- > 0) {
                                Node node = queue.poll();
                                if (node == null) {
                                        queue.add(null);
                                        queue.add(null);
                                } else {
                                        queue.add(node.left);
                                        queue.add(node.right);
                                        if (!nodefound) {
                                                leftView.add(node.data);
                                                nodefound = true;
                                        }
                                }
                        }
                }
                
                for (int i : leftView) {
                        System.out.println(i);
                }
        }
        
}

public class LeftView {
        public static void main(String[] args) {
//                BST$1 bst = new BST$1();
//                bst.insert(1000);
//                bst.insert(500);
//                bst.insert(1500);
//                bst.insert(250);
//                bst.insert(750);
//                bst.insert(1250);
//                bst.insert(1750);
//                bst.insert(125);
//                bst.insert(625);
//                bst.insert(130);
//                bst.insert(1110);
//                bst.insert(1109);
//                bst.insert(1108);
//                bst.inOrder();
//                bst.computeLeftView();
        }
}
