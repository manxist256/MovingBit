
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Hackerrank.Hourrank._31;

/**
 *
 * @author mankank
 */
public class HangingPosters {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                long h = sc.nextLong();
                long[] wp = new long[n];
                long[] height = new long[n];
                for (int i = 0; i < n; i++) {
                        wp[i] = sc.nextLong();
                }
                for (int i = 0; i < n; i++) {
                        height[i] = sc.nextLong();
                }
                long max = 0;
                for (int i = 0; i < n; i++) {
                        double d = height[i] / 4;
                        double bolt = wp[i] - d;
                        double r = bolt - h;
                        long ladder = (long)Math.ceil(r);
                        if (ladder > max) {
                                max = ladder;
                        }
                }
                System.out.println(max);
        }
}
