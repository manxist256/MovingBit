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

class Print_ implements Runnable {
        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                        System.out.println("Executing m2");
                }
        }
}

public class ImplementingAThread {
        public static void main(String[] args) {
                Print_ print = new Print_();
                Thread t = new Thread(print);
                t.start();
                for (int i = 0; i < 10; i++) {
                        System.out.println("Main method");
                }
        }
}
