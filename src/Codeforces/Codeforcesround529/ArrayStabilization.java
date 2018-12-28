
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
        Integer[] array = new Integer[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        //Arrays.sort(int[]) performs quicksort, which will peform TC : O(n^2) in worstcase, 
        //Hence used, Arrays.sort(Integer[]) that performs mergesort, which will perform TC : O(log_n) in worstcase.
        Arrays.sort(array);
        System.out.println(Math.min(array[array.length - 1] - array[1], array[array.length - 2] - array[0]));
    }
}
