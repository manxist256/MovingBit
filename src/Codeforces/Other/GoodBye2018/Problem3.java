package Codeforces.Other.GoodBye2018;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Other.GoodBye2018;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        HashSet<Long> list = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add((long)i);
                list.add(n / i);
            }
        }
        Long[] ans = new Long[list.size()];
        int l = 0;
        for (long i : list) {
            int fun = 0; long lastly = n - (i - 1);
            lastly = lastly + 1;
            long f = (n / i);
            long g = ((n / i) / 2);
            if (i == 1) {
                ans[l++] = (n * (n+1)) / 2;
            }
            else if (i == n) {
                ans[l++] = 1l;
            }
            else if (f % 2 == 0) {
                ans[l++] = lastly * g;
            } else {
                ans[l++] = (lastly * (g)) + (lastly / 2);
            }
        }
        Arrays.sort(ans);
        for (long i : ans) {
            System.out.print(i + " ");
        }
    }
}