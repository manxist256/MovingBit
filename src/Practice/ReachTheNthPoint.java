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
public class ReachTheNthPoint {
    
    private static void reachTheNthPoint(int N) {
        reachTheNthPoint(N, "", 0);
    }
    
    private static void reachTheNthPoint(int N, String s, int sum) {
        if (sum > N) return;
        if (sum == N) {
            System.out.println(s);
            return;
        }
        reachTheNthPoint(N, s + 1, sum + 1);
        reachTheNthPoint(N, s + 2, sum + 2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        reachTheNthPoint(N);
    }
}
