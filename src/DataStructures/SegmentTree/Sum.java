/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructures.SegmentTree;

import java.util.Scanner;

/**
 *
 * @author mankank
 */
public class Sum {
        private static int find2PowN(int N) {
                int i = 0;
                while (true) {
                        if (N <= Math.pow(2, i++)) {
                                break;
                        }
                }
                return (int)Math.pow(2, i - 1);
        }
    
        private static void constructSegmentTree(int[] input, int[] segmentTree) {
                constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);
        }
        
        private static int constructSegmentTree(int[] input, int[] segmentTree, int low, int high, int pos) {
                if (low == high) {
                        segmentTree[pos] = input[low];
                        return input[low];
                }
                int mid = (low + high) / 2;
                int l =constructSegmentTree(input, segmentTree, low, mid, 2 * pos + 1);
                int r = constructSegmentTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
                segmentTree[pos] = l + r;
                return l + r;
        }
        
        private static void rangedQueries(int[] segmentTree, int n1, int n2, int N) {
                int min = rangedQueries(segmentTree, n1, n2, 0, N - 1, 0);
                System.out.println(min);
        }
        
        private static int rangedQueries(int[] segmentTree, int x, int y, int low, int high, int pos) {
                if (y < low || x > high) { // no overlap
                        return 0;
                } else if (low >= x && high <= y) { // total overlap
                        return segmentTree[pos];
                } else { //partial overlap
                        int mid = (low + high) / 2;
                        int l = rangedQueries(segmentTree, x, y, low, mid, 2 * pos + 1);
                        int r = rangedQueries(segmentTree, x, y, mid + 1, high, 2 * pos + 2);
                        return l + r;
                }
        }
        
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int N = sc.nextInt();
                int[] segmentTree = new int[find2PowN(N)*2  - 1];
                int[] input = new int[N];
                for (int i = 0; i < N; i++) {
                        input[i] = sc.nextInt();
                }
                constructSegmentTree(input, segmentTree);
                for (int i = 0; i < segmentTree.length; i++) {
                        System.out.print(segmentTree[i] + " ");
                }
                System.out.println();
                System.out.println("Enter Ranged Queries : ");
                while (true) {
                        int n1 = sc.nextInt(), n2 = sc.nextInt();
                        rangedQueries(segmentTree, n1, n2, N);
                }
        }
}
