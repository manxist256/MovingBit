/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author mankank
 */

class Pair$1 {
    int i, j, sum;
    public Pair$1(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}

public class FindFourElementsThatSumToAGnValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Pair$1> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                pairs.add(new Pair$1(i, j, arr[i] + arr[j]));
            }
        }
        int X = sc.nextInt();
        outer : for (Pair$1 op : pairs) {
            for (Pair$1 ip : pairs) {
                if (op == ip) continue;
                if (op.sum + ip.sum == X && op.i != ip.i && op.i != ip.j && op.j != ip.i && op.j != ip.j) {
                    System.out.println(arr[op.i] + " " + arr[op.j] + " " + arr[ip.i] + " " + arr[ip.j]);
                    break outer;
                }
            }
        }
    }
}
