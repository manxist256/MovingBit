package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndTT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int chef = 0, opponent = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) - 48 == 0) {
                    opponent++;
                } else {
                    chef++;
                }
                if (chef == 11 && opponent <= 9) {
                    System.out.println("WIN");
                } else if (opponent == 11 && chef <= 9) {
                    System.out.println("LOSE");
                } else if (chef >= 10 && opponent >= 10) {
                    if (opponent - chef == 2) {
                        System.out.println("LOSE");
                    } else if (chef - opponent == 2) {
                        System.out.println("WIN");
                    }
                }
            }
        }
    }
}
