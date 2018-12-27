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

class BST$16 {
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
    
    public void rootToLeafPathSum(int sum) {
        this.rootToLeafPathSum(this.root, sum, 0);
    }
    
    private void rootToLeafPathSum(Node node, int sum, int c) {
        if (node != null) {
            c = c + node.data;
            if (node.left == null && node.right == null) {
                if (c == sum) {
                    System.out.println("There exists a path from root to leaf with sum : " + sum);
                }
                return;
            }
            this.rootToLeafPathSum(node.left, sum, c);
            this.rootToLeafPathSum(node.right, sum, c);
        }
    }
    
}

public class RootToLeafPathSum {
    public static void main(String[] args) {
        BST$16 bst = new BST$16();
        bst.insert(1000);
        bst.insert(1500);
        bst.insert(1250);
        bst.insert(1750);
        bst.insert(500);
        bst.rootToLeafPathSum(3750);
    }
}
