/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Stack;

import java.util.Arrays;

/**
 *
 * @author mankank
 */
class Stack {
    int[] stack;
    int top = 0;
    public Stack(int stack_size) {
        this.stack = new int[stack_size];
        Arrays.fill(stack, -1);
    }
    
    public void push(int data) {
        try {
            stack[top++] = data;
        } catch(Exception e) {
            System.out.println("Stack overflows.");
        }
    }
    
    public void pop() {
        if (top == 0) {
            System.out.println("stack empty to pop.");
            return;
        }
        top--;
        stack[top] = -1;
    }
    
    public int peak() {
        return stack[top - 1];
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public void traverseStack() {
        System.out.println("------------");
        for (int i = top-1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
        System.out.println("------------");
    }
    
    public void search(int data) {
        for (int i = top-1; i >= 0; i--) {
            if (stack[i] == data) {
                System.out.println("found " + data);
                return;
            }
        }
        System.out.println(data + " not found.");
    }
    
    public void reverseStack() {
        int i = 0; int j = top - 1;
        while (i <= j) {
            int temp = stack[i];
            stack[i++] = stack[j];
            stack[j--] = temp;
        }
    }
}
public class ArrayBasedStack {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        //System.out.println(stack.isEmpty());
        /*stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        //System.out.println(stack.isEmpty());
        //stack.push(6);
        stack.traverseStack();
        stack.pop();
        stack.traverseStack();
        stack.push(11);
        stack.traverseStack();
        stack.pop();
        stack.traverseStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(1);
        stack.traverseStack();
        stack.search(11);*/
        /*stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.traverseStack();
        stack.reverseStack();
        stack.traverseStack();*/
    }
}
