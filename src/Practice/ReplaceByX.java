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
public class ReplaceByX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pattern = sc.nextLine();
        String res = "";
        for (int i = 0; i < text.length(); i++) {
            String tk = "";
            if (text.length() - i >= pattern.length()) {
                for (int j = i; j < i + pattern.length(); j++) {
                    tk = tk + text.charAt(j);
                }
            }
            if (tk.equals(pattern)) {
                res = res + 'X';
                i += pattern.length() - 1;
            } else {
                res = res + text.charAt(i);
            }
        }
        System.out.println(res);
    }
}
