/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class KadanesAlgorithm {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                int c = 0, max = 0; int ri = 0, rj = 0, ci = 0, cj = 0;
                for (int i = 0; i < N; i++) {
                        c += arr[i];
                        if (c < 0) {
                                c = 0;
                                continue;
                        } else if (c == arr[i]) {
                                ci = i;
                        }
                        cj = i;
                        if (c > max) {
                                ri = ci;
                                rj = cj;
                                max = c;
                        }
                }
                System.out.println("Max is : " + max + " from index " + ri + " to " + rj);
        }
}
