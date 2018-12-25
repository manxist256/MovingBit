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
public class ConstructMirrorTree {
    
    private static void constructMirrorTree(int[] array) {
        int mt[] = new int[array.length];
        int s = 0, e = 0, k = s;
        while (s < array.length) {
            int ending = e;
            for (int i = e; i >= s; i--) {
                mt[k++] = array[ending--];
            }
            s = e + 1;
            e = s * 2;
            k = s;
        }
        for (int i = 0; i < mt.length; i++) {
            System.out.print(mt[i] + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        constructMirrorTree(array);
    }
}
