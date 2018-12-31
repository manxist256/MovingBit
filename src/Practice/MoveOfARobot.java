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
public class MoveOfARobot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = 0, y = 0; int dir = 1;
        // 1 - east //  2 - north // 3 - west // 4 - south
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'G') {
                switch(dir) {
                    case 1 : x += 1;
                        break;
                    case 2 : y += 1;
                        break;
                    case 3 : x -= 1;
                        break;
                    case 4 : y -= 1;
                        break;
                    default : //do none
                }
            } else {
                if (s.charAt(i) == 'L') {
                    switch(dir) {
                        case 1 : dir = 2;
                        break;
                        case 2 : dir = 3;
                            break;
                        case 3 : dir = 4;
                            break;
                        case 4 : dir = 1;
                            break;
                        default : //do none
                    }
                } else if (s.charAt(i) == 'R') {
                    switch(dir) {
                        case 1 : dir = 4;
                        break;
                        case 2 : dir = 1;
                            break;
                        case 3 : dir = 2;
                            break;
                        case 4 : dir = 3;
                            break;
                        default : //do none
                    }
                }
            }
        }
        System.out.println(x == 0 && y == 0 ? "Circular" : "Not-Circular");
    }
}
