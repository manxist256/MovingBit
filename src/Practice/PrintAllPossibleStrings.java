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
public class PrintAllPossibleStrings {
    
    private static void print(String str) {
        HashSet<String> set = new HashSet<>();
        print(str, "", 0, set);
        for (String k : set) {
            System.out.println(k);
        }
    }
    
    private static void print(String str, String ds, int pos, HashSet<String> set) {
        StringBuilder db = new StringBuilder(ds);
        for (int i = pos; i < str.length(); i++) {
            db.append(str.charAt(i));
            if (i != str.length() - 1)
                db.append(" ");
            print(str, db.toString(), i + 1, set);
            String d = db.toString();
            for (int k = i + 1; k < str.length(); k++) {
                d = d + str.charAt(k);
            }
            set.add(d);
            if (i != str.length() - 1)
                db.deleteCharAt(db.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        print(str);
    }
}
