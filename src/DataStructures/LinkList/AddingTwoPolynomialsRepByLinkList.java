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

class $13LinkList {
    static class Node {
        int data;
        Node next;
        int coeff;
        public Node(int data, int coeff) {
            this.data = data;
            this.coeff = coeff;
        }
    }
    
    Node head;
    public void insert(int data, int coeff) {
        Node newnode = new Node(data, coeff);
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
    
    public static void addPolynomial($13LinkList p1, $13LinkList p2) {
        Node t1 = p1.head;
        Node t2 = p2.head;
        while (t1 != null && t2 != null) {
            if (t1.coeff == t2.coeff) {
                System.out.print(t1.data + t2.data + "x^" + t1.coeff + ((t1.next != null || t2.next != null) ? " + " : " "));
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.coeff > t2.coeff) {
                System.out.print(t1.data + "x^" + t1.coeff + " + ");
                t1 = t1.next;
            } else if (t1.coeff < t2.coeff) {
                System.out.print(t2.data + "x^" + t2.coeff + " + ");
                t2 = t2.next;
            }
        }
        while (t1 != null) {
            System.out.print(t1.data + "x^" + t1.coeff + (t1.next != null ? " + " : ""));
            t1 = t1.next;
        }
        while (t2 != null) {
            System.out.print(t2.data + "x^" + t2.coeff + (t2.next != null ? " + " : ""));
            t2 = t2.next;
        }
    }
    
}

public class AddingTwoPolynomialsRepByLinkList {
    public static void main(String[] args) {
        $13LinkList ll = new $13LinkList();
//        ll.insert(5, 2);
//        ll.insert(4, 1);
//        ll.insert(2, 0);
//ll.insert(5, 3);
//ll.insert(4, 2);
//ll.insert(2, 0);
//        $13LinkList ll2 = new $13LinkList();
////        ll2.insert(5, 1);
////        ll2.insert(5, 0);
//ll2.insert(5, 1);
//ll2.insert(5, 0);
//        $13LinkList.addPolynomial(ll, ll2);
    }
}
