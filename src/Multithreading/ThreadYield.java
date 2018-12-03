/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multithreading;

/**
 *
 * @author mankank
 */

class YThread extends Thread {
    
        public YThread(String name) {
                super(name);
        }
    
        @Override
        public void run() {
                for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        if (Thread.currentThread().getName().equals("T1")) {
                                Thread.yield(); //yields the current executing thread and moves to waiting state
                        }
                }
        }
}

public class ThreadYield {
        public static void main(String[] args) {
                YThread t1 = new YThread("T1");
                YThread t2 = new YThread("T2");
                YThread t3 = new YThread("T3");
                t1.start();
                t2.start();
                t3.start();
        }
}
