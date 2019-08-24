package CodeChef.Practice;

import java.util.Scanner;

public class SumOrDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N1 = scanner.nextInt();
        int N2 = scanner.nextInt();
        if (N1 > N2) {
            System.out.println(N1 - N2);
        } else {
            System.out.println(N1 + N2);
        }
    }
}
