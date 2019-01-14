/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author mankank
 */

class CharCount {
    int count;
    char c;
    public CharCount(char c, int count) {
        this.c = c;
        this.count = count;
    }
}

public class RearrangeCharactersSuchThatNoTwoAdjCharactersRSame implements Comparator {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        CharCount[] arr = new CharCount[s.length()];
        PriorityQueue<CharCount> pq = new PriorityQueue(new RearrangeCharactersSuchThatNoTwoAdjCharactersRSame());
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 97] == null) {
                arr[s.charAt(i) - 97] = new CharCount(s.charAt(i), 0);
            } 
            arr[s.charAt(i) - 97].count++;
        }
        
        for (CharCount cc : arr) {
            if (cc != null)
                pq.add(cc);
        }
        
        int c = 0;
        char blacklist = ' ';
        
        while (c < s.length() && !pq.isEmpty()) {
            CharCount charcount = pq.poll();
            if (charcount.c == blacklist) {
                if (pq.isEmpty()) {
                    System.out.println("Not possible");
                    break;
                }
                CharCount sr = pq.poll();
                sr.count--;
                System.out.print(sr.c);
                blacklist = sr.c;
                pq.add(charcount);
                if (sr.count > 0)
                    pq.add(sr);
            } else {
                charcount.count--;
                System.out.print(charcount.c);
                blacklist = charcount.c;
                if (charcount.count > 0)
                    pq.add(charcount);
            }
        }
        
    }
    
    
    @Override
    public int compare(Object o1, Object o2) {
        CharCount c1 = (CharCount)o1;
        CharCount c2 = (CharCount)o2;
        return c1.count < c2.count ? 1 : -1;
    }
}
