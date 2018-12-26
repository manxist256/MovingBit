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

class BST$12 {
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
        
    public void getDiameter() {
        this.getDiameter(this.root, 0);
        System.out.println(diameter);
    }
    
    int diameter = 0;
    
    public int getDiameter(Node node, int height) {
        if (node == null) return -1;
        int lh = getDiameter(node.left, height + 1);
        int rh = getDiameter(node.right, height + 1);
        if (lh == -1 && rh == -1) {
            return height;
        } else if (lh == -1 && rh > 0) {
            return rh;
        } else if (lh > 0 && rh == -1) {
            return lh;
        } else { //calculate for better diameter;
            int d = (lh - height) + (rh - height) + 1 + height;
            if (d > diameter) {
                diameter = d;
            }
            return lh > rh ? lh : rh;
        }
    }
    
}

public class DiameterOfBinarySearchTree {
    public static void main(String[] args) {
        BST$12 bst = new BST$12();
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
        bst.insert(1000);
        bst.insert(500);
        bst.insert(1500);
        bst.insert(250);
        bst.insert(750);
        //bst.insert(1200);
        //bst.insert(1750);
        bst.getDiameter();
    }
}
