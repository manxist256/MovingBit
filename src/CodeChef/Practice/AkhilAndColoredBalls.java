package CodeChef.Practice;

import java.util.Scanner;

public class AkhilAndColoredBalls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String X = scanner.nextLine();
            String Y = scanner.nextLine();
            for (int i = 0; i < X.length(); i++) {
                if (X.charAt(i) == Y.charAt(i)) {
                    if (X.charAt(i) == 'W') {
                        System.out.print('B');
                    } else {
                        System.out.print('W');
                    }
                } else {
                    System.out.print('B');
                }
            }
            System.out.println();
        }
    }
}
