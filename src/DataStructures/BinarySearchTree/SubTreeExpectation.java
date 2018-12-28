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

class BST$17 {
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
    
    public void hasSubTree(BST$17 subtree) {
        hasSubTree(this.root, subtree);
    }
    
    static boolean subtreefound = false;
    
    private void hasSubTree(Node node, BST$17 subtree) {
        if (node != null && !subtreefound) {
            if (validatesubtree(node, subtree.root)) {
                System.out.println("sub tree found");
                subtreefound = true;
            }
            if (!subtreefound)
                hasSubTree(node.left, subtree);
            if (!subtreefound)
                hasSubTree(node.right, subtree);
        }
    }
    
    private boolean validatesubtree(Node node, Node subnode) {
        if (subnode == null) {
            return true;
        }
        if (node.data != subnode.data) {
            return false;
        }
        boolean lv = validatesubtree(node.left, subnode.left);
        boolean rv = validatesubtree(node.right, subnode.right);
        return lv && rv;
    }
}

public class SubTreeExpectation {
    public static void main(String[] args) {
//        BST$17 bst = new BST$17();
//        bst.insert(1000);
//        bst.insert(1500);
//        bst.insert(500);
//        bst.insert(250);
//        bst.insert(750);
//        bst.insert(1250);
//        bst.insert(1750);
//        bst.insert(125);
//        bst.insert(375);
//        bst.insert(1125);
//        bst.insert(1800);
//        bst.insert(100);
//        bst.insert(130);
//        bst.insert(310);
//        bst.insert(380);
//        bst.insert(90);
//        bst.insert(120);
//        
//        BST$17 subtree = new BST$17();
//        subtree.insert(250);
//        subtree.insert(125);
//        subtree.insert(375);
//        subtree.insert(100);
//        subtree.insert(130);
//        
//        bst.hasSubTree(subtree);
    }
}
