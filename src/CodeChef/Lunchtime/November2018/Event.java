/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Lunchtime.November2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
class Event {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = Integer.parseInt(sc.nextLine());
                while (T-- > 0) {
                    HashMap<String, Integer> map = new HashMap<>();
                    map.put("saturday", 1);
                    map.put("sunday", 2);
                    map.put("monday", 3);
                    map.put("tuesday", 4);
                    map.put("wednesday", 5);
                    map.put("thursday", 6);
                    map.put("friday", 7);
                    String input[] = sc.nextLine().split(" ");
                    String sday = input[0];
                    String eday = input[1];
                    int l = Integer.parseInt(input[2]);
                    int r = Integer.parseInt(input[3]);
                    int bd = 0;
                    if (map.get(sday) <= map.get(eday)) {
                            bd = (map.get(eday) - map.get(sday)) + 1;
                    } else {
                            bd = ((7 - map.get(sday)) + 1) + map.get(eday);
                    }
                    HashSet hs = new HashSet();
                    if (bd <= r && bd >= l)
                     hs.add(bd);
                    int ug = bd;
                    int cx = bd;
                    for (int i = 0; i <= 100; i++) {
                        hs.add(cx);
                        cx += 7;
                    }
                    int c = 0; 
                    for (int i = l; i <= r; i++) {
                        if (hs.contains(i)) {
                            c++;
                            ug = i;
                        }
                    }
                    if (c == 1) {
                            System.out.println(ug);
                    }
                    else if (c > 0) {
                            System.out.println("many");
                    }
                    else if (c == 0) {
                            System.out.println("impossible");
                    }
                }
        }
}
