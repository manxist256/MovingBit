/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class MaxSumOfLengthsOfNonOverlappingSAWithKAsMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int si = 0, sj = 0; boolean vs = false;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == K) {
                vs = true;
            }
            if (arr[i] > K || i == N - 1) { //delimiter found
                if (vs) {
                    ans += ((sj - si) + 1);
                    ans += (i == N - 1 ? 1 : 0);
                }
                si = i + 1;
                vs = false;
                continue;
            }
            sj = i;
        }
        System.out.println(ans);
    }
}
