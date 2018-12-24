
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Cookoff.December2018;

/**
 *
 * @author mankank
 */
class CampOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        while (T-- > 0) {
            int D = sc.nextInt();
            int[] di = new int[31];
            int[] pi = new int[31];
            for (int i = 0; i < D; i++) {
                int di_ = sc.nextInt();
                int pi_ = sc.nextInt();
                di[di_-1] = di_; 
                pi[di_-1] = pi_; 
            }
            int sum = 0;
            for (int i = 0; i < di.length; i++) {
                if (pi[i] > 0) {
                    sum += pi[i];
                }
                pi[i] = sum;
            }

            int Q = sc.nextInt();
            for (int i = 0; i < Q; i++) {
                int deadi = sc.nextInt();
                int reqi = sc.nextInt();
                if (pi[deadi - 1] >= reqi) {
                    System.out.println("Go Camp");
                } else {
                    System.out.println("Go Sleep");
                }
            }
        }
    }
}
