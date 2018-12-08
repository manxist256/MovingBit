/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.December2018;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class ChefAndInteractiveContests {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), r = sc.nextInt();
                while (N-- > 0) {
                        int rating = sc.nextInt();
                        System.out.println(rating >= r ? "Good boi" : "Bad boi");
                }
        }
}
