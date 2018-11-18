/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class RadixConversions {
    
    static String[] octal = {"000", "001", "010", "011", "100", "101", "110", "111"};
    static String[] hexadecimal = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", 
        "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    
    private static void decimalToBinary(int n) {
        String binary = "";
        int div = 0;
        while (n > 1) {
            int rem = n % 2;
            div = n/2;
            binary = rem + binary;
            n /= 2;
        }
        System.out.println(div + binary);
    }
    
    private static void decimalToOctal(int n) {
        if (n < 8) {
            System.out.println(n);
            return;
        }
        String o = "";
        int div = 0;
        while (n > 7) {
            int rem = n % 8;
            div = n / 8;
            o = rem + o;
            n /= 8;
        }
        System.out.println(div + o);
    }
    
    private static void decimalToHexadecimal(int n) {
        if (n < 16) {
            if (n > 10) {
                System.out.println((char)((n-10)+65));
                return;
            }
            System.out.println(n);
            return;
        }
        String hex = "";
        int div = 0;
        while (n > 15) {
            int rem = n % 16;
            div = n / 16;
            n /= 16;
            if (rem > 9) {
                hex = (char)((rem-10)+65) + hex;
                continue;
            }
            hex = rem + hex;
        }
        if (div > 9) {
            System.out.println((char)((div-10)+65) + hex);
            return;
        }
        System.out.println(div + hex);
    }
    
    private static void binaryToOctal (int b) {
        int length = String.valueOf(b).length();
        String binary = String.valueOf(b);
        int m = length % 3;
        if (m != 0) {
            if (m == 1) binary = "00" + binary;
            if (m == 2) binary = "0" + binary;
        }
        String l = "", o = "";
        for (int i = 1; i <= binary.length(); i++) {
            l = l + binary.charAt(i - 1);
            if (i % 3 == 0) {
                for (int j = 0; j < octal.length; j++) {
                    if (l.equals(octal[j])) {
                        o = o + j;
                        break;
                    }
                }
                l = "";
            }
        }
        System.out.println(o);
    }
    
    private static void binaryToHexadecimal(int b) {
        int length = String.valueOf(b).length();
        String binary = String.valueOf(b);
        int m = length % 4;
        if (m != 0) {
            if (m == 1) binary = "000" + binary;
            if (m == 2) binary = "00" + binary;
            if (m == 3) binary = "0" + binary;
        }
        String l = "", h = "";
        for (int i = 1; i <= binary.length(); i++) {
            l = l + binary.charAt(i - 1);
            if (i % 4 == 0) {
                for (int j = 0; j < hexadecimal.length; j++) {
                    if (l.equals(hexadecimal[j])) {
                        if (j >= 10) {
                            h = h + ((char)((j-10)+65));
                        } else {
                            h = h + j;
                        }
                        break;
                    }
                }
                l = "";
            }
        }
        System.out.println(h);
    }
    
    private static void octalToBinary(int oct) {
        String binary = "";
        String o = String.valueOf(oct);
        for (int i = 0; i < o.length(); i++) {
            int c = o.charAt(i);
            binary = binary + octal[(c - 48)];
        }
        System.out.println(binary);
    }
    
    private static void hexadecimalToBinary(String h) {
        String binary = "";
        for (int i = 0; i < h.length(); i++) {
            int c = h.charAt(i);
            if (c >= 65) {
                c -= 65;
                c += 10;
            } else {
                c -= 48;
            }
            binary = binary + hexadecimal[(c)];
        }
        System.out.println(binary);
    }
    
    private static void octalToHexadecimal() {
        // convert octal to binary
        // convert resultant binary to hexadecimal
    }
    
    private static void  hexadecimalToOctal() {
        // convert hexadecimal to binary
        // convert resultant binary to octal
    }
    
    private static void binaryToDecimal(String b) {
        int result = 0;
        int i = 0;
        for (int j = b.length() - 1; j >= 0; j--) {
            result += ((b.charAt(j) - 48) * Math.pow(2, i++));
        }
        System.out.println(result);
    }
    
    private static void octalToDecimal(String o) {
        int result = 0;
        int i = 0;
        for (int j = o.length() - 1; j >= 0; j--) {
            result += ((o.charAt(j) - 48) * Math.pow(8, i++));
        }
        System.out.println(result);
    }
    
    private static void hexadecimalToDecimal(String h) {
        int result = 0;
        int i = 0;
        for (int j = h.length() - 1; j >= 0; j--) {
            int d = h.charAt(j) - 48;
            if (d > 10) {
                d = (h.charAt(j) - 65) + 10;
            }
            result += (d * Math.pow(16, i++));
        }
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int input = sc.nextInt();
        //RadixConversions.decimalToBinary(input);
        //RadixConversions.decimalToOctal(input);
        //RadixConversions.decimalToHexadecimal(input);
        //RadixConversions.binaryToOctal(input);
        //RadixConversions.binaryToHexadecimal(input);
        //RadixConversions.octalToBinary(input);
        //String input = sc.nextLine();
        //RadixConversions.hexadecimalToBinary(hex);
        //RadixConversions.binaryToDecimal(input);
        //RadixConversions.octalToDecimal(input);
        //RadixConversions.hexadecimalToDecimal(input);
    }
}
