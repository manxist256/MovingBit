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

class $4LinkList {
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
    
    public void reverse() {
        Node sp = null, fp = this.head;
        while (fp != null) {
            Node temp = fp.next;
            fp.next = sp;
            sp = fp;
            fp = temp;
        }
        this.head = sp;
    }
    
    public void traverse() {
        Node traverse = this.head;
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.println();
    }
    
    public void add($4LinkList l2) {
        String result = "";
        Node p1 = this.head, p2 = l2.head;
        int C = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.data + p2.data + C;
            result = (sum % 10) + result;
            if (sum > 9) {
                C = 1;
            } else {
                C = 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            int sum = p1.data + C;
            result = (sum % 10) + result;
            if (sum > 9) {
                C = 1;
            } else {
                C = 0;
            }
            p1 = p1.next;
        }
        while (p2 != null) {
            int sum = p2.data + C;
            result = (sum % 10) + result;
            if (sum > 9) {
                C = 1;
            } else {
                C = 0;
            }
            p2 = p2.next;
        }
        if (C == 1) result = 1 + result;
        System.out.println(result);
    }
    
}

public class AddTwoNumbersRepresentedByLL {
    public static void main(String[] args) {
        $4LinkList l1 = new $4LinkList();
        l1.insert(7);
        l1.insert(5);
        l1.insert(9);
        l1.insert(4);
        l1.insert(6);
        $4LinkList l2 = new $4LinkList();
        l2.insert(8);
        l2.insert(4);
        l1.reverse();
        l2.reverse();
//        l1.traverse();
//        l2.traverse();
        l2.add(l1);
    }
}
