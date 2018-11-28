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
public class VaysaAndBook {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                while (T-- > 0) {
                    long n = sc.nextLong(), x = sc.nextLong(), y = sc.nextLong(), d = sc.nextLong();
                    if (y > x) {
                            long ans1 = -1, ans2 = -1;
                            if ((y-x) % d == 0) {
                                System.out.println((y-x) / d);
                                continue;
                            }
                            if ((y-x) % d != 0 && (y - 1) % d == 0) {
                                ans1 = (x - 1) % d == 0 ? (x - 1) / d : (x - 1) / d + 1;
                                ans1 += (y - 1) / d;
                            } 
                            if ((y-x) % d != 0 && (n - y) % d == 0) {
                                ans2 = (n - x) % d == 0 ? (n - x) / d : (n - x) / d + 1;
                                ans2 += (n - y) / d;
                            }
                            if (ans1 == ans2 && ans1 == -1) {
                                System.out.println(-1);
                            } else if (ans1 == -1) {
                                System.out.println(ans2);
                            } else if (ans2 == -1) {
                                System.out.println(ans1);
                            } else
                                System.out.println((int)Math.min(ans1, ans2));
                    } else if (y < x) {
                            long ans1 = -1, ans2 = -1;
                            if ((x - y) % d == 0) {
                                System.out.println((x-y) / d);
                                continue;
                            } 
                            if ((x - y) % d != 0 && (y - 1) % d == 0) {
                                    ans1 = (x - 1) % d == 0 ? (x - 1) / d : (x - 1) / d + 1;
                                    ans1 += (y - 1) / d;
                            } 
                            if ((x - y) % d != 0 && (n - y) % d == 0) {
                                    ans2 = (n - x) % d == 0 ? (n - x) / d : (n - x) / d + 1;
                                    ans2 += (n - y) / d;
                            }
                            if (ans1 == ans2 && ans1 == -1) {
                                System.out.println(-1);
                            } else if (ans1 == -1) {
                                System.out.println(ans2);
                            } else if (ans2 == -1) {
                                System.out.println(ans1);
                            } else
                                System.out.println((int)Math.min(ans1, ans2));
                    }else {
                        System.out.println(0);
                    }
                }
        }
}
