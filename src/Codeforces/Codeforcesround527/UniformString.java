/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround527;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class UniformString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt(), k = sc.nextInt();
            int occurence = n / k;
            String result = "";
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < occurence; j++) {
                    result += (char)(97 + i);
                }
            }
            for (int i = 0; i < (n % k); i++) {
                result += (char)(97 + i);
            }
            System.out.println(result);
        }
    }
}
