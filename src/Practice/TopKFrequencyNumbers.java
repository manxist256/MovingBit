/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author mankank
 */

class Frequency implements Comparator {

    int num, fq;
    
    public Frequency(int n, int fq) {
        this.num = n;
        this.fq = fq;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return (int)o1 < (int)o2 ? 1 : -1;
    }
    
}

public class TopKFrequencyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Frequency> set = new HashSet<>();
        HashMap<Integer, Frequency> flist = new HashMap<>();
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (!flist.containsKey(num)) {
                flist.put(num, new Frequency(num, 1));
                set.add(flist.get(num));
            } else {
                Frequency fq = flist.get(num);
                fq.fq++;
            }
            TreeMap<Integer, HashSet> map = new TreeMap<>(new Frequency(0, 0));
            for (Frequency f : set) {
                if (!map.containsKey(f.fq)) {
                    HashSet<Frequency> newset = new HashSet<>();
                    newset.add(f);
                    map.put(f.fq, newset);
                } else {
                    HashSet<Frequency> getset = map.get(f.fq);
                    getset.add(f);
                }
            }
            for (Map.Entry etr : map.entrySet()) {
                HashSet<Frequency> getset = (HashSet<Frequency>)etr.getValue();
                for (Frequency f : getset) {
                    System.out.print(f.num + " " + f.fq + " / ");
                }
            }
            System.out.println();
        }
    }
}
