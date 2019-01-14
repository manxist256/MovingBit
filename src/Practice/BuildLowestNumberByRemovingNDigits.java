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
public class BuildLowestNumberByRemovingNDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = sc.nextInt(), L = 0;
        int[]res = new int[s.length() - N];
        int ptr = 0;
        while (L < res.length) {
            int min = Integer.MAX_VALUE, mi = 0;
            for (int i = ptr; i < ptr + N + 1; i++) {
                int v = s.charAt(i) - '0';
                if (v < min) {
                    min = v;
                    mi = i;
                }
            }
            N -= (mi - ptr);
            ptr = mi + 1;
            res[L++] = min;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
