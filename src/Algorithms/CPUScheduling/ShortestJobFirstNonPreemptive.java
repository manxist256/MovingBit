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
public class ShortestJobFirstNonPreemptive {
    
        private static void e(ArrayList<Integer> queue, int e, int[] AT) {
                for (int i = 0; i < AT.length; i++) {
                        if (AT[i] != -1 && AT[i] <= e) {
                                AT[i] = -1;
                                queue.add(i);
                        }
                }
        }
        
        private static int getSJF(ArrayList<Integer> queue, int[] BT) {
                int min = Integer.MAX_VALUE, k = 0;
                for (int i : queue) {
                        if (BT[i] <= min) {
                                min = BT[i];
                                k = i;
                        }
                }
                return k;
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] AT = new int[N], BT = new int[N], CT = new int[N], WT = new int[N], TAT = new int[N];
                for (int i = 0; i < N; i++) {
                        AT[i] = sc.nextInt();
                        BT[i] = sc.nextInt();
                }
                int e = 0, s = 0;
                int[] ATCopy = AT.clone(), BTCopy = BT.clone();
                ArrayList<Integer> queue = new ArrayList<>();
                while (s < N) {
                        e(queue, e, AT);
                        if (!queue.isEmpty()) {
                            int k = getSJF(queue, BT);
                            CT[k] = e + BTCopy[k];
                            WT[k] = e - ATCopy[k];
                            e += BTCopy[k];
                            queue.remove(Integer.valueOf(k));
                            s++;
                            continue;
                        } e++;
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
