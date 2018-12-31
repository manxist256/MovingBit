/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mankank
 */
public class RearrangePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        Stack<Integer> neg = new Stack();
        Stack<Integer> pos = new Stack();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < 0) neg.add(arr[i]);
            else pos.add(arr[i]);
        }
        int flag = 0, k = 0;
        while (!pos.isEmpty() && !neg.isEmpty()) {
            if (flag == 0) {
                arr[k++] = pos.pop();
            } else {
                arr[k++] = neg.pop();
            }
            flag = flag == 0 ? 1 : 0;
        }
        while (!pos.isEmpty()) {
            arr[k++] = pos.pop();
        }
        while (!neg.isEmpty()) {
            arr[k++] = neg.pop();
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
