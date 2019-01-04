/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.January2019;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
class ChefAndDiffNeighbours {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String pattern1 = "1234", pattern2 = "3412";
        while (T-- > 0) {
            int N = sc.nextInt(), M = sc.nextInt();
            if (N == 1 && M == 1) {
                System.out.println(1);
                System.out.println(1);
            } else if (N == 2 && M == 2) {
                System.out.println(2);
                System.out.println(1 + " " + 2);
                System.out.println(1 + " " + 2);
            } else if (N * M == 6 && (N > 1 && M > 1)) {
                System.out.println(3);
                if (N == 2 && M == 3) {
                    System.out.println(1 + " " + 1 + " " + 2);
                    System.out.println(2 + " " + 3 + " " + 3);
                } else if (N == 3 && M == 2) {
                    System.out.println(1 + " " + 2);
                    System.out.println(1 + " " + 3);
                    System.out.println(2 + " " + 3);
                }
                    
            } else if (N == 1 || M == 1) {
                if (N * M == 2) {
                    System.out.println(1);
                    if (N == 1) {
                        System.out.println(1 + " " + 1);
                    } else {
                        System.out.println(1);
                        System.out.println(1);
                    }
                    continue;
                }
                System.out.println(2);
                if (N == 1) {
                    int s = 1, cntr = 0;
                    for (int i = 0; i < M; i++) {
                        System.out.print(s + " ");
                        cntr++;
                        if (cntr % 2 == 0) {
                            s = s == 2 ? 1 : 2;
                        }
                    }
                    System.out.println();
                } else if (M == 1) {
                    int s = 1, cntr = 0;
                    for (int i = 0; i < N; i++) {
                        System.out.println(s);
                        cntr++;
                        if (cntr % 2 == 0) {
                            s = s == 2 ? 1 : 2;
                        }
                    }
                }
            } else if (N == 2 || M == 2) {
                System.out.println(3);
                int sn = N == 2 ? M : N;
                int[][] arr = new int[2][sn];
                arr[1][0] = 2;
                for (int i = 0; i < 2; i++) {
                    int s;
                    if (i == 0) s = 1; else s = 3;
                    int cntr = 0;
                    for (int j = i; j < sn; j++) {
                        arr[i][j] = s;
                        cntr++;
                        if (cntr % 2 == 0) s++;
                        if (s == 4) s = 1;
                    }
                }
                if (N == 2) {
                    for (int i = 0; i < N; i++) {
                        for(int j = 0; j < M; j++) {
                            System.out.print(arr[i][j] + " ");
                        }
                        System.out.println();
                    }
                } else if (M == 2) {
                    for (int i = 0; i < N; i++) {
                        for(int j = 0; j < M; j++) {
                            System.out.print(arr[j][i] + " ");
                        }
                        System.out.println();
                    }
                }
            } else {
                String flip = ""; int cntr = 0;
                System.out.println(4);
                for (int i = 0; i < N; i++) {
                    int ptr = 0;
                    if (i == 0) {
                        flip = pattern1;
                    }
                    if (i > 0) {
                        if (i % 2 != 0) {
                            flip = flip.equals(pattern1) ? pattern2 : pattern1;
                        }
                    }
                    for (int j = 0; j < M; j++) {
                        System.out.print(flip.charAt(ptr) + " ");
                        ptr++;
                        if (ptr == 4) ptr = 0;
                    }
                    System.out.println();
                }
            }
        }
    }
}
