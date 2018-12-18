
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround527;

/**
 *
 * @author mankank
 */
public class TeamsForming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); int result = 0;
        for (int i = 0; i < n; i += 2) {
            result += (arr[i + 1] - arr[i]);
        }
        System.out.println(result);
    }
}
