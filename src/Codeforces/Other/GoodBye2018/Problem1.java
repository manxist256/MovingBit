
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Other.GoodBye2018;

/**
 *
 * @author mankank
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt(), b = sc.nextInt(), r = sc.nextInt();
        for (int i = r; i >= 0; i--) {
            if (b >= i - 1 && y >= i - 2) {
                System.out.println((i * 3) - 3);
                return;
            }
        }
    }
}
