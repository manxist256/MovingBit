
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.January2019;

/**
 *
 * @author mankank
 */
class LuckyNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long T = sc.nextInt();
        while (T-- > 0) {
            long N = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong();
            long ac = 0, bc = 0, common = 0;
            for (long i = 0; i < N; i++) {
                long v = sc.nextLong();
                if (v % a == 0 && v % b == 0) {
                    common++;
                    continue;
                }
                if (v % a == 0) {
                    bc++;
                } 
                if (v % b == 0){ 
                    ac++;
                }
            }
            if (common > 1) {
                bc += 1;
            }
            if (bc > ac) {
                System.out.println("BOB");
            } else {
                System.out.println("ALICE");
            }
        }
    }
}
