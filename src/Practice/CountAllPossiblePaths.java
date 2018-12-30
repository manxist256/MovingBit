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
public class CountAllPossiblePaths {
    
    static int PATH = 0;
    
    private static void findpaths(int m, int n) {
        findpaths(m - 1, n - 1, 0, 0);
    }
    
    private static void findpaths(int m, int n, int x, int y) {
        if (x > m || y > n) {
            return;
        }
        if (m == x && n == y) {
            PATH++;
            return;
        }
        findpaths(m, n, x, y + 1);
        findpaths(m, n, x + 1, y);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        findpaths(m, n);
        System.out.println(PATH);
    }
}
