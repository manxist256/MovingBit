/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.January2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mankank
 */
class DistinctPairs {
    
    private static void mergeSort(int[] a, int low, int high, int[] dom) {
        if (low == high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(a, low, mid, dom);
        mergeSort(a, mid + 1, high, dom);
        int lc = (mid - low) + 1; int rc = (high - mid);
        int[] l_a = new int[lc], r_a = new int[rc];
        int[] d_lc = new int[lc], d_rc = new int[rc];
        int ii = low, jj = mid + 1;
        for (int i = 0; i < lc; i++) {
            l_a[i] = a[ii];
            d_lc[i] = dom[ii];
            ii++;
        }
        for (int i = 0; i < rc; i++) {
            r_a[i] = a[jj];
            d_rc[i] = dom[jj];
            jj++;
        }
        int p1 = 0, p2 = 0, k = low;
        while (p1 < lc && p2 < rc) {
            if (l_a[p1] < r_a[p2]) {
                a[k] = l_a[p1];
                dom[k] = d_lc[p1];
                p1++;
                k++;
            } else if (l_a[p1] > r_a[p2]) {
                a[k] = r_a[p2];
                dom[k] = d_rc[p2];
                p2++;
                k++;
            } else {
                a[k] = l_a[p1];
                dom[k] = d_lc[p1];
                k++;
                a[k] = r_a[p2];
                dom[k] = d_rc[p2];
                k++;
                p1++;
                p2++;
            }
        }
        while (p1 < l_a.length) {
            a[k] = l_a[p1];
            dom[k] = d_lc[p1];
            k++;
            p1++;
        }
        while (p2 < r_a.length) {
            a[k] = r_a[p2];
            dom[k] = d_rc[p2];
            k++;
            p2++;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm[] = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
        int[] a1 = new int[n], a2 = new int[m];
        int[] ai1 = new int[n], ai2 = new int[m];
        int maxV = Integer.MIN_VALUE, maxI = 0;
        int minV = Integer.MAX_VALUE, minI = 0;
        String a1s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a1[i] = Integer.parseInt(a1s[i]);
            ai1[i] = i;
        }
        String a2s[] = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            a2[i] = Integer.parseInt(a2s[i]);
            ai2[i] = i;
        }
        mergeSort(a1, 0, a1.length - 1, ai1);
        mergeSort(a2, 0, a2.length - 1, ai2);
        for (int i = 0; i < n; i++) {
            System.out.println(ai1[i] + " " + ai2[0]);
        }
        int z = a1.length - 1;
        for (int i = 1; i < m; i++) {
            System.out.println(ai1[z] + " " + ai2[i]);
        }
    }
}
