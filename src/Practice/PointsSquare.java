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
public class PointsSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = new int[4];
        int[] y = new int[4];
        for (int i = 0; i < 4; i++) {
            x[i] = sc.nextInt(); y[i] = sc.nextInt();
        }
        System.out.println("---------");
        int[] sides = new int[4];
        //arrangement
        int x_f = x[0];
        if (x_f == x[2]) {
            int tx = x[2]; x[2] = x[1]; x[1] = tx;
            int ty = y[2]; y[2] = y[1]; y[1] = ty;
        } else if (x_f == x[3]) {
            int tx = x[3]; x[3] = x[1]; x[1] = tx;
            int ty = y[3]; y[3] = y[1]; y[1] = ty;
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(x[i] + " " +y[i]);
        }
        if (x[0] == x[1]) { //side length 1
            sides[0] = Math.abs(y[0] - y[1]);
        } 
        if (x[2] == x[3]) { //side length 2
            sides[1] = Math.abs(y[2] - y[3]);
        }
        sides[2] = Math.abs(x[0] - x[2]);
        sides[3] = Math.abs(x[1] - x[3]);
        System.out.println("---------");
        boolean square = true;
        for (int i = 0; i < sides.length - 1 ; i++) {
            System.out.println(sides[i]);
            if (!(sides[i] == sides[i + 1])) {
                square = false;
                break;
            }
        }
        System.out.println(square);
    }
}
