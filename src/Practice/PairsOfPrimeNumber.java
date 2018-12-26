/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class PairsOfPrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> prime = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean p = true;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    p = false;
                }
            }
            if (p) prime.add(i);
            if (i % 2 != 0) {
                i += 1;
            }
        }
        //System.out.println(prime);
        for (int i = 1; i <= N; i++) {
            for (int j= i + 1; j <= N; j++) {
                if (prime.contains(i + j)) {
                    System.out.println("(" + i + "," + j + "),");
                }
            }
        }
    }
}
