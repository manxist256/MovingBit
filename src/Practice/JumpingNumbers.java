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
public class JumpingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        outer : for (int i = 0; i <= N; i++) {
            String n = String.valueOf(i);
            for (int j = 0; j < n.length() - 1; j++) {
                if (!(Math.abs(n.charAt(j) - n.charAt(j + 1)) == 1)) {
                    continue outer;
                }
            }
            System.out.print(i + " ");
        }
    }
}
