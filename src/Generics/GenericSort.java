/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generics;

/**
 *
 * @author mankank
 */
public class GenericSort {
    private static <T extends Comparable> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int l = i;
            for (int j = i; j < array.length; j++) {
                if (array[l].compareTo(array[j]) > 0) {
                    l = j;
                }
            }
            T temp = array[i];
            array[i] = array[l];
            array[l] = temp;
        }
    }
    public static void main(String[] args) {
        Integer[] I = {5, 4, -11, 0 , 21, 56, 12};
        sort(I);
        for (Integer Int : I) {
            System.out.print(Int + " ");
        }
        System.out.println();
        String[] string = {"B", "X", "A", "G", "LL", "AX", "BD", "FI", "M", "C"};
        sort(string);
        for (String str : string) {
            System.out.print(str + " ");
        }
    }
}
