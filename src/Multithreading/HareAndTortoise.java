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

class Race implements Runnable {
    
    static boolean complete;

    @Override
    public void run() {
            for (int i = 1; i <= 100; i++) {
                    if (!complete)
                            System.out.println(Thread.currentThread().getName() + " ran " + i + " metres");
                    else
                            break;
                    if (i == 100) {
                            System.out.println(Thread.currentThread().getName() + " won");
                            Race.complete = true;
                    }
            }
    }
        
}

public class HareAndTortoise {
        public static void main(String[] args) {
                Race hare = new Race();
                Race tortoise = new Race();
                Thread t1 = new Thread(hare, "hare");
                Thread t2 = new Thread(tortoise, "tortoise");
                t1.start(); t2.start();
        }
}
