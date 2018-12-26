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

class $2LinkList {
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
    
    public void deleteNNodesAfterMNodes(int N, int M) {
        Node traverse = this.head;
        while (M-- > 1 && traverse != null) {
            traverse = traverse.next;
        }
        while (N-- > 0 && traverse != null && traverse.next != null) {
            traverse.next = traverse.next.next;
        }
        if (M != 0 || N != -1) {
            System.out.println("could'nt perform operation properly");
        }
    }
    
}

public class DeleteNNodesAfterMNodes {
    public static void main(String[] args) {
        $2LinkList linklist = new $2LinkList();
        linklist.insert(6);
        linklist.insert(61);
        linklist.insert(12);
        linklist.insert(90);
        linklist.insert(45);
        linklist.insert(78);
        linklist.insert(2);
        linklist.insert(89);
        linklist.insert(4);
        linklist.insert(0);
        linklist.insert(93);
        linklist.traverse();
        linklist.deleteNNodesAfterMNodes(7, 5);
        linklist.traverse();
    }
}
