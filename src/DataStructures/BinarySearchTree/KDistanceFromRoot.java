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

class BST$14 {
    class Node {
            int data;
            Node left, right;
            public Node(int data) {
                    this.data = data;
            }
    }
    
    Node root;
    
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
                    traverse.left= newnode;
                    return;
                }
                traverse = traverse.left;
            } else if (traverse.data < data) {
                if (traverse.right == null) {
                    traverse.right= newnode;
                    return;
                }
                traverse = traverse.right;
            }
        }
    }
        
    public void kDistance(int k) {
        kDistance(this.root, k, 0);
    }
    
    private void kDistance(Node node, int k, int d) {
        if (node != null) {
            if (d <= k) {
                if (d == k) {
                    System.out.println(node.data);
                    return;
                }
                kDistance(node.left, k, d + 1);
                kDistance(node.right, k, d + 1);
            }
        }
    }
    
}

public class KDistanceFromRoot {
    public static void main(String[] args) {
//        BST$14 bst = new BST$14();
//        bst.insert(1000);
//        bst.insert(1500);
//        bst.insert(1250);
//        bst.insert(1750);
//        bst.insert(500);
//        bst.insert(250);
//        bst.insert(750);
//        bst.insert(800);
//        bst.insert(775);
//        bst.insert(770);
//        bst.insert(850);
//        bst.insert(900);
//        bst.insert(875);
//        bst.insert(950);
//        bst.insert(975);
//        bst.insert(760);
//        bst.insert(874);
//        bst.insert(873);
//        bst.insert(872);
//        bst.insert(870);
//        bst.insert(871);
//        bst.kDistance(6);
    }
}
