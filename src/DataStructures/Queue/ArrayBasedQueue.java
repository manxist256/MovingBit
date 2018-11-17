/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Queue;

//import java.util.Scanner;

import java.util.Arrays;


/**
 *
 * @author mankank
 */

class Queue { 
    int[] queue;
    int front;
    int rear;
    
    public Queue(int queue_size) {
        this.queue = new int[queue_size];
    }
    
    public void enQueue(int data) {
        try {
            queue[rear++] = data;
        } catch(Exception e) {
            System.out.println("Queue full!");
        }
    }
    
    public void deQueue() {
        if (rear == 0) {
            System.out.println("Queue empty!");
            return;
        }
        front++;
        if (front == rear) {
            resetQueue();
        } 
    }
    
    private void resetQueue() {
        this.front = 0;
        this.rear = 0;
        Arrays.fill(queue, 0);
    }
    
    public void displayQueue() {
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    
    public void queueSize() {
        System.out.println(rear - front);
    }
    
    public void getFront() {
        System.out.println(queue[front]);
    }
}

public class ArrayBasedQueue {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        Queue queue = new Queue(5);
        queue.enQueue(1);
        queue.enQueue(45);
        queue.displayQueue();
        queue.queueSize();
        /*queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.displayQueue();
        /*queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();*/
        //queue.displayQueue();*/
        //queue.getFront();
        
    }
}
