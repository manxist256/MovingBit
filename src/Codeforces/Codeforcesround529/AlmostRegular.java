///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
////package Codeforces.Codeforcesround529;
//
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// *
// * @author mankank
// */
//public class AlmostRegular {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//        String b = sc.nextLine();
//        if (N % 2 != 0) {
//            System.out.println(0);
//        } else {
//            Stack stack = new Stack();
//            Stack<Integer> number = new Stack();
//            int kq = 0; boolean kqf = false; int kqi = 0;
//            for (int i = 0; i < b.length(); i++) {
//                if (b.charAt(i) == '(') {   
//                    stack.push(b.charAt(i));
//                    number.push(i);
//                }
//                else {
//                    if (!stack.isEmpty()) {
//                        number.pop();
//                        stack.pop();
//                    } else {
//                        kq++;
//                        if (!kqf) {
//                            kqf = true;
//                            kqi = i;
//                        }
//                    }
//                }
//            }
//            if (kq == 2 && stack.isEmpty()) {
//                int c = 0;
//                for (int i = kqi; i >= 0; i--) {
//                    if (b.charAt(i) == ')') {
//                        c++;
//                    }
//                }
//                System.out.println(c);
//            }
//            else if (stack.size() == 2) {
//                int lp = number.pop(), opening = 0;
//                for (int i = lp; i < b.length(); i++) {
//                    if (b.charAt(i) == '(') {
//                        opening++;
//                    }
//                }
//                System.out.println(opening);
//            } else {
//                System.out.println(0);
//            }
//        }
//    }
//}
