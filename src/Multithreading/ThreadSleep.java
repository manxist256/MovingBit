/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mankank
 */

class SThread extends Thread {

        public SThread(String name) {
                super(name);
        }
    
        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                        if (Thread.currentThread().getName().equals("T1")) {
                            try {
                                Thread.sleep(2000); //sleeps the current executing thread {name : T1} and moves to waiting state for 2 secs
                                // Thread.sleep immediately captures the current executing thread and put only that thread to sleep.
                                //Thread.currentThread().interrupt();
                            } catch (InterruptedException ex) {
                                Logger.getLogger(SThread.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + " " + i);
                }
        }
}

public class ThreadSleep {
        public static void main(String[] args) {
                SThread t1 = new SThread("T1");
                SThread t2 = new SThread("T2");
                SThread t3 = new SThread("T3");
                t1.start();
                t2.start();
                t3.start();
        }
}
