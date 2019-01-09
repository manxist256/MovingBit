/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinarySearchTree;

import java.util.Scanner;

/**
 *
 * @author mankank
 */

class BST$21 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$21() {
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
        
        public static void balancedBST(int[] arr) {
            BST$21 bst = new BST$21();
            bst.balancedBST(arr, 0, arr.length - 1);
            bst.inOrder(bst.root);
        }
        
        private void inOrder(Node node) {
            if (node != null) {
                this.inOrder(node.left);
                System.out.println(node.data + " " + (node.left != null ? node.left.data : null) + " " + (node.right != null ? node.right.data : null));
                this.inOrder(node.right);
            }
        }
        
        private void balancedBST(int[] arr, int low, int high) {
            if (low > high) {
                return;
            }
            int mid = (low + high) / 2;
            this.insert(arr[mid]);
            balancedBST(arr, low, mid - 1);
            balancedBST(arr, mid + 1, high);
        }
        
}

public class SortedArrayToBalancedBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        BST$21.balancedBST(arr);
    }
}
