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
public class CountTripletsWithLessThanN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int value = sc.nextInt();
        ArrayList<Integer> pair = new ArrayList<>();
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                pair.add(arr[i] + arr[j]);
            }
        }

        int c = N - 2, k = c;
        int answer = 0;
        for (int i : pair) {
            for (int j = N - c; j < N; j++) {
                if (i + arr[j] < value) {
                    answer++;
                }
            }
            c -= 1;
            if (c == 0) {
                c = k - 1;
                k = c;
            }
        }
        System.out.println(answer);
    }
}
