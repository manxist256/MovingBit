
import java.util.ArrayList;
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
public class PowersOf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] potwo = new int[32];
        for (int i = 0; i < potwo.length; i++) {
            potwo[i] = (int)Math.pow(2, i);
            //System.out.println(potwo[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (k > 0) {
            int sub = 1;
            for (int i = potwo.length - 1; i >= 0; i--) {
                if (n >= potwo[i] && (n - potwo[i]) >= k - 1) {
                    sub = potwo[i];
                    list.add(potwo[i]);
                    break;
                }
            }
            n -= sub;
            k -= 1;
        }
        if (n > 0 || n < 0) {
            System.out.println("NO");
        } else if (n == 0) {
            System.out.println("YES");
            for (int i : list) {
                System.out.print(i + " ");
            }
        }
    }
}
