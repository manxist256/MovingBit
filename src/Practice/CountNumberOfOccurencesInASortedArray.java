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
public class CountNumberOfOccurencesInASortedArray {
    
    private static int findcount(int[] sa, int low, int high, int x) {
        if (low == high && sa[low] == x) {
            return 1;
        } else if (sa[low] <= x && sa[high] >= x) {
            int mid = (low + high) / 2;
            int lc = findcount(sa, low, mid, x);
            int rc = findcount(sa, mid + 1, high, x);
            return lc + rc;
        } else {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] sa = new int[N];
        for (int i = 0; i < sa.length; i++) {
            sa[i] = sc.nextInt();
        }
        int count = findcount(sa, 0, sa.length - 1, sc.nextInt());
        System.out.println(count);
    }
}
