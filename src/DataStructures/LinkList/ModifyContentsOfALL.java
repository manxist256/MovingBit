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

class $12LinkList {
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
    
    public void modifyLL() {
        Node fp = this.head;
        Node sp = this.head;
        int l = 0;
        while (fp.next != null) {
            fp = fp.next.next;
            if (fp == null) {
                l += 1;
                break;
            }
            sp = sp.next;
            l++;
        }
        fp = sp.next;
        sp.next = null;
        while (fp != null) {
            Node temp = fp.next;
            fp.next = sp;
            sp = fp;
            fp = temp;
        }
        Node ln = sp;
        Node fn = this.head;
        while (l-- > 0) {
            fn.data -= ln.data; 
            fn = fn.next;
            ln = ln.next;
        }
    }
    
}

public class ModifyContentsOfALL {
    public static void main(String[] args) {
//        $12LinkList ll = new $12LinkList();
//        ll.insert(10);
//        ll.insert(4);
//        ll.insert(5);
//        ll.insert(3);
//        ll.insert(6);
//        ll.traverse();
//        ll.modifyLL();
//        ll.traverse();
        $12LinkList ll2 = new $12LinkList();
        ll2.insert(2);
        ll2.insert(9);
        ll2.insert(8);
        ll2.insert(12);
        ll2.insert(7);
        ll2.insert(10);
        ll2.traverse();
        ll2.modifyLL();
        ll2.traverse();
    }
}
