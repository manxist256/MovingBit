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
public class ColumnNameFromAGivenColumnNumber {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int s = 0, e = 0, i = 0;
                String result = "";
                if (N <= 26 && N >= 1) {
                        System.out.println((char)(64 + N));
                } else if (N > 26 && N <= 702) {
                        System.out.println((char)(64 + (N % 26 == 0 ? (N - 1) / 26 : N  / 26)) + "" + (char)((N % 26 == 0 ? 'Z' : 64 + N % 26)));
                }
        }
}
