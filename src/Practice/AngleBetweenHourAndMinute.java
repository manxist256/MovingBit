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
public class AngleBetweenHourAndMinute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hour = sc.nextInt(), min = sc.nextInt();
        double hd = (min / 60) * 30, hm = ((min % 5) / 5) * 30; int md = (int)min / 5;
        double a1;
        if (hd > 0) {
            a1 = Math.abs((30 - hd) + hm + (md - (hour + 1)) * 30);
        } else { //when min = 0
            a1 = hour * 30;
        }
        System.out.println(a1 + " " + (360 - a1));
    }
}
