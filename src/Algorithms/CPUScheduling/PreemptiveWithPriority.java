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
public class PreemptiveWithPriority {

        static int N;
    
        private static void e(ArrayList<Integer> queue, int e, int[] AT) {
                for (int i = 0; i < AT.length; i++) {
                        if (AT[i] != -1 && AT[i] <= e) {
                                N++;
                                AT[i] = -1;
                                queue.add(i);
                        }
                }
        }
    
        private static int getJobWithHigherPriority(ArrayList<Integer> queue, int[] priority) {
                int hpjob = 0, max = 0;
                for (int i : queue) {
                        if (priority[i] > max) {
                                max = priority[i];
                                hpjob = i;
                        }
                }
                return hpjob;
        }
    
        public static void main (String... args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] priority = new int[N];
                int[] AT = new int[N], BT = new int[N], CT = new int[N], WT = new int[N], TAT = new int[N], RT = new int[N];
                int bt_sum = 0;
                for (int i = 0; i < N; i++) {
                        priority[i] = sc.nextInt();
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
                        if (PreemptiveWithPriority.N < N)
                                e(queue, e, AT);
                        int k = getJobWithHigherPriority(queue, priority);
                        if (PreemptiveWithPriority.N < N) {
                                BT[k] -= 1;
                                if (LET[k] == 0) {
                                        WT[k] += e - ATCopy[k];
                                        RT[k] = e - ATCopy[k];
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
                                        RT[k] = e - ATCopy[k];
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
                System.out.println("Process  BurstTime CompletionTime TAT WaitingTime ResponseTime");
                for (int i = 0; i < N; i++) {
                        System.out.println(i + "         " + BTCopy[i] + "           " + CT[i] + "         " + TAT[i] + "        "+WT[i] + "         "+RT[i]);
                } 
        }
}
