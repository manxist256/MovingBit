/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class RomanNumeralsBetween1and999 {
    
    private static void prefillmap(HashMap<Integer, String> map) {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String roman = "";
        int i = 0;
        HashMap<Integer, String> map = new HashMap<>();
        prefillmap(map);
        while (N > 0) {
            int num = N % 10;
            N /= 10;
            switch (i) {
                case 0:
                    if (num < 4) {
                        for (int k = 1; k <= num; k++) {
                            roman = map.get(1) + roman;
                        }
                    } else if (num == 4) {
                        roman = map.get(4) + roman;
                    } else if (num == 9) {
                        roman = map.get(9) + roman;
                    } else {
                        roman = map.get(5) + roman;
                        for (int k = 5; k < num; k++) {
                            roman = roman + map.get(1);
                        }
                    }   break;
                case 1:
                    if (num < 4) {
                        for (int k = 1; k <= num; k++) {
                            roman = map.get(10) + roman;
                        }
                    } else if (num == 4) {
                        roman = map.get(40) + roman;
                    } else if (num == 9) {
                        roman = map.get(90) + roman;
                    } else {
                        String t = map.get(50);
                        for (int k = 5; k < num; k++) {
                            t = t + map.get(10);
                        }
                        roman = t + roman;
                    }   break;
                case 2:
                    if (num < 4) {
                        for (int k = 1; k <= num; k++) {
                            roman = map.get(100) + roman;
                        }
                    } else if (num == 4) {
                        roman = map.get(400) + roman;
                    } else if (num == 9) {
                        roman = map.get(900) + roman;
                    } else {
                        String t = map.get(500);
                        for (int k = 5; k < num; k++) {
                            t = t + map.get(100);
                        }
                        roman = t + roman;
                    }   break;
                default:
                    break;
            }
            
            i++;
        }
        System.out.println(roman);
    }
}
