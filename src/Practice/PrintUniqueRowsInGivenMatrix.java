/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class PrintUniqueRowsInGivenMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = "";
            for (int j = 0; j < M; j++) {
                s += sc.nextInt();
            }
            set.add(s);
        }
        System.out.println();
        for (String s : set) {
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i) + " ");
            }
            System.out.println();
        }
    }
}
