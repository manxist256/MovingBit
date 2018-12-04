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
public class FacingTheSun {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), max = 0, count = 0;
                for (int i = 0; i < N; i++) {
                        int bh = sc.nextInt();
                        if (bh > max) {
                                max = bh;
                                count++;
                        }
                }
                System.out.println(count);
        }
}
