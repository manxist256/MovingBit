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
public class RoundRobin {
    
        private static void roundRobin(ArrayList<Integer> roundRobin, int[] AT, int e) {
                for (int i = 0; i < AT.length; i++) {
                    if (AT[i] <= e && AT[i] != -1) {
                            AT[i] = -1;
                            roundRobin.add(i);
                    }
                }
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] AT = new int[N], BT = new int[N], ATCopy, BTCopy;
                int[] CT = new int[N], WT = new int[N], TAT = new int[N];
                for (int i = 0; i < N; i++) {
                        AT[i] = sc.nextInt();
                        BT[i] = sc.nextInt();
                }
                BTCopy = BT.clone(); ATCopy = AT.clone();
                int q = sc.nextInt();
                ArrayList<Integer> roundrobin = new ArrayList<>(); int e = 0;
                int[] LET = new int[N];
                do {
                        roundRobin(roundrobin, AT, 0);
                        int p = roundrobin.get(0); //process will always be at 0th index.
                        roundrobin.remove(0);
                        int rem_bt = BT[p];
                        if (rem_bt - q > 0) {
                                roundRobin(roundrobin, AT, e + q);
                                roundrobin.add(p);
                                BT[p] -= q;
                                WT[p] += (LET[p] != 0 ? e - LET[p] : e - ATCopy[p]);
                                LET[p] = e + q;
                                e += q;
                        } else if (BT[p] != -1){
                                roundRobin(roundrobin, AT, e + rem_bt);
                                CT[p] = e + rem_bt;
                                BT[p] = -1;
                                WT[p] += (LET[p] != 0 ? e - LET[p] : e - ATCopy[p]);
                                LET[p] = e + rem_bt;
                                e += rem_bt;
                        }
                } while(!roundrobin.isEmpty());
                for (int i = 0; i < N; i++) {
                        TAT[i] = BTCopy[i] + WT[i];
                }
                System.out.println("Process  BurstTime CompletionTime TAT WaitingTime");
                for (int i = 0; i < N; i++) {
                    System.out.println(i + "         " + BTCopy[i] + "           " + CT[i] + "         " + TAT[i] + "        "+WT[i]);
                }
        }
}
