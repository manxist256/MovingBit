/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.February2019;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class ChefAndSecretIngredients {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int sC = Integer.parseInt(sc.nextLine());
            int[] arr = new int[26];
            for (int i = 0; i < sC; i++) {
                String str = sc.nextLine();
                int[] loc = new int[26];
                for (int j = 0; j < str.length(); j++) {
                    int val = str.charAt(j) - 97;
                    loc[val] = 1;
                }
                for (int j = 0; j < loc.length; j++) {
                    if (loc[j] == 1) {
                        arr[j]++;
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == sC) {
                    res++;
                }
            }
            System.out.println(res);
        }
    }
}
