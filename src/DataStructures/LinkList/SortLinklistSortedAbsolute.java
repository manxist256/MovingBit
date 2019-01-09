/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.LinkList;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author mankank
 */

class $9LinkList {
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
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        Node traverse = this.head;
        while (traverse != null) {
            if (traverse.data >= 0) {
                list.add(traverse.data);
            } else {
                stack.push(traverse.data);
            }
            traverse = traverse.next;
        }
        int ls = list.size();
        traverse = this.head;
        while (!stack.isEmpty()) {
            traverse.data = stack.pop();
            traverse = traverse.next;
        }
        int i = 0;
        while (i < ls) {
            traverse.data = list.get(i++);
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

public class SortLinklistSortedAbsolute {
    public static void main(String[] args) {
        $9LinkList ll = new $9LinkList();
        ll.insert(1);
        ll.insert(-2);
        ll.insert(-3);
        ll.insert(4);
        ll.insert(-5);
        ll.traverse();
        ll.sort();
        ll.traverse();
    }
}
