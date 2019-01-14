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

class BST$23 {
    
        static class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        int ct = 0;
        
        public BST$23() {
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
        
        public void replaceWGreaterValues() {
            int total = getNodeTotal(this.root);
            updateWGW(this.root, total);
        }
        
        private void updateWGW(Node node, int total) {
            if (node != null) {
                this.updateWGW(node.left, total);
                int temp = node.data;
                node.data = total - this.ct;
                this.ct += temp; 
                this.updateWGW(node.right, total);
            }
        }
        
        private int getNodeTotal(Node node) {
            if (node != null) {
                int l = getNodeTotal(node.left);
                int r = getNodeTotal(node.right);
                return l + r + node.data;
            }
            return 0;
        }
}

public class AddAllGreaterValuesToEveryNodeInBST {
    public static void main(String[] args) {
        BST$23 bst = new BST$23();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.inOrder();
        bst.replaceWGreaterValues();
        bst.inOrder();
    }
}
