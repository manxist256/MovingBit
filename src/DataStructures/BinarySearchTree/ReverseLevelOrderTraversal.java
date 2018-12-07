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

class BST$6 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$6() {
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

        
        private boolean maxLevelReached(Object[] q) {
                for (Object q1 : q) {
                        if (q1 != null) {
                                return false;
                        }
                }
                return true;
        }
        
        public void computeReverseOrderTraversal() {
                ArrayList<Node> list = getNodelist();
                int e = list.size() - 1 , s = e / 2;
                while (s != 0) {
                        for (int j = s; j <= e; j++) {
                                Node node = list.get(j);
                                if (node != null)
                                        System.out.print(node.data + " ");
                        }
                        System.out.println();
                        e = s - 1;
                        s = e / 2;
                }
                System.out.println(list.get(0).data);
        }
        
        public ArrayList<Node> getNodelist() {
                Node traverse = this.root;
                Queue<Node> queue = new LinkedList();
                queue.offer(this.root);
                ArrayList<Node> nodelist = new ArrayList();
                
                while (!maxLevelReached(queue.toArray())) {
                        int size = queue.size();
                        while (size-- > 0) {
                                Node node = queue.poll();
                                nodelist.add(node);
                                if (node == null) {
                                        queue.add(null);
                                        queue.add(null);
                                } else {
                                        queue.add(node.left);
                                        queue.add(node.right);
                                        
                                }
                        }
                }
                return nodelist;
        }
        
}

public class ReverseLevelOrderTraversal {
        public static void main(String[] args) {
                BST$6 bst = new BST$6();
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
//                bst.insert(50);
//                bst.insert(25);
//                bst.insert(75);
//                bst.insert(12);
//                bst.insert(30);
//                bst.computeReverseOrderTraversal();
        }
}
