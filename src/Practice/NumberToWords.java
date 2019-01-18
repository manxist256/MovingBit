/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class NumberToWords {
    
    //number to words b/w 0 - 999999
    private static void prefillmap (Map <Integer, String> map) {
        map.put(0, "zero"); map.put(10, "ten");
        map.put(1, "one");  map.put(11, "eleven");
        map.put(2, "two");  map.put(12, "twelve");
        map.put(3, "three"); map.put(13, "thirteen");
        map.put(4, "four"); map.put(14, "fourteen");
        map.put(5, "five"); map.put(15, "fifteen");
        map.put(6, "six"); map.put(16, "sixteen");
        map.put(7, "seven"); map.put(17, "seventeen");
        map.put(8, "eight"); map.put(18, "eighteen");
        map.put(9, "nine"); map.put(19, "nineteen");
        map.put(20, "twenty"); map.put(100, "hundred");
        map.put(30, "thirty"); map.put(1000, "thousand");
        map.put(40, "fourty"); map.put(100000, "lakh");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }   
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), p = 0;
        String result = "";
        Map<Integer, String> map = new HashMap<>();
        prefillmap(map);
        while (N > 0) {
            String f = "";
            int d1 = N % 10;
            p += 1;
            N /= 10;
            if (p == 3) {
                result = map.get(d1) + " " + map.get(100) + " and " + result;
                continue;
            }
            int d2 = -1;
            if (N > 0) {
                d2 = N % 10;
                p += 1;
                N /= 10;
            }
            switch (p) {
                case 1:
                    f = map.get(d1);
                    break;
                case 2:
                    if (d2 != 1)
                        f = map.get(d2 * 10) + " " + (d1 != 0 ? map.get(d1) : "");
                    else {
                        f = map.get(Integer.parseInt(String.valueOf(d2) + String.valueOf(d1)));
                    }   break;
                case 4:
                    f = map.get(d1) + " " + map.get(1000) + " ";
                    break;
                case 5:
                    if (d2 != 1)
                        f = map.get(d2 * 10) + " " + (d1 != 0 ? map.get(d1) : "");
                    else {
                        f = map.get(Integer.parseInt(String.valueOf(d2) + String.valueOf(d1)));
                    }   f = f + " " + map.get(1000) + " ";
                    break;
                case 6:
                    f = map.get(d1) + " " + map.get(100000) + " ";
                    break;
                default:
                    break;
            }
            result = f + result;
        }
        System.out.println(result);
    }
}
