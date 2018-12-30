///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
////package CodeChef.Lunchtime.December2018;
//
//import java.util.Scanner;
//
///**
// *
// * @author mankank
// */
//class ChoosingFromBuckets {
//    public static void main(String[] args) {
//        //System.out.printf("%.6f", (i/j));
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), k = sc.nextInt();
//        int[][] color = new int[n][k];
//        int[] tbb = new int[n];
//        for (int i = 0; i < n; i++) {
//            int c = 0;
//            for (int j = 0; j < k; j++) {
//                color[i][j] = sc.nextInt();
//                c += color[i][j];
//            }
//            tbb[i] = c;
//        }  
//        for (int i = 0; i < k; i++) {
//            float probability = 0;
//            for (int j = 0; j < n; j++) {
//                if (j == 0) {
//                    probability = (float)color[j][i] / tbb[j];
//                } else {
//                    if (probability == 0) {
//                        probability = (float)color[j][i] / (tbb[j] + 1);
//                        continue;
//                    }
//                    probability = probability * (float)(color[j][i] + 1) / (tbb[j] + 1);
//                }
//            }
//            System.out.printf("%.12f ", probability);
//        }
//    }
//}
