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
public class FillNeighbours1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0, cntr = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                cntr++;
            } else if (arr[i] == 1) {
                if (cntr > max) {
                    max = cntr;
                }
                cntr = 0;
            }
        }
        System.out.println(max % 2 == 0 ? max / 2 : max / 2 + 1);
    }
}
