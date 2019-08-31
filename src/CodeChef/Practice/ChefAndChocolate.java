package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndChocolate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            System.out.println((n*m)%2==0?"Yes":"No");
        }
    }
}
