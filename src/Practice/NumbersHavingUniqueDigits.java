/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class NumbersHavingUniqueDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt(), e = sc.nextInt();
        for (int i = s; i <= e; i++) {
            int num = i, length = String.valueOf(num).length();
            HashSet<Integer> distinct = new HashSet<>();
            while (num > 0) {
                distinct.add(num % 10);
                num /= 10;
            }
            if (length == distinct.size()) {
                System.out.print(i + " ");
            }
        }
    }
}
