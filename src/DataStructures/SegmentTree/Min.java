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
//Segment tree to find min of ranged queries in a array
public class Min {
    
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
                int min = Math.min(l, r);
                segmentTree[pos] = min;
                return min;
        }
        
        private static void rangedQueries(int[] segmentTree, int n1, int n2, int N) {
                int min = rangedQueries(segmentTree, n1, n2, 0, N - 1, 0);
                System.out.println(min);
        }
        
        private static int rangedQueries(int[] segmentTree, int x, int y, int low, int high, int pos) {
                if (y < low || x > high) { // no overlap
                        return Integer.MAX_VALUE;
                } else if (low >= x && high <= y) { // total overlap
                        return segmentTree[pos];
                } else { //partial overlap
                        int mid = (low + high) / 2;
                        int l = rangedQueries(segmentTree, x, y, low, mid, 2 * pos + 1);
                        int r = rangedQueries(segmentTree, x, y, mid + 1, high, 2 * pos + 2);
                        return Math.min(l, r);
                }
        }
        
        private static void update(int pos, int data, int[] segmentTree, int N) { //update segmentTree without lazy
                update(pos, data, segmentTree, 0, N - 1, 0);
        }
        
        private static int update(int upos, int data, int[] segmentTree, int low, int high, int pos) {
                if (low == high) {
                        if (low == upos) { // or high == upos
                                segmentTree[pos] = data;
                        }
                        return segmentTree[pos];
                }
                int mid = (low + high) / 2;
                int l = update(upos, data, segmentTree, low, mid, 2 * pos + 1);
                int r = update(upos, data, segmentTree, mid + 1, high, 2 * pos + 2);
                int min = Math.min(l, r);
                segmentTree[pos] = min;
                return min;
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
                /*while (true) {
                        int n1 = sc.nextInt(), n2 = sc.nextInt();
                        rangedQueries(segmentTree, n1, n2, N);
                }*/
                /*while (true) {
                        int pos = sc.nextInt();
                        int data = sc.nextInt();
                        update(pos, data, segmentTree, N);
                        for (int i = 0; i < segmentTree.length; i++) {
                                System.out.print(segmentTree[i] + " ");
                        }
                        System.out.println();
                }*/
        }
}
