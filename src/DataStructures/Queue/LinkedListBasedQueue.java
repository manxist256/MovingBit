/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Queue;

/**
 *
 * @author mankank
 */

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node last, head;
    public LinkedList() {
        this.last = null;
        this.head = null;
    }
    
    public void insertAtLast(int data) {
        Node newnode = new Node(data);
        if (this.last == null) {
            this.last = newnode;
            this.head = newnode;
            return;
        }
        last.next = newnode;
        last = newnode;
    }
    
    public void deleteAtFirst() throws Exception {
        if (this.head == null) {
            throw new Exception();
        }
        this.head = head.next;
        if (this.head == null) {
            this.last = null;
        }
    }
    
    public int getHead() throws Exception {
        if (this.head == null) {
            throw new Exception();
        }
        return this.head.data;
    }
    
    public void traverse() {
        Node traverse = this.head;
        while (traverse != null) {
            System.out.print(traverse.data + " ");
            traverse = traverse.next;
        }
        System.out.println();
    }
 
    public int getLLSize() {
        int size = 0;
        Node traverse = this.head;
        while (traverse != null) {
            size++;
            traverse = traverse.next;
        }
        return size;
    }
    
}

class LLQueue {
    LinkedList queue;
    
    public LLQueue() {
        this.queue = new LinkedList();
    }
    
    public void enQueue(int data) {
        this.queue.insertAtLast(data);
    }
    
    public void deQueue() {
        try {
            this.queue.deleteAtFirst();
        } catch(Exception e) {
            System.out.println("Queue empty");
        }
    }
    
    public void getFront() {
        try {
            int head = this.queue.getHead();
            System.out.println(head + " : HEAD");
        } catch(Exception e) {
            System.out.println("Queue empty!");
        }
    }
    
    public void displayQueue() {
        this.queue.traverse();
    }
    
    public void queueSize() {
        int size = this.queue.getLLSize();
        System.out.println(size + " : Size");
    }
    
}

public class LinkedListBasedQueue {
    public static void main(String[] args) {
        LLQueue queue = new LLQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.queueSize();
        queue.displayQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.displayQueue();
        queue.enQueue(45);
        queue.enQueue(93);
        queue.displayQueue();
        queue.queueSize();
        queue.getFront();
    }
}
