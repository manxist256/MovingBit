
import java.util.Arrays;
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
public class ArrayStabilization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(Math.min(array[array.length - 1] - array[1], array[array.length - 2] - array[0]));
    }
}
