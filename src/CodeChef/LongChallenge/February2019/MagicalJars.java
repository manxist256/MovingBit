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
class MagicalJars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            long[] a = new long[N];
            long c = 0;
            for (int i = 0; i < N; i++) {
                a[i] = sc.nextInt();
                c += a[i];
            }
            System.out.println(c - (N - 1));
        }
    }
}
