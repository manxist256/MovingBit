/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.December2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author mankank
 */
class ChefAndAnIdealProblem {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(System.out);
                pw.println(3);
                pw.flush();
                int read = Integer.parseInt(br.readLine());
                pw.println(read == 1 ? 2 : 1);
                pw.flush();
        }
}
