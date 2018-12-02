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

class T extends Thread {
        int[] prime = new int[20];
        @Override
        public void run() {
                int i = 2, l = 0;
                while (l < 20) {
                        boolean p = true;
                        for (int j = 2; j < i / 2; j++) {
                                if (i % j == 0) {
                                        p = false;
                                        break;
                                }
                        }
                        if (p) {
                                prime[l++] = i;
                        }
                        if (i == 2)
                                i += 1;
                        else 
                                i += 2;
                }
        }
}

public class IndependentTasks {
        public static void main(String[] args) {
                T t = new T();
                t.start();
                //fibonacci
                int n = 20, f = 0, s = 1, i = 2;
                int fibo[] = new int[n];
                n -= 2;
                fibo[0] = f; fibo[1] = s;
                while (n-- > 0) {
                        fibo[i] = f + s;
                        f = s;
                        s = fibo[i++];
                }
                //print fibo
                for (int k = 0; k < 20; k++) {
                        System.out.print(fibo[k] + " ");
                }
                System.out.println();
                //print prime
                for (int k = 0; k < t.prime.length; k++) {
                        System.out.print(t.prime[k] + " ");
                }
        }
}
