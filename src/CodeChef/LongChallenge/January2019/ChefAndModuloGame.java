/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.January2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author mankank
 */
class ChefAndModuloGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            long N = Long.parseLong(s[0]);
            long P = Long.parseLong(s[1]);
            long remainder =  N % (N / 2 + 1);
            long pk = N / 2 + 1;

            long ifirst = (P - remainder) * (P - remainder), m = P - N;
            long isecond = 0;
            if (P > N) {
                isecond += (m * 1 * (P - remainder));
            }
            long ithird = 0;
            if (P > N) {
                ithird += (m * m * 1);
            }
            if (remainder == 0) {
                System.out.println(P * P * P);
            }
            else if (remainder > P || pk > P) {
                System.out.println(0);  
            }
            else {
                System.out.println(ifirst + isecond + ithird);
            }
        }
    }
}
