package CodeChef.Encoding2019;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author mankank
 */
//Segment tree to find min of ranged queries in a array
public class Problem6 {

    private static int find2PowN(int N) {
        int i = 0;
        while (true) {
            if (N <= Math.pow(2, i++)) {
                break;
            }
        }
        return (int)Math.pow(2, i - 1);
    }

    private static void constructSegmentTree(char[] input, int[] segmentTree) {
        constructSegmentTree(input, segmentTree, 0, input.length - 1, 0);
    }

    private static int constructSegmentTree(char[] input, int[] segmentTree, int low, int high, int pos) {
        if (low == high) {
            int c = (input[low] == 'a' || input[low] ==  'e' || input[low] == 'i' || input[low] == 'o' || input[low] == 'u') ? 1 : 0;
            return segmentTree[pos] = c;
        }
        int mid = (low + high) / 2;
        int l = constructSegmentTree(input, segmentTree, low, mid, 2 * pos + 1);
        int r = constructSegmentTree(input, segmentTree, mid + 1, high, 2 * pos + 2);
        int sum = l + r;
        segmentTree[pos] = sum;
        return sum;
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

    private static void update(int x, int y, char data, int[] segmentTree, int N) { //update segmentTree without lazy
        update(x, y, data, segmentTree, 0, N - 1, 0);
    }

    private static int update(int x, int y, char data, int[] segmentTree, int low, int high, int pos) {
        if (y < low || x > high) { // no overlap
            return segmentTree[pos];
        }
        if (low == high) {
            if (low >= x && low <= y) {
                int c = (data == 'a' || data ==  'e' || data == 'i' || data == 'o' || data == 'u') ? 1 : 0;
                return segmentTree[pos] = c;
            }
            return segmentTree[pos];
        }
        int mid = (low + high) / 2;
        int l = update(x, y ,data, segmentTree, low, mid, 2 * pos + 1);
        int r = update(x, y, data, segmentTree, mid + 1, high, 2 * pos + 2);
        int sum = l + r;
        return segmentTree[pos] = sum;
    }

    private static void updateWithlazy(int x, int y, char data, int[] segmentTree, int[] lazyTree, int N) { //update segmentTree without lazy
        updateWithLazyTree(x, y, data, segmentTree, lazyTree, 0, N - 1, 0);
    }

    private static int updateWithLazyTree(int x, int y, char data, int[] segmentTree, int[] lazyTree, int low, int high, int pos) {
        if (lazyTree[pos] != 0) {
            segmentTree[pos] += lazyTree[pos];
            int lc = 2 * pos + 1; int rc = 2 * pos + 2;
            if (lc < lazyTree.length) {
                lazyTree[lc] += lazyTree[pos];
            }
            if (rc < lazyTree.length) {
                lazyTree[rc] += lazyTree[pos];
            }
            lazyTree[pos] = 0;
        }
        if (y < low || x > high) { // no overlap
            return segmentTree[pos];
        }
        if (low >= x && high <= y) { //total overlap
            segmentTree[pos] += data;
            int lc = 2 * pos + 1, rc = 2 * pos + 2;
            if (lc < lazyTree.length) {
                lazyTree[lc] += data;
            }
            if (rc < lazyTree.length) {
                lazyTree[rc] += data;
            }
            return segmentTree[pos];
        }
        // partial overlap
        int mid = (low + high) / 2;
        int l = updateWithLazyTree(x, y, data, segmentTree, lazyTree, low, mid, 2 * pos + 1);
        int r = updateWithLazyTree(x, y, data, segmentTree, lazyTree, mid + 1, high, 2 * pos + 2);
        int sum = l + r;
        segmentTree[pos] = sum;
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int N = Integer.parseInt(scanner.nextLine());
            int[] segmentTree = new int[find2PowN(s.length()) * 2 - 1];
            char[] input = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                input[i] = s.charAt(i);
                //System.out.print(input[i] + " ");
            }
            constructSegmentTree(input, segmentTree);
//            for (int i = 0; i < segmentTree.length; i++) {
//                //System.out.print(segmentTree[i] + " ");
//            }

            while (N-- > 0) {
                String[] query = scanner.nextLine().split(" ");
                char type = query[0].charAt(0);
                if (type == 'F') {
                    rangedQueries(segmentTree, (query[1].charAt(0) - 48) - 1, (query[2].charAt(0) - 48) - 1, s.length());
                } else {
                    update((query[1].charAt(0) - 48) - 1, (query[1].charAt(0) - 48) - 1, query[2].charAt(0), segmentTree, s.length());
                }
//                int data = sc.nextInt();
//                updateWithlazy(x, y, data, segmentTree, lazyTree, N);
//                for (int i = 0; i < segmentTree.length; i++) {
//                    System.out.print(segmentTree[i] + " ");
//                }
//                System.out.println();
//                for (int i = 0; i < segmentTree.length; i++) {
//                    System.out.print(lazyTree[i] + " ");
//                }
//                System.out.println();
            }
        }
    }
}
