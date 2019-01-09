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
public class EfficientPgmToReverseBitsOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 0;
        while (!(N >= (1 << i) && N < (1 << (i + 1)))) {
            i++;
        }
        int fi =  N - ((int)Math.pow(2, i));
        int li = ((int)Math.pow(2, i + 1) - 1) - fi;
        StringBuilder builder = new StringBuilder(Integer.toBinaryString(li));
        builder.replace(0, 1, "0");
        System.out.println(builder.toString());
    }
}
