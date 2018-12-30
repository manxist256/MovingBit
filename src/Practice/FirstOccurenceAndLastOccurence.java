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
public class FirstOccurenceAndLastOccurence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), X = sc.nextInt();
        int fc = -1, lc = -1; boolean fcf = false;
        for (int i = 0; i < N; i++) {
            if (sc.nextInt() == X) {
                if (!fcf) {
                    fc = i;
                    fcf = true;
                }
                lc = i;
            }
        }
        System.out.println(fc + " " + lc);
    }
}
