package CodeChef.Practice;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
//        int space = (N - 1) * 2;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < space; j++) {
//                System.out.print(" ");
//            }
//            space -= 2;
//            for (int j = i + 1; j > 0; j--) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        int space = N - 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < space; j++) {
                System.out.print(" ");
            }
            space--;
            for (int j = 0; j < (i + 1); j++) {
                System.out.print(1 + " ");
            }
            System.out.println();
        }

    }
}
