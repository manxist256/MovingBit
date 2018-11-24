
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround524;

/**
 *
 * @author mankank
 */
public class BestPresent {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int T = sc.nextInt();
                while (T-- > 0) {
                        long n1 = sc.nextLong(), n2 = sc.nextLong();
                        long r = n2 - n1;
                        if (r % 2 != 0) { //even num elements present
                                if (n1 % 2 != 0) {
                                    System.out.println((r+1)/2);
                                }
                                else {
                                    System.out.println(-((r+1)/2));
                                }
                        } else { //odd num elements present
                                if (n1 % 2 != 0) {
                                    System.out.println(((r)/2) - n2);
                                }
                                else {
                                    System.out.println(-((r+1)/2) + n2);
                                }
                        }
                }
        }
}
