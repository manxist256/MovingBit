/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class LCM {
    
        private static final int N = 200;

        private static void buildPF(int[] prime_factorization) {
                prime_factorization[0] = 2; int index = 1;
                outer : for (int i = 3; i < 1224; i++) {
                        for (int j = 2; j < i; j++) {
                                if (i % j == 0) {
                                        continue outer;
                                }
                        }
                    prime_factorization[index++] = i;
                    if (index == N) 
                            return;
                }
        }

        private static int LCM(int[] prime_factorization, int... a) {
                int L = 1;
                int n1 = a[0], n2 = a[1];
                HashMap<Integer, Integer> pf1 = new HashMap<>();
                HashMap<Integer, Integer> pf2 = new HashMap<>();
                while (n1 != 1) {
                        for (int i = 0; i < prime_factorization.length; i++) {
                                if (n1 % prime_factorization[i] == 0) {
                                        if (!pf1.containsKey(prime_factorization[i])) {
                                                pf1.put(prime_factorization[i], 1);
                                        } else {
                                                int ev = pf1.get(prime_factorization[i]);
                                                pf1.put(prime_factorization[i], ++ev);
                                        }
                                        n1 /= prime_factorization[i];
                                        break;
                                }
                        }
                }
                while (n2 != 1) {
                        for (int i = 0; i < prime_factorization.length; i++) {
                                if (n2 % prime_factorization[i] == 0) {
                                        if (!pf2.containsKey(prime_factorization[i])) {
                                                pf2.put(prime_factorization[i], 1);
                                        } else {
                                                int ev = pf2.get(prime_factorization[i]);
                                                pf2.put(prime_factorization[i], ++ev);
                                        }
                                        n2 /= prime_factorization[i];
                                        break;
                                }
                        }
                }
                for (Map.Entry<Integer, Integer> etr : pf1.entrySet()) {
                        int key = etr.getKey(); int c1 = etr.getValue();
                        if (!pf2.containsKey(key)) {
                            continue;
                        } 
                        int c2 = pf2.get(key);
                        int max = Math.max(c1, c2);
                        L *= (Math.pow(key, max));
                }
                for (Map.Entry<Integer, Integer> etr : pf1.entrySet()) {
                        int key = etr.getKey(); int c = etr.getValue();
                        if (!pf2.containsKey(key)) {
                            L *= (Math.pow(key, c));
                        } 
                }
                for (Map.Entry<Integer, Integer> etr : pf2.entrySet()) {
                        int key = etr.getKey(); int c = etr.getValue();
                        if (!pf1.containsKey(key)) {
                            L *= (Math.pow(key, c));
                        } 
                }
                return L;
        }

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int[] prime_factorization = new int[N];
                buildPF(prime_factorization);
                
                int N = sc.nextInt(), LCM = 0;
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                for (int i = 1; i < N; i++) {
                        if (i == 1) {
                                LCM = LCM (prime_factorization ,arr[0], arr[1]);
                                continue;
                        }
                        LCM = LCM (prime_factorization, LCM, arr[i]);
                }
                System.out.println(LCM);
        }
}
