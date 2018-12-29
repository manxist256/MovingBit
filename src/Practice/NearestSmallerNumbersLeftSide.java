/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mankank
 */
public class NearestSmallerNumbersLeftSide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                System.out.print("_ ");
            } else {
                while (!stack.isEmpty() && stack.peek() > array[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    System.out.print(stack.peek() + " ");
                }
                else {
                    System.out.print("_ ");
                }
            }
            stack.push(array[i]);
        }
    }
}
