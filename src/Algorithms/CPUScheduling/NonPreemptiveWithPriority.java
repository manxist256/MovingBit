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
public class NonPreemptiveWithPriority {
    
        private static void e(ArrayList<Integer> queue, int e, int[] AT) {
                for (int i = 0; i < AT.length; i++) {
                        if (AT[i] != -1 && AT[i] <= e) {
                                AT[i] = -1;
                                queue.add(i);
                        }
                }
        }
        
        private static int getHigherPriorityJob(ArrayList<Integer> queue, int[] priority) {
                int hpjob = 0, max = 0;
                for (int k : queue) {
                        if (priority[k] > max) {
                                max = priority[k];
                                hpjob = k;
                        }
                }
                return hpjob;
        }
        
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] priority = new int[N];
                int[] AT = new int[N], BT = new int[N], ATCopy, BTCopy;
                int[] CT = new int[N], WT = new int[N], TAT = new int[N];
                for (int i = 0; i < N; i++) {
                        priority[i] = sc.nextInt();
                        AT[i] = sc.nextInt();
                        BT[i] = sc.nextInt();
                }
                BTCopy = BT.clone(); ATCopy = AT.clone();
                int e = 0, s = 0;
                ArrayList<Integer> queue = new ArrayList<>();
                while (s < N) {
                        e(queue, e, AT);
                        int k = getHigherPriorityJob(queue, priority);
                        CT[k] = e + BTCopy[k];
                        WT[k] = e - ATCopy[k];
                        queue.remove(Integer.valueOf(k));
                        e += BTCopy[k];
                        s++;
                }
                for (int i = 0; i < N; i++) {
                        TAT[i] = WT[i] + BT[i];
                }
                System.out.println("Process  BurstTime CompletionTime TAT WaitingTime");
                for (int i = 0; i < N; i++) {
                        System.out.println(i + "         " + BTCopy[i] + "           " + CT[i] + "         " + TAT[i] + "        "+WT[i]);
                }
        }
}
