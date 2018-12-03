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
// Experiment_2 ran for 31 seconds because it was executed asynchronously with 2 threads running parallely
// But Experiment_1 ran synchronouly and ran for 46 seconds
// Both experiments had same logic.
// With Threading
class ThreadExperiment extends Thread {
        @Override
        public void run() {
                String s = "";
                for (int i = 0; i < 100000; i++) {
                        s += i;
                        if (i == 99999) {
                                System.out.println(s);
                        }
                }
        }
}

public class Experiment_2 {
        public static void main(String[] args) {
                Thread t1 = new ThreadExperiment();
                t1.start();
                Thread t2 = new ThreadExperiment();
                t2.start();
        }
}
