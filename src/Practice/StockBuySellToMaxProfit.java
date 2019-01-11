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
public class StockBuySellToMaxProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int j = 0; int bought = arr[0], max = bought, si = -1;
        for (int i = 0; i < N; i++) {
            if (arr[i] < bought || i == N - 1) { //sell in the window j --> i
                int rj = j;
                while (j++ < i) {
                    if (arr[j] > max) {
                        max = arr[j];
                        si = j;
                    }
                    
                }
                j -= 1;
                if (si != -1)
                    System.out.println("Buy on day : " + rj + " and sell on day " + si);
                bought = arr[j];
                max = bought;
                si = -1;
            }
        }
    }
}
