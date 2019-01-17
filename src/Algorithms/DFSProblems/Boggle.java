/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DFSProblems;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Boggle {
    
    private static boolean recurse(String st, int i, int j, int pos, char[][] boggle) {
        if (i > 2 || j > 2 || i < 0 || j < 0) {
            return false;
        }
        if (pos == st.length()) {
            return true;
        }
        if (boggle[i][j] == st.charAt(pos)) {
            if (recurse(st, i - 1, j, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i, j + 1, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i + 1, j, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i, j - 1, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i + 1, j + 1, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i + 1, j - 1, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i - 1, j - 1, pos + 1, boggle)) {
                return true;
            }
            if (recurse(st, i - 1, j + 1, pos + 1, boggle)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isPIB(String st, char[][] boggle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boggle[i][j] == st.charAt(0)) {
                    if (recurse(st, i, j, 0, boggle))
                        return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] d = new String[N]; //dict
        for (int i = 0; i < N; i++) {
            d[i] = sc.nextLine();
        }
        char[][] boggle = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boggle[i][j] = sc.next().charAt(0);
            }
        }
        for (String st : d) {
            if (isPIB(st, boggle)) {
                System.out.print(st + " ");
            }
        }
    }
}
