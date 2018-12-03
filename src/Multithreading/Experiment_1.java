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
// Without Threading
public class Experiment_1 {
        public static void main(String[] args) {
                long st = System.currentTimeMillis();
                String s_1 = "";
                for (int i = 0; i < 100000; i++) {
                        s_1 += i;
                }
                System.out.println(s_1);
                String s_2 = "";
                for (int i = 0; i < 100000; i++) {
                        s_2 += i;
                }
                System.out.println(s_2);
                long et = System.currentTimeMillis();
                System.out.println((et - st) / 1000);
        }
}
