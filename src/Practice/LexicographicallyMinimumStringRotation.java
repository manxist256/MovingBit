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
public class LexicographicallyMinimumStringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
        int l = str.charAt(0) - 65, ptr = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 65;
            if (c < l) {
                l = c;
                ptr = i;
            }
        }
        for (int i = ptr; i < str.length(); i++) {
            System.out.print(str.charAt(i));
        }
        for (int i = 0; i < ptr; i++) {
            System.out.print(str.charAt(i));
        }
    }
}
