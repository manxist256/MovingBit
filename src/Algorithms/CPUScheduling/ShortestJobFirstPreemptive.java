/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.CPUScheduling;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mankank
 */

class SRTF {
    
        int N;
    
        private void e(ArrayList<Integer> queue, int e, int[] AT) {
                for (int i = 0; i < AT.length; i++) {
                        if (AT[i] != -1 && AT[i] <= e) {
                                N++;
                                AT[i] = -1;
                                queue.add(i);
                        }
                }
        }
    
        private int getSJF(ArrayList<Integer> queue, int[] BT) {
                int min = Integer.MAX_VALUE, k = 0;
                for (int i : queue) {
                        if (BT[i] < min) {
                                min = BT[i];
                                k = i;
                        }
                }
                return k;
        }
    
        public void main () {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] AT = new int[N], BT = new int[N], CT = new int[N], WT = new int[N], TAT = new int[N];
                int bt_sum = 0;
                for (int i = 0; i < N; i++) {
                        AT[i] = sc.nextInt();
                        BT[i] = sc.nextInt();
                        bt_sum += BT[i];
                }
                int e = 0;
                int[] ATCopy = AT.clone(), BTCopy = BT.clone();
                ArrayList<Integer> queue = new ArrayList<>();
                int LET[] = new int[N];
                while (e < bt_sum) {
                        int t = 0;
                        if (this.N < N)
                                e(queue, e, AT);
                        int k = getSJF(queue, BT);
                        if (this.N < N) {
                                BT[k] -= 1;
                                if (LET[k] == 0) {
                                        WT[k] += e - ATCopy[k];
                                } else {
                                        WT[k] += e - LET[k];
                                }
                                LET[k] = e + 1;
                                if (BT[k] == 0) {
                                        queue.remove(Integer.valueOf(k));
                                }
                                CT[k] = e + 1;
                                e += 1;
                        } else {
                                t = BT[k];
                                BT[k] = 0;
                                if (LET[k] == 0) {
                                        WT[k] += e - ATCopy[k];
                                } else {
                                        WT[k] += e - LET[k];
                                }
                                queue.remove(Integer.valueOf(k));
                                CT[k] = e + t;
                                e += t;
                        }
                }
                for (int i = 0; i < N; i++) {
                        TAT[i] = WT[i] + BTCopy[i];
                }
                System.out.println("Process  BurstTime CompletionTime TAT WaitingTime");
                for (int i = 0; i < N; i++) {
                        System.out.println(i + "         " + BTCopy[i] + "           " + CT[i] + "         " + TAT[i] + "        "+WT[i]);
                } 
        }
}

public class ShortestJobFirstPreemptive {
        public static void main(String[] args) {
                new SRTF().main();
        }
}
