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
public class NumberOfWaysToCoverDistance {
    
    private static void printpaths(int n) {
        printpaths(n, 0, "");
    }
    
    private static void printpaths(int n, int sum, String s) {
        if (sum == n) {
            System.out.println(s);
            return;
        } else if (sum > n) {
            return;
        } 
        printpaths(n, sum + 1, s + "1");
        printpaths(n, sum + 2, s + "2");
        printpaths(n, sum + 3, s + "3");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printpaths(n);
    }
}
