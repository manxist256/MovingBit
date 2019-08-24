package CodeChef.Practice;

import java.util.Scanner;

public class DecrementORIncrement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short s = scanner.nextShort();
        System.out.println(s % 4 == 0 ? s + 1 : s - 1);
    }
}
