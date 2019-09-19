package CodeChef.Encoding2019;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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
        return segmentTree[pos] = sum;
    }

    private static int rangedQueries(int[] segmentTree, int n1, int n2, int N) {
        return rangedQueries(segmentTree, n1, n2, 0, N - 1, 0);
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
            if (low == x && high == y) {
                int c = (data == 'a' || data ==  'e' || data == 'i' || data == 'o' || data == 'u') ? 1 : 0;
                return segmentTree[pos] = c;
            }
            return segmentTree[pos];
        }
        int mid = (low + high) / 2;
        int l = update(x, y ,data, segmentTree, low, mid, 2 * pos + 1);
        int r = update(x, y, data, segmentTree, mid + 1, high, 2 * pos + 2);
        return segmentTree[pos] = l + r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String s = bufferedReader.readLine();
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] segmentTree = new int[find2PowN(s.length()) * 2 - 1];
            char[] input = new char[s.length()];
            for (int i = 0; i < s.length(); i++) {
                input[i] = s.charAt(i);
            }
            constructSegmentTree(input, segmentTree);
            while (N-- > 0) {
                String[] query = bufferedReader.readLine().split(" ");
                char type = query[0].charAt(0);
                if (type == 'F') {
                    printWriter.println(rangedQueries(segmentTree, Integer.parseInt(query[1])  - 1, Integer.parseInt(query[2])  - 1, s.length()));
                } else {
                    update(Integer.parseInt(query[1])  - 1, Integer.parseInt(query[1])  - 1, query[2].charAt(0), segmentTree, s.length());
                }
            }
        }
        printWriter.flush();
    }
}
