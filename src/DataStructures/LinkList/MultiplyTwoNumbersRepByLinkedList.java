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

class $5LinkList {
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
    
    public void multiply($5LinkList anotherlist) {
        Node traverse = this.head;
        String number1 = "";
        while (traverse != null) {
            number1 = number1 + traverse.data;
            traverse = traverse.next;
        }
        int num1 = Integer.parseInt(number1);
        int i = 1, mul_res = 0;
        Node traverse2 = anotherlist.head;
        while (traverse2 != null) {
            mul_res += (num1 * traverse2.data * i);
            i *= 10;
            traverse2 = traverse2.next;
        }
        System.out.println(mul_res);
    }
}

public class MultiplyTwoNumbersRepByLinkedList {
    public static void main(String[] args) {
        $5LinkList l1 = new $5LinkList();
        l1.insert(9);
        l1.insert(4);
        l1.insert(6);
        $5LinkList l2 = new $5LinkList();
        l2.insert(8);
        l2.insert(4);
        l2.reverse();
        l1.multiply(l2);
    }
}
