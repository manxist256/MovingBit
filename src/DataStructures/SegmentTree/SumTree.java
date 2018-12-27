/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.SegmentTree;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SumTree {
    
    private static int find2PowLogN(int N) {
        int i = 0;
        while (true) {
            if (N >= (int)Math.pow(2, i) && N <= (int)Math.pow(2, i + 1) - 1) {
                break;
            }
            i++;
        }
        return (int)Math.pow(2, i + 1) - 1;
    }
    
    private static void constructSumTree(int[] input, int[] sumtree, int N) {
        constructSumTree(input, sumtree, N, 0, input.length - 1, 0);
    }
    
    private static int constructSumTree(int[] input, int[] sumtree, int N, int low, int high, int pos) {
        if (low == high) {
            sumtree[pos] = input[low];
            return sumtree[pos];
        }
        int mid = (low + high) / 2;
        int l = constructSumTree(input, sumtree, N, low, mid, 2 * pos + 1);
        int r = constructSumTree(input, sumtree, N, mid + 1, high, 2 * pos + 2);
        sumtree[pos] = l + r;
        return 2 * (sumtree[pos]);
    }
    
    private static void validateSumTree(int[] sumtree, int N) {
        System.out.println(validateSumTree(sumtree, N, 0, N - 1, 0));
    }
    
    private static boolean validateSumTree(int[] sumtree, int N, int low, int high, int pos) {
        if (low == high) {
            return true;
        }
        int mid = (low + high) / 2;
        boolean l = validateSumTree(sumtree, N, low, mid, 2 * pos + 1);
        boolean r = validateSumTree(sumtree, N, mid + 1, high, 2 * pos + 2);
        if (!(l && r)) {
            return l && r;
        }
        int l_sum = sumtree[2 * pos + 1], r_sum = sumtree[2 * pos + 2];
        if (low != mid) {
            l_sum *= 2;
        }
        if (mid + 1 != high) {
            r_sum *= 2;
        }
        return sumtree[pos] == l_sum + r_sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }
        int[] sumtree = new int[find2PowLogN(2 * N - 1)];

        constructSumTree(input, sumtree, N);
        for (int i = 0; i < sumtree.length; i++) {
            System.out.print(sumtree[i] + " ");
        }
        validateSumTree(sumtree, N);
    }
}
