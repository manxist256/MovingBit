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
public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String remove = sc.nextLine();
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            boolean p = false;
            for (int j = 0; j < remove.length(); j++) {
                if (text.charAt(i) == remove.charAt(j)) {
                    p = true; break;
                }
            }
            if (!p) res = res + text.charAt(i);
        }
        System.out.println(res);
    }
}
