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

class BST$8 {
        class Node {
                int data;
                Node left, right;
                public Node(int data) {
                        this.data = data;
                }
        }
        
        Node root;
        
        public BST$8() {
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
        
        public void diameter(int d1, int d2) {
                findDiameter(this.root, d1, d2);
        }
        
        private int findDiameter(Node node, int d1, int d2) {
                if (node != null) {
                        if (node.data == d1 || node.data == d2) return 1; 
                        int ld = findDiameter(node.left, d1, d2);
                        int rd = findDiameter(node.right, d1, d2);
                        if (ld > 0 && rd > 0) { 
                                System.out.println(ld + rd + 1);
                                return -1;
                        }
                        if (ld > 0) {
                                return ld + 1;
                        } else if (rd > 0){
                                return rd + 1;
                        }
                }
                return 0;
        }
        
}

public class DiameterBetweenNodes {
        public static void main(String[] args) {
                BST$8 bst = new BST$8();
                bst.insert(1000);
                bst.insert(500);
                bst.insert(1500);
                bst.insert(250);
                bst.insert(750);
                bst.insert(1750);
                bst.insert(125);
                bst.insert(260);
                bst.insert(800);
                bst.insert(255);
                bst.insert(252);
                bst.insert(258);
                bst.insert(760);
                bst.insert(850);
                bst.insert(900);
                Scanner sc = new Scanner(System.in);
                bst.diameter(sc.nextInt(), sc.nextInt());
        }
}
