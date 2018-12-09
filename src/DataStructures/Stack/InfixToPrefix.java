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
public class InfixToPrefix {
    
        private static void populatePrecedence(Map<Character, Integer> map) {
                //ADD / SUB HAS LOWER PRECEDENCE COMPARED TO MUL / DIV.
                map.put('+', 1);
                map.put('-', 1);
                map.put('*', 2);
                map.put('/', 2);
        }
        
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String infix = sc.nextLine(), prefix = "";
                java.util.Stack<Character> stack = new java.util.Stack();
                Map<Character, Integer> map = new HashMap<>();
                populatePrecedence(map);
                for (int i = infix.length() - 1; i >= 0; i--) {
                        if (infix.charAt(i) >= 97 && infix.charAt(i) <= 122) {
                                prefix = infix.charAt(i) + prefix;
                                continue;
                        }
                        if (stack.isEmpty()) {
                                stack.push(infix.charAt(i));
                        }
                        else if (map.get(stack.peek()) > map.get(infix.charAt(i))) {
                                while (!stack.isEmpty()) {
                                    prefix = stack.pop() + prefix;
                                }
                                stack.push(infix.charAt(i));
                        } else if (map.get(stack.peek()) < map.get(infix.charAt(i))) {
                                stack.push(infix.charAt(i));
                        } else { //same precedence
                                prefix = stack.pop() + prefix;
                                stack.push(infix.charAt(i));
                        }
                }
                while (!stack.isEmpty()) {
                        prefix = stack.pop() + prefix;
                }
                System.out.println(prefix);
        }
}
