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
public class IndexOfAnExtraElement {
    public static void main(String[] args) {
        int A[] = {2, 4, 6, 8, 9, 10, 12};
        int B[] = {2, 4, 6, 8, 10, 12};
        if (A.length > B.length) {
             for (int i = 0; i < B.length; i++) {
                 if (A[i] != B[i]) {
                     System.out.println(i);
                     return;
                 }
             }
             System.out.println(A.length - 1);
        } else if (A.length < B.length) {
             for (int i = 0; i < A.length; i++) {
                 if (A[i] != B[i]) {
                     System.out.println(i);
                     return;
                 }
             }
             System.out.println(B.length - 1);
        }
    }
}
