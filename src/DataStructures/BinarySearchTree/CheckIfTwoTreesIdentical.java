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

class BST$4 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$4() {
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
        
        private static ArrayList<Node> getNodeList (BST$4 bst) {
                Node traverse = bst.root;
                Queue<Node> queue = new LinkedList();
                queue.offer(bst.root);
                ArrayList<Node> nodelist = new ArrayList();
                
                while (!bst.maxLevelReached(queue.toArray())) {
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
        
        public static void checkIdentical(BST$4 bst1, BST$4 bst2) {
                ArrayList<Node> nodelist1 = getNodeList(bst1);
                ArrayList<Node> nodelist2 = getNodeList(bst2);
                System.out.println(nodelist1.size() + " "+nodelist2.size());
                if (Integer.valueOf(nodelist1.size()).compareTo(nodelist2.size()) != 0) {
                        System.out.println("not identical");
                        return;
                }
                for (int i = 0; i < nodelist1.size(); i++) {
                        if ((nodelist1.get(i) != null && nodelist2.get(i) == null) 
                                || (nodelist1.get(i) == null && nodelist2.get(i) != null)) {
                                System.out.println("not identical");
                                return;
                        }
                }
                System.out.println("identical");
        }
        
}

public class CheckIfTwoTreesIdentical {
        public static void main(String[] args) {
//                BST$4 bst1 = new BST$4();
//                bst1.insert(1000);
//                bst1.insert(500);
//                bst1.insert(1500);
//                bst1.insert(250);
//                bst1.insert(750);
//                bst1.insert(1250);
//                bst1.insert(1750);
//                bst1.insert(125);
//                bst1.insert(625);
//                bst1.insert(130);
//                bst1.insert(1110);
//                bst1.insert(1109);
//                bst1.insert(1108);
//                //
//                BST$4 bst2 = new BST$4();
//                bst2.insert(1000);
//                bst2.insert(500);
//                bst2.insert(1500);
//                bst2.insert(250);
//                bst2.insert(750);
//                bst2.insert(1250);
//                bst2.insert(1750);
//                bst2.insert(125);
//                bst2.insert(625);
//                bst2.insert(130);
//                bst2.insert(1110);
//                bst2.insert(1109);
//                bst2.insert(1108);
//                BST$4 bst1 = new BST$4();
//                bst1.insert(100);
//                BST$4 bst2 = new BST$4();
//                bst2.insert(100);
//                BST$4.checkIdentical(bst1, bst2);
        }
}
