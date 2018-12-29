/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class FindIfTwoRectangleOverlap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] r1 = new int[4], r2 = new int[4];
        //Note : please enter co-ordinates of each rectangle in following order,
        // 1. top left coordinate
        // 2. bottom right coordinate
        for (int i = 0; i < r1.length; i++) {
            r1[i] = sc.nextInt();
        }
        for (int i = 0; i < r2.length; i++) {
            r2[i] = sc.nextInt();
        }
        //r[0] && r[2] mentions x-axis and //r[1] && r[3] mentions y-axis
        if (r2[0] <= r1[2] && r2[0] >= r1[0] || r2[2] <= r1[2] && r2[2] >= r1[0]) { //x-axis lies between
            if (r2[1] >= r1[3] && r2[1] <= r1[1] || r2[3] >= r1[3] && r2[3] <= r1[1]) { //y-axis lies between
                System.out.println("YES");
                return;
            } 
        }
        System.out.println("NO");
    }
}
