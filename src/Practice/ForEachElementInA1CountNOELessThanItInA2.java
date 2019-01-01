/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class ForEachElementInA1CountNOELessThanItInA2 {
    
    private static int binarysearch(int x, int[] arr, int low, int high) {
        if (arr[high] <= x) {
            return (high - low) + 1;
        } else if (arr[low] > x) {
            return 0;
        }
        int mid = (low + high) / 2;
        int lc = binarysearch(x, arr, low, mid);
        int rc = binarysearch(x, arr, mid + 1, high);
        return lc + rc;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int[] a1 = new int[N], a2 = new int[M];
        for (int i = 0; i < N; i++) {
            a1[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            a2[i] = sc.nextInt();
        }
        Arrays.sort(a2);
        for (int i = 0; i < a1.length; i++) {
            int count = binarysearch(a1[i], a2, 0, a2.length - 1);
            System.out.print(count + " ");
        }
    }
}
