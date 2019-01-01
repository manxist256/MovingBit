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
public class CountNumbersWithSameFirstAndLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 10) {
            System.out.println(n);
        } else {
            int a = 9 + (n - 10) / 10;
            System.out.println((String.valueOf(n).charAt(0) - 48) <= n % 10 ? a + 1 : a);
        }
    }
}
