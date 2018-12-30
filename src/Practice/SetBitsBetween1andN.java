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
public class SetBitsBetween1andN {
    
    private static int twopowNMinus1(int N) {
        int i = 0;
        while (true) {
            if (N >= Math.pow(2, i) - 1 && N <= Math.pow(2, i + 1) - 1) {
                return i;
            }
            i++;
        }
    }
    
    private static int get2powI(int N) {
        int i = 0;
        while (true) {
            if (N >= Math.pow(2, i) - 1 && N <= Math.pow(2, i + 1) - 1) {
                return (int)Math.pow(2, i);
            }
            i++;
        }
    }
    
    private static void getNOB(int N) {
        int totalbits = 0;
        while (N > 0) {
            int p = twopowNMinus1(N);
            int k = get2powI(N);
            totalbits += ((p * k) / 2 + ((N - k) + 1));
            N -= k;
        }
        System.out.println(totalbits);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        getNOB(N);
    }
}
