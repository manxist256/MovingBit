/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.December2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author mankank
 */

class Pair {
        int m1, m2;
        public Pair(int m1, int m2) {
                this.m1 = m1;
                this.m2 = m2;
        }
}

class ChefAndMeatballs {
    
        private static int[] triplet(ArrayList<Pair> pairs) {
                Pair fp = pairs.get(0);
                Pair sp = pairs.get(1);
                int tn;
                if (sp.m1 != fp.m1 && sp.m1 != fp.m2) {
                        tn = sp.m1;
                } else {
                        tn = sp.m2;
                }
                int[] x = {fp.m1, fp.m2, tn};
                return x;
        }
    
        private static void solve(ArrayList<Pair> pairs, ArrayList<Integer> al, PrintWriter pw, BufferedReader br) throws IOException {
                int[] triplet = triplet(pairs);
                //sort triplet;
                pw.println("? " + al.get(0) + " " + triplet[1] + " " + triplet[2] + " "+al.get(1) + " "+al.get(2));
                pw.flush();
                String[] r1 = br.readLine().split(" ");
                int snd = Integer.parseInt(r1[0]);
                int trd = Integer.parseInt(r1[1]);
                if (triplet[1] == snd && triplet[2] == trd) { //meatballs are already in sorted form.
                        //do nothing. //if case can be removed // having the case just for reference purpose during implementation.
                } else if (triplet[1] == trd && triplet[2] == snd) {
                        int temp = triplet[1];
                        triplet[1] = triplet[2];
                        triplet[2] = temp;
                        pw.println("? " + al.get(0) + " " + triplet[0] + " " + triplet[1] + " "+al.get(1) + " "+al.get(2));
                        pw.flush();
                        String[] r2 = br.readLine().split(" ");
                        int snd1 = Integer.parseInt(r2[0]);
                        int trd1 = Integer.parseInt(r2[1]);
                        if (triplet[0] == snd1 && triplet[1] == trd1) {
                            //meatballs are already in sorted form.
                        //do nothing. //if case can be removed // having the case just for reference purpose during implementation.
                        } else {
                                int temp1 = triplet[0];
                                triplet[0] = triplet[1];
                                triplet[1] = temp1;
                        }
                }
                //Now the meatballs which don't provide solution are in sorted order.
                int[][] comb = new int[3][2];
                comb[0][0] = al.get(0); comb[0][1] = al.get(1);
                comb[1][0] = al.get(0); comb[1][1] = al.get(2);
                comb[2][0] = al.get(1); comb[2][1] = al.get(2);
                for (int k = 0; k < comb.length; k++) {
                        int[] cd = comb[k];
                        pw.println("? " + cd[0] + " " + cd[1] + " " +triplet[0] + " " + triplet[1] + " " + triplet[2]);
                        pw.flush();
                        String[] r2 = br.readLine().split(" ");
                        int snd1 = Integer.parseInt(r2[0]);
                        int trd1 = Integer.parseInt(r2[1]);
                        if (snd1 == triplet[0] && trd1 == triplet[1]) {  //least 2 meatballs are cd[0] and cd[1]
                                al.remove(Integer.valueOf(cd[0]));
                                al.remove(Integer.valueOf(cd[1]));
                                System.out.println("! " + al.get(0));
                                return;
                        }
                }
                
        }
    
        private static void prepopulateSet(ArrayList<Integer> al) {
                al.add(1);
                al.add(2);
                al.add(3);
                al.add(4);
                al.add(5);
        }
    
        public static void main(String[] args) throws IOException {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
               PrintWriter pw = new PrintWriter(System.out);
               int T = Integer.parseInt(br.readLine());
               while (T-- > 0) {
                    int N = Integer.parseInt(br.readLine());
                    ArrayList<Integer> al = new ArrayList<>();
                    ArrayList<Integer> removed = new ArrayList<>();
                    ArrayList<Pair> pairs = new ArrayList<>();
                    prepopulateSet(al);
                    int cntr = 5;
                    while (cntr - 2 <= N) {
                            pw.print("? ");
                            for (int integer : al) {
                                pw.print(integer + " ");
                            }
                            pw.println();
                            pw.flush();
                            String[] remove = br.readLine().split(" ");
                            int snd = Integer.parseInt(remove[0]);
                            int trd = Integer.parseInt(remove[1]);
                            al.remove(Integer.valueOf(snd));
                            al.remove(Integer.valueOf(trd));
                            removed.add(snd);
                            removed.add(trd);
                            pairs.add(new Pair(snd, trd));
                            if (cntr == N) {
                                    break;
                            }
                            if (cntr + 1 <= N)
                                    al.add(++cntr);
                            if (cntr + 1 <= N)
                                    al.add(++cntr);
                            else 
                                    al.add(removed.get(0));
                    }
                    solve(pairs, al, pw, br);
               }
        }
}
