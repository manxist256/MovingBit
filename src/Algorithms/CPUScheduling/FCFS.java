/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.CPUScheduling;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class FCFS {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] burst_time = new int[N]; int s = 0;
                int[] service_time = new int[N];
                int[] completion_time = new int[N];
                for (int i = 0; i < N; i++) {
                        service_time[i] = s;
                        burst_time[i] = sc.nextInt();
                        s += burst_time[i];
                        completion_time[i] = s;
                }
                System.out.println("Process   BurstTime ServiceTime CompletionTime");
                for (int i = 0; i < service_time.length; i++) {
                        System.out.println(i + "         " + burst_time[i] + "         " + service_time[i] + "           " + completion_time[i]);
                }
        }
}
