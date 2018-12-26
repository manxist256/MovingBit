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
public class ParanthesisChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brackets = sc.nextLine();
        Stack stack = new Stack();
        boolean balanced = true;
        for (int i = 0; i < brackets.length(); i++) {
            char b = brackets.charAt(i);
            if (b == '(' || b == '{' || b == '[') {
                stack.push(b);
                continue;
            }
            if (!(b == '}' && (char)stack.peek() == '{' 
                    || b == ')' && (char)stack.peek() == '('
                    || b == ']' && (char)stack.peek() == '[')) {
                balanced = false;
                break;
            } else {
                stack.pop();
            }
        }
        System.out.println(balanced ? "Balanced" : "Not-Balanced");
    }
}
