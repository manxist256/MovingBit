package CodeChef.Practice;

import java.util.Scanner;

public class DogsAndCats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            long C = scanner.nextLong();
            long D = scanner.nextLong();
            long counted = scanner.nextLong();
            long max = 4 * (C + D);
            long min;
            if (C > 2 * D) {
                min = 4 * ((C - 2 * D) + D);
            } else {
                min = 4 * D;
            }
            if (counted % 4 == 0 && counted >= min && counted <= max) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
