/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.ArrayList;

/**
 *
 * @author mankank
 */

class BST$5 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$5() {
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
        
        public void computeBoundaryView() {
                ArrayList<Node> llist = getLeftList(this.root, new ArrayList<>());
                ArrayList<Node> rlist = getRightList(this.root, new ArrayList<>());
                ArrayList<Node> leaflist = new ArrayList<>();
                leaflist = getLeafList(this.root, leaflist);
                int ptr = 0;
                while (ptr < llist.size() && ptr < rlist.size()) {
                        System.out.println(llist.get(ptr).data +"                " + rlist.get(ptr++).data);
                }
                while (ptr < llist.size()) {
                        System.out.println(llist.get(ptr++).data);
                }
                while (ptr < rlist.size()) {
                        System.out.println("               " + rlist.get(ptr).data);
                }
                for (Node leaf : leaflist) {
                        if (!llist.contains(leaf) && !rlist.contains(leaf))
                                System.out.print(leaf.data + " ");
                }
        }
        
        private ArrayList<Node> getLeftList(Node node, ArrayList<Node> llist) {
                if (node != null) {
                        llist.add(node);
                        getLeftList(node.left, llist);
                }
                return llist;
        }
        
        private ArrayList<Node> getRightList(Node node, ArrayList<Node> rlist) {
                if (node != null) {
                        rlist.add(node);
                        getRightList(node.right, rlist);
                }
                return rlist;
        }
        
        private ArrayList<Node> getLeafList(Node node, ArrayList<Node> leaflist) {
                if (node != null) {
                        this.getLeafList(node.left, leaflist);
                        this.getLeafList(node.right, leaflist);
                        if (node.left == null && node.right == null) {
                                leaflist.add(node);
                        }
                }
                return leaflist;
        }
        
}

public class BoundaryView {
        public static void main(String[] args) {
                BST$5 bst = new BST$5();
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
                 bst.insert(40);
                 bst.insert(20);
                 bst.insert(60);
                 bst.insert(10);
                 bst.insert(30);
                 bst.insert(50);
                 bst.insert(70);
                 bst.insert(5);
                 bst.insert(55);
                 bst.insert(45);
                bst.computeBoundaryView();
        }
}
