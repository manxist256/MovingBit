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

class AVL {
        Node root;
        static class Node {
                int data;
                Node left, right;
                int l_h = 0, r_h = 0;
                public Node(int data) {
                        this.data = data;
                }
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
                                        break;
                                }
                                traverse = traverse.left;
                        } else {
                                if (traverse.right == null) {
                                        traverse.right = newnode;
                                        break;
                                }
                                traverse = traverse.right;
                        }
                }
                updateHeight(this.root);
                checkViolation();
                updateHeight(this.root);
        }
        
        public void inOrderTraversal() {
                this.inOrderTraversal(this.root);
                System.out.println();
        }
        
        private void inOrderTraversal(Node root) {
                if (root != null) {
                        inOrderTraversal(root.left);
                        System.out.println(root.data + " " + " "+root.l_h +" "+root.r_h);
                        inOrderTraversal(root.right);
                }
        }
        
        boolean vf = false;
        
        private void checkViolation() {
                Node checkViolation = this.checkViolation(this.root);
                if (!vf) {
                        if (Math.abs(this.root.l_h - this.root.r_h) > 1) {
                                if (this.root.l_h > this.root.r_h) {   
                                        if (this.root.l_h - this.root.left.l_h == 1) {
                                                Node vl = root.left;
                                                this.leftLeftViolation(root, root);
                                                this.root = vl; 
                                        } else if (this.root.l_h - this.root.left.r_h == 1) {
                                                Node vr = root.left.right;
                                                this.leftRightViolation(root, root);
                                                this.root = vr;
                                        }
                                        
                                } else if (this.root.l_h < this.root.r_h) {  
                                        if (this.root.r_h - this.root.right.r_h == 1) {
                                                Node vr = root.right;
                                                this.rightRightViolation(root, root);
                                                this.root = vr;
                                        } else if (this.root.r_h - this.root.right.l_h == 1) {
                                                Node vr = root.right.left;
                                                this.rightLeftViolation(root, root);
                                                this.root = vr;
                                        }
                                        
                                }
                                
                        }
                }
                vf = false;
        }
        
        private Node checkViolation(Node node) {
                if (node == null) {
                        return null;
                }
                Node left =this.checkViolation(node.left);
                Node right = this.checkViolation(node.right);
                if (left != null) {
                        if (Math.abs(left.l_h - left.r_h) > 1) { //left child violating
                                fixViolation(node, node.left);
                                vf = true;
                        }
                }   
                if (right != null) {
                        if (Math.abs(right.l_h - right.r_h) > 1) { //right child violating
                                fixViolation(node, node.right);
                                vf = true;
                        }
                }
                return node;
        }
        
        private void fixViolation(Node parent, Node violater) {
                int l_h = violater.l_h;
                int r_h = violater.r_h;
                if (l_h > r_h) {
                        if (l_h - violater.left.l_h == 1) { //left_left rotation
                                leftLeftViolation(parent, violater);
                        } else if (l_h - violater.left.r_h == 1) { //left_right rotation
                                leftRightViolation(parent, violater);
                        }
                } else if (r_h > l_h) {
                        if (r_h - violater.right.r_h == 1) { //right_right rotation
                                rightRightViolation(parent, violater);
                        } else if (r_h - violater.right.l_h == 1) { //right_left rotation
                                rightLeftViolation(parent, violater);
                        }
                }
        }
        
        private void leftLeftViolation(Node parent, Node violater) { //right rotate
                Node violater_left = violater.left;
                Node violater_left_right = violater_left.right;
                violater_left.right = violater;
                violater.left = violater_left_right;
                if (parent != violater)
                        parent.left = violater_left;
        }
        
        private void leftRightViolation(Node parent, Node violater) {
                Node violater_left = violater.left;
                Node violater_left_right = violater_left.right;
                Node violater_left_right_left = violater_left_right.left;
                violater_left_right.left = violater_left;
                violater_left.right = violater_left_right_left;
                violater.left = violater_left_right; //end of right rotation;
                Node v_left = violater.left;
                Node v_left_right = v_left.right;
                v_left.right = violater;
                violater.left = v_left_right;
                if (parent != violater) {
                        parent.left = v_left;
                }
        }
        
        private void rightRightViolation(Node parent, Node violater) {
                Node violater_right = violater.right;
                Node violater_right_left = violater_right.left;
                violater_right.left = violater;
                violater.right = violater_right_left;
                if (parent != violater)
                        parent.right = violater_right;
        }
        
        private void rightLeftViolation(Node parent, Node violater) { //left rotate
                Node violater_right = violater.right;
                Node violater_right_left = violater_right.left;
                Node violater_right_left_right = violater_right_left.right;
                violater_right_left.right = violater_right;
                violater_right.left = violater_right_left_right;
                violater.right = violater_right_left; //end of right rotation;
                Node v_right = violater.right;
                Node v_right_left = v_right.left;
                v_right.left = violater;
                violater.right = v_right_left;
                if (parent != violater) {
                        parent.right = v_right;
                }
        }
        
        private int updateHeight(Node node) {
                if (node == null) {
                        return 0;
                }
                int l = updateHeight(node.left);
                int r = updateHeight(node.right);
                node.l_h = l; node.r_h = r;
                return Math.max(l, r) + 1;
        }
        
        private void delete() {
            // delete the node.
            // find suitable node to replace the delete node position.
            // update avl tree height.
            // check for violation.
            // if violation, fix the violation.
            // update avl tree height.
        }
}

public class AVLTree {
        public static void main(String[] args) {
                AVL avl = new AVL();
                /*avl.insert(20);
                avl.insert(15);
                avl.insert(30);
                avl.insert(10);
                avl.insert(25);
                avl.insert(40);
                avl.insert(35);
                avl.insert(50);
                avl.insert(60);   
                avl.insert(45);   
                avl.insert(70);  */
                /*avl.insert(60);
                avl.insert(55);
                avl.insert(70);
                avl.insert(65);
                avl.insert(80);
                avl.insert(68);*/
                /*avl.insert(1);
                avl.insert(2);
                avl.insert(3);
                avl.insert(6);
                avl.insert(15);
                avl.insert(-2);
                avl.insert(-5);
                avl.insert(-8);*/
                /*avl.insert(20);
                avl.insert(15);
                avl.insert(25);
                avl.insert(10);
                avl.insert(18);
                avl.insert(-10);*/
                /*avl.insert(10);
                avl.insert(5);
                avl.insert(20);
                avl.insert(-10);
                avl.insert(-5);
                avl.inOrderTraversal();*/
        }
}
