/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.EducationalCodeforcesRound55;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class VovaTrophies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine(); int gC = 0, sC = 0;
        boolean noG = false;
        int[] tcount = new int[(int)10e5 + 2];
        char[] tcolor = new char[(int)10e5 + 2];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'G') {
                if (sC > 0) {
                    tcount[index] = sC;
                    tcolor[index] = 'S';
                    index++;
                }
                sC = 0;
                gC++;
            } else if (s.charAt(i) == 'S') {
                if (gC > 0) {
                    tcount[index] = gC;
                    tcolor[index] = 'G';
                    index++;
                }
                gC = 0;
                sC++;
            }
            if (i == s.length() - 1) {
                if (gC > 0) {
                    tcount[index] = gC;
                    tcolor[index] = 'G';
                    index++;}
                if (sC > 0) {
                    tcount[index] = sC;
                    tcolor[index] = 'S';
                    index++;
                    noG = true;}
            }
        }
        if (index == 1 && noG) {
            System.out.println(0);
            return;
        } else if (index == 1 && !noG) {
            System.out.println(tcount[0]);
            return;
        } else if (index == 2) {
            if (tcolor[0] == 'G' && tcolor[1] == 'S') {
                System.out.println(tcount[0]);
                return;
            } else if (tcolor[0] == 'S' && tcolor[1] == 'G') {
                System.out.println(tcount[1]);
                return;
            }
        }
        int cog = 0; int max = 0; int update = 0; int smax = 0;
        for (int i = 0; i < index; i++) {
            if (tcolor[i] == 'G') {
                if (tcount[i] + tcount[i+2] > max && (tcount[i+1] == 1)) {
                    max = tcount[i] + tcount[i + 2];
                    update++;
                }
                cog++;
                if (tcount[i] > smax) {
                    smax = tcount[i];
                }
            }
        }
        if (update == 0 && cog != 1) {
            System.out.println(smax + 1);
            return;
        }
        if (update == 1 && cog == 1) {
            System.out.println(smax);
            return;
        }
        if (update == 1 && cog == 2) {
            System.out.println(max);
        }
        else if (cog == 2) {
            System.out.println(max-1);
        }
        else {
            System.out.println(max+1);
        }
    }
}
