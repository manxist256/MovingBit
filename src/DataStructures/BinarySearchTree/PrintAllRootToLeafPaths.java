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

class BST$18 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$18() {
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
        
        public void printPaths() {
                printPaths(this.root, "");
        }
        
        private static void printPaths(Node node, String s) {
            if (node != null) {
                if (node.left == null && node.right == null) {
                    System.out.println(s + node.data);
                    return;
                }
                s = s + node.data + "->";
                printPaths(node.left, s);
                printPaths(node.right, s);
            }
        }
        
}

public class PrintAllRootToLeafPaths {
        public static void main(String[] args) {
                BST$18 bst = new BST$18();
                bst.insert(1000);
                bst.insert(500);
                bst.insert(1500);
                bst.insert(250);
                bst.insert(750);
                bst.insert(1250);
                bst.insert(1750);
                bst.insert(125);
                bst.insert(1725);
                bst.printPaths();
        }
}
