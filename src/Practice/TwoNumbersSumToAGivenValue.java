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
public class TwoNumbersSumToAGivenValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int X = sc.nextInt();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > X) {
                j--;
            } else if (arr[i] + arr[j] < X) {
                i++;
            } else {
                System.out.println(arr[i] + " " + arr[j]);
                break;
            }
        }
    }
}
