/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround523;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Coins {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                long n = sc.nextLong(), s = sc.nextLong();
                System.out.println(s % n == 0 ? s / n : (s / n + 1));
        }
}
