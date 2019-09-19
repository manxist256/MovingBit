package CodeChef.Practice;

import java.util.Scanner;

public class LifeLimited {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String r1 = scanner.nextLine();
            String r2 = scanner.nextLine();
            String r3 = scanner.nextLine();
            if ((r1.charAt(0) == 'l' && r2.charAt(0) == 'l' && r2.charAt(1) == 'l')
                || (r1.charAt(1) == 'l' && r2.charAt(1) == 'l' && r2.charAt(2) == 'l')
                || (r2.charAt(0) == 'l' && r3.charAt(0) == 'l' && r3.charAt(1) == 'l')
                || (r2.charAt(1) == 'l' && r3.charAt(1) == 'l' && r3.charAt(2) == 'l')) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
