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
public class InfixToPostfix {
    
        private static void populatePrecedence(Map<Character, Integer> map) {
                //ADD / SUB HAS LOWER PRECEDENCE COMPARED TO MUL / DIV.
                map.put('+', 1);
                map.put('-', 1);
                map.put('*', 2);
                map.put('/', 2);
        }
        
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String infix = sc.nextLine(), postfix = "";
                java.util.Stack<Character> stack = new java.util.Stack();
                Map<Character, Integer> map = new HashMap<>();
                populatePrecedence(map);
                for (int i = 0; i < infix.length(); i++) {
                        if (infix.charAt(i) >= 97 && infix.charAt(i) <= 122) {
                                postfix += infix.charAt(i);
                                continue;
                        }
                        if (stack.isEmpty()) {
                                stack.push(infix.charAt(i));
                        }
                        else if (map.get(stack.peek()) > map.get(infix.charAt(i))) {
                                while (!stack.isEmpty()) {
                                    postfix += stack.pop();
                                }
                                stack.push(infix.charAt(i));
                        } else if (map.get(stack.peek()) < map.get(infix.charAt(i))) {
                                stack.push(infix.charAt(i));
                        } else { //same precedence
                                postfix += stack.pop();
                                stack.push(infix.charAt(i));
                        }
                }
                while (!stack.isEmpty()) {
                        postfix += stack.pop();
                }
                System.out.println(postfix);
        }
}
