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
class $10LinkList {
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
            newnode.next = this.head;
            return;
        }
        if (data <= this.head.data) {
            newnode.next = this.head;
            Node traverse = this.head;
            while (traverse.next != this.head) {
                traverse = traverse.next;
            }
            traverse.next = newnode;
            this.head = newnode;
        } else {
            Node traverse = this.head;
            while (true) {
                if (data >= traverse.data && data <= traverse.next.data) {
                    Node temp = traverse.next;
                    traverse.next = newnode;
                    newnode.next = temp;
                    return;
                }
                if (traverse.data >= traverse.next.data && traverse.next == this.head) { // last element situation
                    traverse.next = newnode;
                    newnode.next = this.head;
                    //System.out.println(this.head.data + " " + newnode.data + " " + traverse.data);
                    return;
                }
                traverse = traverse.next;
            }
        }
    }
    
    public void traverse() {
        Node traverse = this.head;
        do {
            System.out.print(traverse.data + "->");
            traverse = traverse.next;
        } while(traverse != this.head);
    }
}

public class SortedInsertForCLL {
    public static void main(String[] args) {
        $10LinkList ll = new $10LinkList();
        ll.insert(30);
        ll.insert(32);
        ll.insert(31);
        ll.insert(64);
        ll.insert(128);
        ll.insert(69);
        ll.insert(132);
        ll.insert(56);
        ll.insert(5);
        ll.insert(134);
        ll.insert(1);
        ll.insert(58);
        ll.insert(-3);
        ll.traverse();
    }
}
