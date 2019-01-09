/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.LinkList;

import java.util.HashSet;

/**
 *
 * @author mankank
 */

class $11LinkList {
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
    
    public static $11LinkList getUnion($11LinkList ll1, $11LinkList ll2) {
        $11LinkList ll3 = new $11LinkList();
        Node traverse = ll1.head;
        HashSet<Integer> set = new HashSet<>();
        while (traverse != null) {
            set.add(traverse.data);
            traverse = traverse.next;
        }
        traverse = ll2.head;
        while (traverse != null) {
            set.add(traverse.data);
            traverse = traverse.next;
        }
        for (int data : set) {
            ll3.insert(data);
        }
        return ll3;
    }
    
}

public class UnionOfTwoLL {
    public static void main(String[] args) {
        $11LinkList ll1 = new $11LinkList();
        ll1.insert(10);
        ll1.insert(15);
        ll1.insert(4);
        ll1.insert(20);
        $11LinkList ll2 = new $11LinkList();
        ll2.insert(8);
        ll2.insert(4);
        ll2.insert(2);
        ll2.insert(10);
        ll1.traverse();
        ll2.traverse();
        $11LinkList ll3 = $11LinkList.getUnion(ll1, ll2);
        ll3.traverse();
    }
}
