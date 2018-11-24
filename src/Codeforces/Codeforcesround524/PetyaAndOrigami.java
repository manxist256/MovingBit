
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Codeforces.Codeforcesround524;

/**
 *
 * @author mankank
 */
public class PetyaAndOrigami {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                long n = sc.nextLong(), k = sc.nextLong();
                long r = n * 2, g = n * 5, b = n * 8;
                System.out.println((r % k == 0 ? r / k : r / k + 1) + (g % k == 0 ? g / k : g / k + 1) + (b % k == 0 ? b / k : b / k + 1));
        }
}
