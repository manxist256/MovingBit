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
public class StringPermutation {
    
    private static int getfact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String prevarray[] = null;
        for (int i = 0; i < s.length(); i++) {
            if (prevarray == null) {
                prevarray = new String[1];
                prevarray[0] = String.valueOf(s.charAt(0));
                continue;
            }
            int fact = getfact(i + 1);
            String[] currarray = new String[fact];
            char c = s.charAt(i); int ptr = 0;
            for (int j = 0; j < prevarray.length; j++) {
                String pas = prevarray[j];
                for (int k = 0; k < pas.length() + 1; k++) {
                    String cs = "";
                    for (int l = 0; l < pas.length(); l++) {
                        if (k == l) {
                            cs = cs + c;
                        }
                        cs = cs + pas.charAt(l);
                    }
                    if (k == pas.length()) {
                        cs = cs + c;
                    }
                    currarray[ptr++] = cs;
                }
            }
            prevarray = currarray;
        }
        for (String st : prevarray) {
            System.out.print(st + " ");
        }
    }
}
