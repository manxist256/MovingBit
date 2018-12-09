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
public class PrefixToInfix {
    
        private static void populatePrecedence(Map<Character, Integer> map) {
                //ADD / SUB HAS LOWER PRECEDENCE COMPARED TO MUL / DIV.
                map.put('+', 1);
                map.put('-', 1);
                map.put('*', 2);
                map.put('/', 2);
        }
    
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String prefix = sc.nextLine(), infix = "";
                java.util.Stack<Character> stack = new java.util.Stack();
                Map<Character, Integer> map = new HashMap<>();
                populatePrecedence(map);
                for (int i = 0; i < prefix.length(); i++) {
                        if (!(prefix.charAt(i) >= 97 && prefix.charAt(i) <= 122)) { 
                                if (stack.isEmpty()) {
                                        stack.push(prefix.charAt(i));
                                } else if (map.get(stack.peek()) == map.get(prefix.charAt(i))) {
                                        infix += stack.peek();
                                        stack.push(prefix.charAt(i));
                                } else {
                                        stack.push(prefix.charAt(i));
                                }
                        }
                        else {
                                infix += prefix.charAt(i);
                                if(!stack.isEmpty())
                                        infix += stack.pop();
                        }
                }
                while (!stack.isEmpty()) {
                        infix += stack.pop();
                }
                System.out.println(infix);
        }
}
