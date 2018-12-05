/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multithreading;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mankank
 */

class TThreadDL extends Thread {
    
        static ArrayList<Thread> threadGroup = new ArrayList();
    
        public TThreadDL(ThreadGroup gp, String name) {
                super(gp, name);
        }
    
        @Override
        public void run() {
                for (int i = 0; i < 5; i++) {
                        try {
                                Thread.sleep(3000);
                        } catch (InterruptedException ex) {
                                Logger.getLogger(TThread.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (Thread.currentThread().getName().equals("T1")) {
                                ThreadGroup group = Thread.currentThread().getThreadGroup();
                                for (Thread thread : threadGroup) {
                                        if (thread.getName().equals("T2")) {
                                                try {
                                                        thread.join(); // internally t2.join(); // then t1 waits until execution of t2 completes.
                                                } catch (InterruptedException ex) {
                                                        Logger.getLogger(TThread.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                break;
                                        }
                                }
                        }
                        if (Thread.currentThread().getName().equals("T2")) {
                                ThreadGroup group = Thread.currentThread().getThreadGroup();
                                for (Thread thread : threadGroup) {
                                        if (thread.getName().equals("T1")) {
                                                try {
                                                        thread.join(); // internally t1.join(); // then t2 waits until execution of t1 completes.
                                                } catch (InterruptedException ex) {
                                                        Logger.getLogger(TThread.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                break;
                                        }
                                }
                        }
                        // so both thread will keep on waiting until each other's completion. Hence the program will never stop because of deadlock situation.
                        System.out.println(Thread.currentThread().getName());
                }
        }
}

public class ThreadJoinDeadlock {
        public static void main(String[] args) {
               ThreadGroup group = new ThreadGroup("TG1");
               TThreadDL t1 = new TThreadDL(group, "T1"); 
               TThreadDL t2 = new TThreadDL(group, "T2");
               TThreadDL.threadGroup.add(t1);
               TThreadDL.threadGroup.add(t2);
               t1.start();
               t2.start();
        }
}
