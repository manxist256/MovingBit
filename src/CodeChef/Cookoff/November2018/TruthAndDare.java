package CodeChef.Cookoff.November2018;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Cookoff.Novermber2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
class TruthAndDare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int tr = sc.nextInt();
            HashSet<Integer> Tr = new HashSet<>();
            for (int i = 0; i < tr; i++) {
                Tr.add(sc.nextInt());
            }
            int dr = sc.nextInt();
            HashSet<Integer> Dr = new HashSet<>();
            for (int i = 0; i < dr; i++) {
                Dr.add(sc.nextInt());
            }
            int ts = sc.nextInt();
            ArrayList<Integer> Ts = new ArrayList<>();
            for (int i = 0; i < ts; i++) {
                Ts.add(sc.nextInt());
            }
            int ds = sc.nextInt();
            ArrayList<Integer> Ds = new ArrayList<>();
            for (int i = 0; i < ds; i++) {
                Ds.add(sc.nextInt());
            }
            boolean win = true;
            for (int i : Ts) {
                if (!Tr.contains(i)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                for (int i : Ds) {
                    if (!Dr.contains(i)) {
                        win = false;
                        break;
                    }
                }
            }
            System.out.println(win ? "yes" : "no");
        }
    }
}
