/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.LinkList;

/**
 *
 * @author mankank
 */

class $3LinkList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    
    Node head;
    public void insert(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            this.head = newnode;
            return;
        }
        Node traverse = this.head;
        while (traverse != null) {
            if (traverse.next == null) {
                traverse.next = newnode;
                return;
            }
            traverse = traverse.next;
        }
    }
    
    public void traverse() {
        Node traverse = this.head;
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.println();
    }
    
    public Node getNode(int data) {
        Node traverse = this.head;
        while (traverse != null) {
            if (traverse.data == data) {
                return traverse;
            }
            traverse = traverse.next;
        }
        return null;
    }
    
    public void deleteWithoutHeadPointer(Node node) {
        while (node != null) {
            node.data = node.next.data;
            if (node.next.next == null) {
                node.next = null;
            }
            node = node.next;
        }
    }
    
}

public class DeleteWithoutHeadPointer {
    public static void main(String[] args) {
        $3LinkList linklist = new $3LinkList();
        linklist.insert(6);
        linklist.insert(61);
        linklist.insert(12);
        linklist.insert(90);
        linklist.insert(45);
        linklist.insert(78);
        linklist.insert(2);
        linklist.insert(89);
        linklist.insert(4);
        linklist.insert(0);
        linklist.insert(93);
        linklist.traverse();
        $3LinkList.Node node = linklist.getNode(61);
        linklist.deleteWithoutHeadPointer(node);
        linklist.traverse();
    }
}
