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
public class FindNextImmediateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        boolean poss = false;
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) - '0' < number.charAt(i + 1) - '0') {
                poss = true;
                break;
            }
        }
        if (poss) {
            int[] array = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                array[i] = number.charAt(i) - '0';
            }
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    int pos = i - 1, min = Integer.MAX_VALUE, mi = -1;
                    for (int j = i; j < array.length; j++) {
                        if (array[j] > array[pos] && array[j] - array[pos] <= min) {
                            min = array[j] - array[pos];
                            mi = j;
                        }
                    }
                    int temp = array[pos];
                    array[pos] = array[mi];
                    array[mi] = temp;
                    Arrays.sort(array, i, array.length);
                    break;
                }
            }
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
            }
        } else {
            System.out.println("Not Possible");
        }
    }
}
