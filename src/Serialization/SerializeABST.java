/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author mankank
 */

class BST$0 implements Serializable{
    class Node implements Serializable {
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
    
    public void inOrder() {
        this.inOrder(this.root);
    }
    
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data + " " + (node.left != null ? node.left.data : null) + " " + (node.right != null ? node.right.data : null));
            inOrder(node.right);
        }
    }
    
    
}

public class SerializeABST {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        BST$0 bst = new BST$0();
        bst.insert(1000);
        bst.insert(500);
        bst.insert(1500);
        bst.insert(1200);
        bst.insert(1750);
        bst.inOrder();
        System.out.println();
        FileOutputStream fos = new FileOutputStream("binaryfile.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bst);
        FileInputStream fis = new FileInputStream("binaryfile.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        BST$0 readbst = (BST$0)ois.readObject();
        readbst.inOrder();
    }
}
