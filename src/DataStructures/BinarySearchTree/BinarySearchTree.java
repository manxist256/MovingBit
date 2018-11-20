/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

//import java.util.Scanner;

/**
 *
 * @author mankank
 */

class Node {
        int data;
        Node left, right;
        public Node(int data) {
                this.data = data;
        }
}

public class BinarySearchTree {
        Node root;
        public BinarySearchTree() {
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
                        } else if (data > traverse.data) {
                                if (traverse.right == null) {
                                        traverse.right = newnode;
                                        return;
                                }
                                traverse = traverse.right;
                        }
                }
        }
        
        public void search(int data) {
                Node traverse = this.root;
                while (traverse != null) {
                        if (data <= traverse.data) {
                                traverse = traverse.left;
                        } else if (data > traverse.data) {
                                traverse = traverse.right;
                        } else {
                                System.out.println(data + "found.");
                                return;
                        }
                }
                System.out.println(data + " not found.");
        }
        
        private void destroyRelationship(Node delete) {
                delete.left = null;
                delete.right = null;
        }
        
        private void deleteNode(Node delete, Node parent, char child) {
                Node preserveLC = delete.left;
                Node preserveRC = delete.right;
                destroyRelationship(delete);
                if (child == 'l')
                        parent.left = null;
                else if (child == 'r')
                        parent.right = null;
                if (preserveLC == preserveRC && preserveLC == null) {
                    return;
                }
                Node replacement = preserveLC;
                if (preserveLC != null) {
                        Node traverse = preserveLC;
                        while (traverse.right != null) {
                                if (traverse.right.right != null) {
                                        traverse = traverse.right;
                                        continue;
                                }
                                replacement = traverse.right;
                                traverse.right = null;
                                break;
                        }
                } else {
                        replacement = preserveRC;
                        Node traverse = preserveRC;
                        while (traverse.left != null) {
                                if (traverse.left.left != null) {
                                        traverse = traverse.left;
                                        continue;
                                }
                                replacement = traverse.left;
                                traverse.left = null;
                                break;
                        }
                }
                if (replacement != null) {
                        switch (child) {
                                case 'l':
                                        parent.left = replacement;
                                        break;
                                case 'r':
                                        parent.right = replacement;
                                        break;
                                default:
                                        this.root = replacement;
                                        break;
                        }
                        if (replacement != preserveLC) 
                                replacement.left = preserveLC;
                        if (replacement != preserveRC)
                                replacement.right = preserveRC;
                }
        }
        
        protected void delete(int data) {
                if (this.root != null && this.root.data == data && this.root.left == null && this.root.right == null) {
                        this.root = null;
                }
                Node traverse = this.root;
                Node parent = null; 
                char c = '!';
                while (traverse != null) {
                        if (data < traverse.data) {
                                parent = traverse;
                                traverse = traverse.left;
                                c = 'l';
                        } else if (data > traverse.data) {
                                parent = traverse;
                                traverse = traverse.right;
                                c = 'r';
                        } else { // data to be deleted is found
                                deleteNode(traverse, parent, c);
                                break;
                        }
                }
        }
        
        public void inOrderTraversal() {
                this.inOrderTraversal(this.root);
                System.out.println();
        }
        
        private void inOrderTraversal(Node root) {
                if (root != null) {
                        inOrderTraversal(root.left);
                        System.out.print(root.data + " ");
                        inOrderTraversal(root.right);
                }
        }
        
        public void preOrderTraversal() {
                this.preOrderTraversal(this.root);
                System.out.println();
        }
        
        private void preOrderTraversal(Node root) {
                if (root != null) {
                        System.out.print(root.data + " ");
                        preOrderTraversal(root.left);
                        preOrderTraversal(root.right);
                }
        }
        
        public void postOrderTraversal() {
                this.postOrderTraversal(this.root);
                System.out.println();
        }
        
        private void postOrderTraversal(Node root) {
                if (root != null) {
                        postOrderTraversal(root.left);
                        postOrderTraversal(root.right);
                        System.out.print(root.data + " ");
                }
        }
        
}

class BinarySearchTreeAllOps {
        public static void main(String[] args) {
                BinarySearchTree bst = new BinarySearchTree();
                bst.insert(1000);
                bst.insert(500);
                bst.insert(1500);
                bst.insert(250);
                bst.insert(750);
                bst.insert(125);
                bst.insert(375);
                bst.insert(625);
                bst.insert(875);
                bst.insert(1250);
                bst.insert(1750);
                bst.insert(1125);
                bst.insert(1375);
                bst.insert(1625);
                bst.insert(1875);
                bst.inOrderTraversal();
                //bst.preOrderTraversal();
                //bst.postOrderTraversal();
                /*Scanner sc = new Scanner(System.in);
                while (true) {
                    bst.delete(sc.nextInt());
                    bst.inOrderTraversal();
                }*/
                //bst.inOrderTraversal();
        }
}
