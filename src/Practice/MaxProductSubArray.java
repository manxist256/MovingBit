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
public class MaxProductSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0, curr = 1, ptr = 0, nc = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] < 0) nc++;
            if (arr[i] != 0)
                curr *= arr[i];
            if (curr > max) max = curr;
            if ((arr[i] == 0 || i == N - 1)) { //consider end-of sub-array
                if (nc % 2 != 0) { //odd number of -ve's in multiplication results in -ve value
                    while (arr[ptr] > 0) {
                        curr /= arr[ptr];
                        ptr++;
                    }
                    curr /= arr[ptr];
                    if (curr > max) max = curr;
                }
                curr = 1;
                ptr = i + 1;
                nc = 0;
            } 
        }
        System.out.println(max);
    }
}
