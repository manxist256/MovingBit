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
public class PositionOfRightmostSetBit {
    
    private static int twoPow(int N) {
        int i = 0;
        while (true) {
            if (N > (int)Math.pow(2, i) - 1 && N < (int)Math.pow(2, i + 1)) {
                return i + 1;
            }
            i++;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = twoPow(N);
        for (int i = 0; i < m; i++) {
            if ((N & (1 << i)) > 0) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
