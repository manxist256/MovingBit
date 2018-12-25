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
public class SumOfMiddleElementsOfTwoSortedArrays {
    public static void main(String[] args) {
        int A[] = {1, 11, 21, 31, 41};
        int B[] = {22, 33, 44, 55, 66};
        int C[] = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                C[k++] = A[i];
                i++;
            } else if (A[i] > B[j]) {
                C[k++] = B[j];
                j++;
            } else {
                C[k++] = A[i];
                i++; j++;
            }
        }
        while (i < A.length) {
            C[k++] = A[i++];
        }
        while (j < B.length) {
            C[k++] = B[j++];
        }
        System.out.println(C[C.length / 2] + C[C.length / 2 - 1]);
    }
}
