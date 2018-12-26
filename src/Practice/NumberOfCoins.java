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
public class NumberOfCoins {
    
    private static void calcMinCoins(int[] coins, int v) {
        calcMinCoins(coins, v, 0, 0);
        System.out.println(min);
    }
    
    static int min = Integer.MAX_VALUE;
    
    private static void calcMinCoins(int[] coins, int v, int s, int d) {
        if (s > v || d >= min) {
            return;
        } else if (s == v) {
            if (min > d) {
                min = d;
            }
            return;
        }
        for (int i = 0; i < coins.length; i++) {
            calcMinCoins(coins, v, s + coins[i], d + 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int coins[] = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        int v = sc.nextInt();
        calcMinCoins(coins, v);
    }
}
