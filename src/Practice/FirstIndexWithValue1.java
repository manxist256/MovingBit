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
public class FirstIndexWithValue1 {
    private static int findcount(int[] sa, int low, int high) {
        if (low == high && sa[low] == 1) {
            return low;
        } else if (sa[low] <= 1 && sa[high] >= 1) {
            int mid = (low + high) / 2;
            int lc = findcount(sa, low, mid);
            int rc = findcount(sa, mid + 1, high);
            return lc > rc ? rc : lc;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sa = new int[N];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sc.nextInt();
        }
        int count = findcount(sa, 0, sa.length - 1);
        System.out.println(count == Integer.MAX_VALUE ? -1 : count);
    }
}
