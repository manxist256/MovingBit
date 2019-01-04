/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
// MAKAMYOLA
public class LengthOfLongestSubstringWithoutRepetingCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toUpperCase();
        int[] A = new int[26];
        Arrays.fill(A, -1);
        int i = 0; int ml = 0; int si = 0, sj = 0;
        for (int j = 0; j < s.length(); j++) {
            int cp = s.charAt(j) - 65;
            if (A[cp] >= i || j == s.length() - 1) { //duplicate found
                int length = j - i;
                if (length > ml) {
                    ml = length;
                    si = i;
                    sj = (j == s.length() - 1 && A[cp] < i) ? j : j - 1;
                }
                i = A[cp] + 1;
            }
            A[cp] = j;
        }
        for (int j = si; j <= sj; j++) {
            System.out.print(s.charAt(j));
        }
    }
}
