/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.January2019;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author mankank
 */
class FancyQuotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        outer : while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(sc.nextLine());
            while (tokenizer.hasMoreTokens()) {
                if (tokenizer.nextToken().equals("not")) {
                    System.out.println("Real Fancy");
                    continue outer;
                }
            }
            System.out.println("regularly fancy");
        }
    }
}
