package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndHisDailyRoutine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int CE = Integer.MAX_VALUE, ES = Integer.MAX_VALUE, EE = Integer.MAX_VALUE, SS = Integer.MAX_VALUE;
            for (int i = 0; i < s.length(); i++) {
                char x = s.charAt(i);
                if (x == 'C') {
                    CE = i;
                } else if (x == 'E') {
                    if (ES == Integer.MAX_VALUE) {
                        ES = i;
                    }
                    EE = i;
                } else  {
                    if (SS == Integer.MAX_VALUE) {
                        SS = i;
                    }
                }
            }
            if (CE != Integer.MAX_VALUE) {
                if (!(CE < ES && CE < SS)) {
                    System.out.println("no");
                    continue;
                }
            }
            if (EE != Integer.MAX_VALUE) {
                if (!(EE < SS)) {
                    System.out.println("no");
                    continue;
                }
            }
            System.out.println("yes");
        }
    }
}
