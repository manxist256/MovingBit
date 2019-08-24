package CodeChef.Practice;

import java.util.Scanner;

public class Malavika {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        while (N-- > 0) {
            String m = scanner.nextLine();
            int a = 0, b = 0;
            for (int i = 0; i < m.length(); i++) {
                if (m.charAt(i) == 'a') {
                    a++;
                } else {
                    b++;
                }
            }
            System.out.println(Math.min(a, b));
        }
    }
}
