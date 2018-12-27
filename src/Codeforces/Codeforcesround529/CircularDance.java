
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround529;

/**
 *
 * @author mankank
 */
public class CircularDance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] result = new int[N];
        int[][] remember = new int[N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                remember[i][j] = sc.nextInt();
            }
        }
        result[0] = 1;
        int or1 = remember[0][0] - 1, or2 = remember[0][1];
        if (remember[or1][0] == or2 || remember[or1][1] == or2) {
            result[1] = or1 + 1;
            result[2] = or2;
        } else {
            result[1] = or2;
            result[2] = or1 + 1;
        }
        for (int i = 1; i < N - 2; i++) {
            int o = result[i] - 1;
            if (remember[o][0] == result[i + 1]) {
                result[i + 2] = remember[o][1];
            } else {
                result[i + 2] = remember[o][0];
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
