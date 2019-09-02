package CodeChef.Practice;

import java.util.Scanner;

public class GoodAndBadPersons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] strings = scanner.nextLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int K = Integer.parseInt(strings[1]);
            int diff = N - K;
            int sl = 0, cl = 0;
            String mess = scanner.nextLine();
            for (int i = 0; i < mess.length(); i++) {
                if (mess.charAt(i) >= 65 && mess.charAt(i) <= 90) {
                    cl++;
                } else {
                    sl++;
                }
            }
            if (sl < diff && cl < diff) {
                System.out.println("none");
            } else if (sl >= diff && cl >= diff) {
                System.out.println("both");
            } else if (sl >= diff) {
                System.out.println("chef");
            } else {
                System.out.println("brother");
            }
        }
    }
}
