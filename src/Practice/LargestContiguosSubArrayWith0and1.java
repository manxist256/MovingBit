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
public class LargestContiguosSubArrayWith0and1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int s = 0;
        for (int i = 0; i < N; i++) {
            int oc = 0, zc = 0, k = 0;
            for (int j = i; j < N; j++) {
                if (arr[j] == 0) {
                    zc++;
                } else if (arr[j] == 1) {
                    oc++;
                }
                k = k + 1;
                if (oc == zc && k > s) {
                    s = k;
                }
            }
        }
        System.out.println(s);
    }
}
