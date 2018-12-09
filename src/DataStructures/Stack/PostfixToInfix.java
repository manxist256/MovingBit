/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class PostfixToInfix {
    
        private static void populatePrecedence(Map<Character, Integer> map) {
                //ADD / SUB HAS LOWER PRECEDENCE COMPARED TO MUL / DIV.
                map.put('+', 1);
                map.put('-', 1);
                map.put('*', 2);
                map.put('/', 2);
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String postfix = sc.nextLine(), infix = "";
                java.util.Stack<Character> stack = new java.util.Stack();
                Map<Character, Integer> map = new HashMap<>();
                populatePrecedence(map);
                for (int i = postfix.length() - 1; i >= 0; i--) {
                        if (!(postfix.charAt(i) >= 97 && postfix.charAt(i) <= 122)) { 
                                if (stack.isEmpty()) {
                                        stack.push(postfix.charAt(i));
                                } else if (map.get(stack.peek()) == map.get(postfix.charAt(i))) {
                                        infix = stack.peek() + infix;
                                        stack.push(postfix.charAt(i));
                                } else {
                                        stack.push(postfix.charAt(i));
                                }
                        }
                        else {
                                infix = postfix.charAt(i) + infix;
                                if(!stack.isEmpty())
                                        infix = stack.pop() + infix;
                        }
                }
                while (!stack.isEmpty()) {
                        infix = stack.pop() + infix;
                }
                System.out.println(infix);
        }
}
