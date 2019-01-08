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

class $7LinkList {
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
    
    public void removeEveryKThNode(int k) {
        int cntr = 1;
        Node traverse = this.head;
        while (traverse != null) {
            if ((cntr + 1) % k == 0) {
                if (traverse.next != null)
                    traverse.next = traverse.next.next;
                cntr++;
                continue;
            }
            cntr++;
            traverse = traverse.next;
        }
    }
    
}

public class RemoveEveryKthNode {
    public static void main(String[] args) {
        $7LinkList ll = new $7LinkList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.insert(7);
        ll.insert(8);
        ll.insert(9);
        ll.insert(10);
        ll.insert(11);
        ll.insert(12);
        ll.insert(13);
        ll.insert(14);
        ll.insert(15);
        ll.insert(16);
        ll.insert(17);
        ll.insert(18);
        ll.insert(19);
        ll.insert(20);
        ll.insert(21);
        ll.traverse();
        ll.removeEveryKThNode(20);
        ll.traverse();
    }
}
