/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

/**
 *
 * @author mankank
 */
public class MirrorTree {
    
    private static boolean checkMirrorTree(int[] A, int[] B) {
        int s1 = 0, e1 = 0, t = 1;
        while (s1 < A.length) {
            int t1 = s1, t2 = e1;
            for (int i = 0; i < t; i++) {
                System.out.println(t1 + " " +t2);
                if (A[t1] != B[t2]) {
                    return false;
                }
                t1++; t2--;
            }
            s1 = e1 + 1; 
            e1 = s1 * 2;
            t = 2 * t;
            if (e1 > A.length) { 
                e1 = A.length - 1;
                t = A.length - s1;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] B = {1, 3, 2, 7, 6, 5, 4, 11, 10, 9, 8};
        boolean mirror = checkMirrorTree(A, B);
        System.out.println(mirror);
    }
}
