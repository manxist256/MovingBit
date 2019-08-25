package CodeChef.Practice;

import java.util.Scanner;

public class HowManyDigitsDoIHave {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int c = 0;
        while (N > 0) {
            c++;
            N /= 10;
        }
        System.out.println(c <= 3 ? c : "More than 3 digits");
    }
}
