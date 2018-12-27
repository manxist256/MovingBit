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
public class ReverseA32BitGivenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();
        String reverseBinary = "";
        for (int i = 0; i < binary.length(); i++) {
            reverseBinary = binary.charAt(i) + reverseBinary;
        }
        System.out.println(reverseBinary);
        int ans = 0;
        for (int i = reverseBinary.length() - 1; i >= 0; i--) {
            ans += ((reverseBinary.charAt(i) - 48) * (int)Math.pow(2, reverseBinary.length() - (i + 1)));
        }
        System.out.println(ans);
    }
}
