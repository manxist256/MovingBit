/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.HashMap;

/**
 *
 * @author mankank
 */

class BST$22 {
    
        class Pair {
            Node left, right;
            public Pair(Node left, Node right) {
                this.left = left;
                this.right = right;
            }
        }
    
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        HashMap<Node, Pair> map;
        
        public BST$22() {
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
            this.map = new HashMap<>();
            this.inOrder(this.root, map);
            System.out.println();
        }
        
        private void inOrder(Node node, HashMap<Node, Pair> map) {
            if (node != null) {
                this.inOrder(node.left, map);
                map.put(node, new Pair(node.left, node.right));
                System.out.print(node.data + " ");
                this.inOrder(node.right, map);
            }
        }
        
        public void swap(int data) {
            swap(this.root, data);
        }
        
        private void swap(Node node, int data) {
            if (node != null) {
                if (node.data == data) {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    return;
                }
                this.swap(node.left, data);
                this.swap(node.right, data);
            }
        }
        
        public boolean isIsomorphic() {
            return isIsomorphic(this.root);
        }
        
        private boolean isIsomorphic(Node node) {
            if (node != null) {
                Pair pair = map.get(node);
                if (!((node.left == pair.left && node.right == pair.right) || (node.left == pair.right && node.right == pair.left))) {
                    return false;
                }
                boolean lv = isIsomorphic(node.left);
                boolean rv = isIsomorphic(node.right);
                return lv && rv;
            }
            return true;
        }
        
}


public class TreeIsomophism {
    public static void main(String[] args) {
        BST$22 bst = new BST$22();
        bst.insert(1000);
        bst.insert(500);
        bst.insert(1500);
        bst.insert(250);
        bst.insert(750);
        bst.insert(625);
        bst.insert(875);
        bst.insert(1250);
        bst.inOrder();
        bst.swap(1000);
        bst.swap(1500);
        bst.swap(750);
        boolean validation = bst.isIsomorphic();
        System.out.println(validation);
        bst.inOrder();
    }
}
