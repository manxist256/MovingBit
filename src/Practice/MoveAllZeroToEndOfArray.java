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
public class MoveAllZeroToEndOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), cnt = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == 0) cnt++;
        }
        int ptr = 0;
        for (int i = 0; i < N && ptr <= N; i++) {
            if (arr[i] > 0) continue;
            System.out.println(i);
            for (int j = i; j < (N - 1) - ptr; j++) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            ptr += 1;
            if (arr[i] == 0) {
                i -= 1;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
