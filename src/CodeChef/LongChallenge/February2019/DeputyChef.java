/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.February2019;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class DeputyChef {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] a = new int[N];
            int[] d = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < N; i++) {
                d[i] = sc.nextInt();
            }
            int md = -1;
            for (int i = 0; i < N; i++) {
                if (i == 0) { //compare last and second
                    if (d[i] > (a[1] + a[N - 1])) { //survives
                        if (md < d[i]) {
                            md = d[i];
                        }
                    }
                } else if (i == N - 1) { //compare second last and first
                    if (d[i] > (a[N - 2] + a[0])) { //survives
                        if (md < d[i]) {
                            md = d[i];
                        }
                    }
                } else { //compare left and right
                    if (d[i] > (a[i - 1] + a[i + 1])) { //survives
                        if (md < d[i]) {
                            md = d[i];
                        }
                    }
                }
            }
            System.out.println(md);
        }
    }
}
