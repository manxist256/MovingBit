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
public class PossibleGroupsof2and3withSumMultipleof3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int onc = 0, twc = 0, thc = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt() % 3;
            switch (arr[i]) {
                case 0:
                    thc++;
                    break;
                case 1:
                    onc++;
                    break;
                case 2:
                    twc++;
                    break;
            }
        }
        int count = 0;
        int con = 0, ctw = 0, cth = 0;
        int tpc = 0;
        for (int i = 0; i < N; i++) {
            switch (arr[i]) {
                case 0:
                    cth++;
                    count += (thc - cth);
                    int z = (thc - cth) - 1;
                    tpc += ((z * (z + 1)) / 2);
                    break;
                case 1:
                    con++;
                    count += (twc - ctw);
                    tpc += ((twc - ctw) * thc);
                    break;
                case 2:
                    ctw++;
                    count += (onc - con);
                    tpc += ((onc - con) * thc);
                    break;
            }
        }
        System.out.println(count + tpc);
    }
}
