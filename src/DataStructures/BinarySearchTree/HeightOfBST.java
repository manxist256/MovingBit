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

class BST$13 {
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
        
    public void getHeight() {
        int h = getHeight(this.root);
        System.out.println(h);
    }
    
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = this.getHeight(node.left);
        int rh = this.getHeight(node.right);
        return lh > rh ? lh + 1 : rh + 1;
    }
    
}

public class HeightOfBST {
    public static void main(String[] args) {
        BST$13 bst = new BST$13();
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
//        bst.insert(1799);
//        bst.insert(1800);
//        bst.insert(1801);
//        bst.insert(1802);
//        bst.insert(1803);
//        bst.insert(1804);
//        bst.insert(1805);
//        bst.insert(1806);
//        bst.insert(1807);
//        bst.insert(1808);
//        bst.getHeight();
    }
}
