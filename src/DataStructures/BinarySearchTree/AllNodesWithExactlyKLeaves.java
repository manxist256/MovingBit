/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

/**
 *
 * @author mankank
 */

class BST$20 {
    
        static class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$20() {
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
        
        public void nodesWithKLeaves(int k) {
            nodesWithKLeaves(this.root, k);
        }
        
        public int nodesWithKLeaves(Node node, int k) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    return 1; //leaf node.
                }
                int lv = nodesWithKLeaves(node.left, k);
                int rv = nodesWithKLeaves(node.right, k);
                if (k == 1 && (lv == 1 && rv != 1 || rv == 1 && lv != 1)) {
                    System.out.println(node.data);
                } else if (k == 2 && lv == 1 && rv == 1) {
                    System.out.println(node.data);
                }
                return Integer.MAX_VALUE;
            }
            return 0;
        }
        
}

public class AllNodesWithExactlyKLeaves {
    public static void main(String[] args) {
        BST$20 bst = new BST$20();
        bst.insert(1000);
        bst.insert(500);
        bst.insert(1500);
        bst.insert(1250);
        bst.insert(250);
        bst.insert(750);
        bst.insert(1750);
        bst.insert(1625);
        bst.nodesWithKLeaves(1);
    }
}
