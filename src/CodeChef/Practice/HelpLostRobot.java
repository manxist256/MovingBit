package CodeChef.Practice;

import java.util.Scanner;

public class HelpLostRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            if (x1 == x2) {
                if (y2 > y1) {
                    System.out.println("up");
                } else {
                    System.out.println("down");
                }
            } else if (y1 == y2) {
                if (x2 < x1) {
                    System.out.println("left");
                } else {
                    System.out.println("right");
                }
            } else {
                System.out.println("sad");
            }
        }
    }
}
