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
public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String temp = "", result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || i == str.length() - 1) {
                result = result + (i == str.length() - 1 ? str.charAt(i) : "");
                for (int j = temp.length() - 1; j >= 0; j--) {
                    result = result + temp.charAt(j);
                }
                result = result + " ";
                temp = "";
                continue;
            }
            temp = temp + str.charAt(i);
        }
        System.out.println(result);
    }
}
