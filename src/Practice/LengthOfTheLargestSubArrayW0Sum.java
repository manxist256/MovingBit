/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class LengthOfTheLargestSubArrayW0Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int s = 0, max = 0, si = -1, sj = -1;
        HashMap<Integer, Integer> first_seen = new HashMap<>();
        for (int i = 0; i < N; i++) {
            s += arr[i];
            if (!first_seen.containsKey(s)) {
                first_seen.put(s, i);
            } else {
                int range = i - first_seen.get(s);
                if (range > max) {
                    max = range;
                    si = first_seen.get(s) + 1;
                    sj = i;
                }
            }
        }
        System.out.println(max + " " + si + " " + sj);
    }
}
