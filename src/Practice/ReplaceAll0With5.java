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
public class ReplaceAll0With5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[String.valueOf(num).length()];
        int ptr = array.length - 1;
        while (num > 0) {
            array[ptr] = num % 10 == 0 ? 5 : num % 10;
            num /= 10;
            ptr--;
        }
        for (int i : array) {
            System.out.print(i);
        }
    }
}
