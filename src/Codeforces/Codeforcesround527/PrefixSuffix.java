/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround527;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author mankank
 */
public class PrefixSuffix implements Comparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String arr[] = new String[2 * n - 2];
        TreeMap<Integer, String> map = new TreeMap<>(new PrefixSuffix());
        for (int i = 0; i < 2 * n - 2; i++) {
            arr[i] = sc.nextLine();
            map.put(arr[i].length(), arr[i]);
        }
        call(arr, map, n);
    }

    private static void call(String[] arr, TreeMap<Integer, String> map, int n) {
        Entry entry = map.firstEntry();
        String f1 = (String)entry.getValue(), f2 = "";
        outer : for (Map.Entry etr : map.entrySet()) {
            String x = (String)etr.getValue();
            if (f1.equals(x)) {
                continue;
            }
            for (int i = 0; i < x.length(); i++) {
                if (f1.charAt(i) != x.charAt(i)) {
                    f2 = x;
                    break outer;
                }
            }
        }
        
        merge(f1, f2, n, arr, map);
        
    }
    
    private static void printequallengthanswer(String[] arr) {
        HashSet<String> d = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!d.contains(arr[i])) {
                System.out.print("P");
            } else {
                System.out.print("S");
            }
            d.add(arr[i]);
        }
    }
    
    private static void merge(String f1, String f2, int n, String[] arr, TreeMap<Integer, String> map) {
        if (f2.equals("")) {
            //we did not find f2 and hence prefix is the string
            printequallengthanswer(arr);
        } else {
            String merge1 = "", merge2 = "";
            //merge1 merge f1 as prefix and f2 as suffix
            int d = n - f1.length();
            String g1 = "";
            for (int i = 0; i < d; i++) {
                g1 = f2.charAt((f2.length() - 1) - i) + g1;
            }
            merge1 = f1 + g1; 
            //merge2 merge f2 as prefix and f1 as suffix
            int d2 = n - f2.length();
            String g2 = "";
            for (int i = 0; i < d2; i++) {
                g2 = f1.charAt((f1.length() - 1) - i) + g2;
            }
            merge2 = f2 + g2;
            solve(merge1, merge2, arr, map);
        }
    }
    
    private static void solve(String merge1, String merge2, String[] arr, TreeMap<Integer, String> map) {
        ArrayList<String> prefixlist = new ArrayList<>();
        ArrayList<String> suffixlist = new ArrayList<>();
        HashSet<String> d = new HashSet<>(); boolean ansf = true;
        char p[] = new char[arr.length];
        outer : for (int i = 0; i < arr.length; i++) {
            String c = arr[i]; boolean prefix = true;
            for (int j = 0; j < c.length(); j++) { //compare for prefix
                if (merge1.charAt(j) != c.charAt(j)) {
                    prefix = false;
                    break; //its not a prefix, check for suffix.
                }
            }
            if (!prefix) {
                for (int j = 0; j < c.length(); j++) {
                    if (merge1.charAt((merge1.length() - 1) - j) != c.charAt((c.length() - 1) - j)) {
                        ansf = false;
                        break outer;
                    }
                }
            }
            if (prefix) {
                 if (!d.contains(c)) {
                     p[i] = 'P';
                 } else {
                     p[i] = 'S';
                 }
            } else {
                p[i] = 'S';
            }
            d.add(c);
        }
        if (!ansf) {
            d = new HashSet<>();
            outer : for (int i = 0; i < arr.length; i++) {
                String c = arr[i]; boolean prefix = true;
                for (int j = 0; j < c.length(); j++) { //compare for prefix
                    if (merge2.charAt(j) != c.charAt(j)) {
                        prefix = false;
                        break; //its not a prefix, check for suffix.
                    }
                }
                if (!prefix) {
                    for (int j = 0; j < c.length(); j++) {
                        if (merge2.charAt((merge2.length() - 1) - j) != c.charAt((c.length() - 1) - j)) {
                            break outer;
                        }
                    }
                }
                if (prefix) {
                    if (!d.contains(c)) {
                        p[i] = 'P';
                    } else {
                        p[i] = 'S';
                    }
                } else {
                    p[i] = 'S';
                }
                d.add(c);
            }
        }
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i]);
        }
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        int s1 = (int)o1;
        int s2 = (int)o2;
        return s1 > s2 ? -1 : 1;
    }
}
