/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.BinaryTree;

import java.util.Scanner;

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

public class BinaryTree {
        Node root;
        int t = 0;
        Node[] arr = new Node[(int)10e5];
        public BinaryTree() {
                this.root = null;
        }
        
        private int getLeftChild(int index) {
                return 2 * index + 1;
        }
        
        private int getRightChild(int index) {
                return 2 * index + 2;
        }
        
        public void insert(int data) {
                Node newnode = new Node(data);
                if (null == root) {
                        this.root = newnode;
                        arr[t++] = newnode;
                        return;
                }
                for (int i = 0; i < t; i++) {
                        if (arr[getLeftChild(i)] == null) {
                                arr[i].left = newnode;
                                arr[t++] = newnode;
                                return;
                        }
                        if (arr[getRightChild(i)] == null) {
                                arr[i].right = newnode;
                                arr[t++] = newnode;
                                return;
                        }
                }
        }
        
        public void inOrderTraversal() {
                this.inOrderTraversal(this.root);
                System.out.println();
        }
        
        private void inOrderTraversal(Node node) {
                if (node != null) {
                        this.inOrderTraversal(node.left);
                        System.out.print(node.data + " ");
                        this.inOrderTraversal(node.right);
                }
        }
        
        public void treeTravesal() {
                for (int i = 0; i < t; i++) {
                        System.out.println(arr[i].data + " LeftChild : " + (arr[i].left != null ? arr[i].left.data : -1) + " RightChild : " + (arr[i].right != null ? arr[i].right.data : -1));
                }
                System.out.println("----------");
        }
        
        public void levelOrderTraversal() {
                int l = 0, i = 0;
                outer : while (i < t) {
                        System.out.println("Level " + (l+1) + " elements : ");
                        int maxEIAL = (int)Math.pow(2, l++);
                        for (int j = 0; j < maxEIAL; j++) {
                                if (arr[i] == null) {
                                        break outer;
                                }
                                System.out.print(arr[i++].data + " ");
                        }
                        System.out.println();
                }
        }
}

class BinaryTreeAllOps {
        public static void main(String[] args) {
                BinaryTree bt = new BinaryTree();
                Scanner sc = new Scanner(System.in);
                /*int n = sc.nextInt();
                while (n-- > 0) {
                        bt.insert(sc.nextInt());
                        bt.treeTravesal();
                }*/
                for (int i = 1; i <= 20; i++) {
                        bt.insert(i);
                        //bt.treeTravesal();
                }
                bt.levelOrderTraversal();
        }
}
