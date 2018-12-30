/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.Lunchtime.December2018;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class AgeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int[] monthdays = new int[N];
            int[] cumulative = new int[N];
            int tdpy = 0;
            for (int i = 0; i < N; i++) {
                monthdays[i] = sc.nextInt();
                tdpy += monthdays[i];
                cumulative[i] = tdpy;
            }
            int cby = sc.nextInt(), cbm = sc.nextInt(), cbd = sc.nextInt();
            int yby = sc.nextInt(), ybm = sc.nextInt(), ybd = sc.nextInt();
            // calculate left out days in y year
            int j = cbd;
            
            if (cbm > 1) {
                j += cumulative[cbm - 2];
            }
            int rdays = (tdpy - j) + 1;
            
            if (cby % 4 == 0 && cbm == N && cbd > monthdays[cbm - 1]) { //leap yr situation
                rdays = 0;
            }
            
            int k = ybd;
            
            if (ybm > 1) {
                k += cumulative[ybm - 2];
            }
            
            int total = rdays + k;
            
            int inter = ((yby - cby) - 1) * tdpy;
            int lp = 0;
            
            for (int i = cby; i< yby; i++) {
                if (i % 4 == 0) {
                    lp++;
                }
            }
            
            System.out.println(total + inter + lp);
            
        }
    }
}
