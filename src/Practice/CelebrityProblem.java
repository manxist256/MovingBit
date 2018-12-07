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
public class CelebrityProblem {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int[][] known_matrix = new int[n][n];
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                known_matrix[i][j] = sc.nextInt();
                        }
                }
                ArrayList<Integer> peoples = new ArrayList();
                for (int i = 0; i < n; i++) {
                        peoples.add(i);
                }
                boolean chooseboth = true; int c1, c2 = 0, celebrity = 0;
                // assuming we always have one celebrity. If not we won't get proper answer by this logic.
                while (!peoples.isEmpty()) {
                        c1 = peoples.remove(0);
                        if (chooseboth) {
                                if (peoples.size() >= 1)
                                        c2 = peoples.remove(0);
                        } else {
                                c2 = celebrity;
                        }
                        if (known_matrix[c1][c2] == 0 && known_matrix[c2][c1] == 0) { // both doesn't know each other. Both can't be celebrity.
                                chooseboth = true;
                        } 
                        else if (known_matrix[c1][c2] == 0 && known_matrix[c2][c1] == 1) {
                                celebrity = c1; //c2 is not celebrity.
                                chooseboth = false;
                        } else if (known_matrix[c1][c2] == 1 && known_matrix[c2][c1] == 0) {
                                celebrity = c2;
                                chooseboth = false;
                        }  else if (known_matrix[c1][c2] == 1 && known_matrix[c2][c1] == 1) { // both can't be celebrity as each knows atleast one by now.
                                chooseboth = true;
                        }
                }
                System.out.println(celebrity);
        }
}
