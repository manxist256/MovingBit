
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Codeforces.Codeforcesround529;

/**
 *
 * @author mankank
 */
public class RepeatingCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int i = 0, ptr = 0;
        while(ptr < s.length()) {
            System.out.print(s.charAt(ptr));
            i = i + 1;
            ptr += i;
        }
    }
}
