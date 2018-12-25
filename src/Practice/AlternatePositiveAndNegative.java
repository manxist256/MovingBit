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
public class AlternatePositiveAndNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int flag = 0;
        for (int i = 0; i < N; i++) {
            if (flag == 0 && arr[i] >= 0) {
                flag = 1;
                continue;
            } else if (flag == 1 && arr[i] < 0) {
                flag = 0;
                continue;
            }
            for (int j = i + 1; j < N; j++) {
                if (flag == 1 && arr[j] < 0 || flag == 0 && arr[j] >= 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
            flag = flag == 0 ? 1 : 0;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
