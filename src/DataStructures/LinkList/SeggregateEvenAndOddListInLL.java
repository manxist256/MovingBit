/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.LinkList;

import java.util.ArrayList;

/**
 *
 * @author mankank
 */

class $8LinkList {
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
    
    public void seggregateOddEven() {
        Node traverse = this.head;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        while (traverse != null) {
            if (traverse.data % 2 != 0) {
                odd.add(traverse.data);
            } else {
                even.add(traverse.data);
            }
            traverse = traverse.next;
        }
        int i = 0; 
        Node traverse2 = this.head;
        while (i < even.size()) {
            traverse2.data = even.get(i++);
            traverse2 = traverse2.next;
        }
        i = 0;
        while (i < odd.size()) {
            traverse2.data = odd.get(i++);
            traverse2 = traverse2.next;
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

public class SeggregateEvenAndOddListInLL {
    public static void main(String[] args) {
        $8LinkList ll = new $8LinkList();
        ll.insert(17);
        ll.insert(15);
        ll.insert(8);
        ll.insert(12);
        ll.insert(10);
        ll.insert(5);
        ll.insert(4);
        ll.insert(1);
        ll.insert(7);
        ll.insert(6);
        ll.traverse();
        ll.seggregateOddEven();
        ll.traverse();
    }
}
