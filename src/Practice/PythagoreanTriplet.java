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
public class PythagoreanTriplet {
    
    private static boolean checkPythagoreanTriplet(int n1, int n2, int n3) {
        int[] arr = {n1, n2, n3};
        Arrays.sort(arr);
        return (int)(Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) == (int)(Math.pow(arr[2], 2));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    boolean pythagoreanTriplet = checkPythagoreanTriplet(array[i], array[j], array[k]);
                    if (pythagoreanTriplet) {
                        System.out.println(array[i] + " " + array[j] + " " + array[k] + " is a pythagorean triplet");
                    } else {
                        System.out.println(array[i] + " " + array[j] + " " + array[k] + " is not a pythagorean triplet");
                    }
                }
            }
        }
    }
}
