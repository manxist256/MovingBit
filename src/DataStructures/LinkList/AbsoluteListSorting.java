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
class $1LinkList {
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
    
    public void sort() {
        Node traverse = this.head;
        while (traverse != null) {
            Node traverse_ = traverse;
            Node sn = traverse;
            while (traverse_ != null) {
                if (sn.data > traverse_.data) {
                    sn = traverse_;
                }
                traverse_ = traverse_.next;
            }
            int data = traverse.data;
            traverse.data = sn.data;
            sn.data = data;
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
}
public class AbsoluteListSorting {
    public static void main(String[] args) {
        $1LinkList ll = new $1LinkList();
        ll.insert(5);
        ll.insert(55); 
        ll.insert(-12);
        ll.insert(67);
        ll.insert(-1);
        ll.insert(0);
        ll.insert(46);
        ll.insert(-256);
        ll.traverse();
        ll.sort();
        ll.traverse();
    }
}
