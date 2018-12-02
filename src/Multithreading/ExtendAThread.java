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

class Print extends Thread {
        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("Executing m1");
                }
        }
}

public class ExtendAThread {
        public static void main(String[] args) {
                Print print = new Print();
                print.start();
                for (int i = 0; i < 10; i++) {
                        System.out.println("Main method");
                }
                System.out.println(print.getName()); // return's the thread name {Thread-0}
                System.out.println(Thread.currentThread().getName()); // return's the main thread name {main}
        }
}
