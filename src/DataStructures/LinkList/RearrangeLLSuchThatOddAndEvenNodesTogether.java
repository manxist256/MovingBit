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

class $6LinkList {
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
    
    public void rearrange() {
        Node traverse = this.head;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        int i = 1;
        while (traverse != null) {
            if (i % 2 != 0) {
                odd.add(traverse.data);
            } else {
                even.add(traverse.data);
            }
            i++;
            traverse = traverse.next;
        }
        Node mt = this.head;
        int ptr = 0;
        while (mt != null && ptr < odd.size()) {
            mt.data = odd.get(ptr++);
            mt = mt.next;
        }
        ptr = 0;
        while (mt != null && ptr < even.size()) {
            mt.data = even.get(ptr++);
            mt = mt.next;
        }
    }
}

public class RearrangeLLSuchThatOddAndEvenNodesTogether {
    public static void main(String[] args) {
        $6LinkList ll = new $6LinkList();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);
        ll.insert(6);
        ll.insert(7);
        ll.traverse();
        ll.rearrange();
        ll.traverse();
    }
}
