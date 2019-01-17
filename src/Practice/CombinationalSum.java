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
public class CombinationalSum {
    
    private static void combinationalSum(int[] arr, int X, String s, int cs, int pos) {
        if (cs >= X) {
            if (cs == X)
                System.out.println(s);
            return;
        }
        for (int i = pos; i < arr.length; i++) {
            combinationalSum(arr, X, s + arr[i], cs + arr[i], i);
            
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        combinationalSum(arr, sc.nextInt(), "", 0, 0);
    }
}
