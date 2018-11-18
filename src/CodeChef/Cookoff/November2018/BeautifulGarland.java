package CodeChef.Cookoff.November2018;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Cookoff.Novermber2019;

/**
 *
 * @author mankank
 */
class BeautifulGarland {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = Integer.parseInt(sc.nextLine());
                while (T-- > 0) {
                        String s = sc.nextLine(); int gC = 0, rC = 0, c = 0;
                        for (int i = 0; i < s.length(); i++) {
                                if (s.charAt(i) == 'G') 
                                        gC++;
                                else 
                                        rC++;

                                if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) 
                                        c++;
                                else if (i == s.length() - 1 && s.charAt(0) == s.charAt(s.length() - 1)) 
                                        c++;
                        }
                        if (Math.abs(gC - rC) != 0 || c > 2) 
                                System.out.println("no");
                        else 
                                System.out.println("yes");
                }
        }
}
