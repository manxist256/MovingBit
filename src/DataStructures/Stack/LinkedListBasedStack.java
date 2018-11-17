/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Stack;

/**
 *
 * @author mankank
 */

class StackEmptyException extends Exception {
    
}
class Node {
    int data;
    Node next;
    public Node (int data) {
        this.data = data;
    }
}
class LinkedList {
    Node head;
    public LinkedList() {
        this.head = null;
    }
    
    public void insertAtFirst(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            this.head = newnode;
        } else {
            newnode.next = this.head;
            this.head = newnode;
        }
    }
    
    public void deleteFirst () throws StackEmptyException {
        if (this.head == null) {
            throw new StackEmptyException();
        }
        this.head = this.head.next;
    }
    
    public int getHeadData() throws StackEmptyException {
        if (this.head == null) {
            throw new StackEmptyException();
        }
        return this.head.data;
    }
    
    public void traverseLL () {
        System.out.println("-----------");
        Node traverse = this.head;
        while (traverse != null) {
            System.out.println(traverse.data);
            traverse = traverse.next;
        }
        System.out.println("-----------");
    }
    
    public void reverseLL () {
        Node firstptr = this.head;
        Node secondptr = null;
        while (firstptr != null) {
            Node temp = firstptr.next;
            firstptr.next = secondptr;
            secondptr = firstptr;
            firstptr = temp;
        }
        this.head = secondptr;
    }
    
    public boolean searchDataRecursive(int data, Node node) {
        if (node != null && node.data == data) {
            return true;
        }
        if (node != null) {
            return searchDataRecursive(data, node.next);
        }
        return false;
    }
    
    
}
class LLStack {
    LinkedList stack;
    public LLStack() {
        this.stack = new LinkedList();
    }
    
    public void push(int data) {
        stack.insertAtFirst(data);
    }
    
    public void pop() { 
        try {
            stack.deleteFirst();
        } catch (StackEmptyException e) {
            System.out.println(e + " : Stack empty");
        }
    }
    
    public void peak() {
        try {
            int peak = stack.getHeadData();
            System.out.println("Peak : " + peak);
        } catch(StackEmptyException e) {
            System.out.println(e + " : Stack empty");
        }
    }
    
    public void traverseStack() {
        stack.traverseLL();
    }
    
    public void reverseStack() {
        stack.reverseLL();
    }
    
    public void search(int data) {
        boolean result = stack.searchDataRecursive(data, stack.head);
        if (result) {
            System.out.println(data + " found!");
        } else {
            System.out.println(data + " not found");
        }
    }
    
}
public class LinkedListBasedStack {
    public static void main(String[] args) {
        /*LLStack stack = new LLStack();
        stack.push(1);
        stack.push(2);
        stack.push(11);
        stack.push(94);
        stack.push(98);
        stack.push(17);
        stack.traverseStack();
        stack.peak();
        stack.reverseStack();
        stack.traverseStack();
        stack.peak();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.traverseStack();
        stack.pop();
        stack.pop();
        stack.pop();*/
    }
}
