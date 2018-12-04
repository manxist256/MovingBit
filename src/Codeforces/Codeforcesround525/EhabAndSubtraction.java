
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package DataStructures.SegmentTree;

/**
 *
 * @author mankank
 */
//Segment tree to find min of ranged queries in a array
class EnabAndSubtraction {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt(), K = sc.nextInt();
                int[] arr = new int[N];
                for (int i = 0; i < N; i++) {
                        arr[i] = sc.nextInt();
                }
                int ptr = 0, cumulative = 0, fp = 0;
                Arrays.sort(arr);
                for (int i = 0; i < N; i++) {
                        if (arr[i] == 0) {
                                ptr++;
                        }
                }
                for (int i = 0; i < K && ptr < N; i++) {
                        arr[ptr] -= cumulative;
                        int min = arr[ptr];
                        arr[ptr] = 0;
                        cumulative += min;
                        System.out.println(min);
                        fp++;
                        while (ptr < N && arr[ptr] - cumulative <= 0) {
                                ptr++;
                        }
                }
                for (int i = 0; i < (K - fp); i++) {
                        System.out.println(0);
                }
        }
}
