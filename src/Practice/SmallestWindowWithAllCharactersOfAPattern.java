/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class SmallestWindowWithAllCharactersOfAPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pattern = sc.nextLine();
        HashMap<Character, Integer> pc = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!pc.containsKey(c)) {
                pc.put(c, 1);
                continue;
            }
            int ev = pc.get(c);
            pc.put(c, ++ev);
        }
        int ptr = 0;
        HashSet<Character> nr = new HashSet<>();
        int count = 0, wcount = 0; //count == proper_count
        int windowsize = Integer.MAX_VALUE;
        int firstindex = -1;
        HashMap<Character, Integer> track = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char read = s.charAt(i);
            if (pc.containsKey(read)) {
                if (firstindex == -1) {
                    firstindex = i;
                }
                if (!track.containsKey(read)) {
                    track.put(read, 1);
                } else {
                    int ev = track.get(read);
                    track.put(read, ++ev);
                }
                if (track.get(read) <= pc.get(read)) {
                    count++;
                } else {
                    nr.add(read); //add unnecessary removal characters
                }
                wcount++;
            }
            if (count == pattern.length()) {
                if ((i - firstindex) + 1 < windowsize) {
                    windowsize = (i - firstindex) + 1;
                }
                if (wcount != count) {
                    while (!nr.isEmpty()) {
                        char ru = s.charAt(ptr);
                        if (nr.contains(ru)) {
                            int uc = track.get(ru);
                            uc -= 1;
                            if (uc == pc.get(ru)) {
                                nr.remove(ru);
                            } else {
                                track.put(ru, uc);
                            }
                        }
                        ptr += 1;
                    }
                    i = ptr - 1;
                } else {
                    i -= 1;
                }
                if (s.length() - i < pattern.length()) {
                    break;
                }
                wcount = 0;
                count = 0;
                track = new HashMap();
                nr = new HashSet();
                firstindex = -1;
            }
        }
        System.out.println(windowsize);
    }
}
