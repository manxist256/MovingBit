
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround523;

/**
 *
 * @author mankank
 */
public class ViewsMatter {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt(); long m = sc.nextLong();
                long[] arr = new long[n]; long bc = 0; long min = Long.MAX_VALUE; long mx = 0;
                for (int i = 0; i < n; i++) {
                        arr[i] = sc.nextLong();
                        bc += arr[i];
                        if (arr[i] > mx) {
                                mx = arr[i];
                        }
                }
                Arrays.sort(arr);
                long p = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (p < arr[i]) {
                        p += 1;
                    }
                    bc -= 1;
                }
                if (p <= mx) {
                    bc -= (mx - p);
                    
                }
                System.out.println(bc);
        }
}
