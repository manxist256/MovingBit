/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class MinimumSumOfSquaresOfCharacterCounts implements Comparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        int[] arr = new int[26];
        int K = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c - 97]++;
        }
        Queue<Integer> q = new PriorityQueue(new MinimumSumOfSquaresOfCharacterCounts());
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) q.offer(arr[i]);
        }
        for (int i = 0; i < K; i++) {
            int peek = q.poll();
            peek -= 1;
            if (peek > 0)
                q.offer(peek);
        }
        int res = 0;
        while (!q.isEmpty()) {
            int peek = q.poll();
            res += ((int)Math.pow(peek, 2));
        }
        System.out.println(res);
    }

    @Override
    public int compare(Object o1, Object o2) {
        return (int)o1 < (int)o2 ? 1 : -1;
    }
}
