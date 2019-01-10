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
public class FindZeroesToBeFlippedSuchThatConsecutive1sMaxed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int zc = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) zc++;
        }
        int K = sc.nextInt(), KS = K, ptr = 0;
        if (zc <= K) { System.out.println(N); return; }
        int max = 0, c = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 1) {
                c++;
            }
            else if (arr[i] == 0 && K > 0) {
                K--;
            }
            else if (arr[i] == 0 && K == 0) {
                while (arr[ptr++] == 1) {
                    c--;
                }
                continue;
            }
            if (c > max) {
                max = c;
            }
        }
        System.out.println(max + KS);
    }
}
