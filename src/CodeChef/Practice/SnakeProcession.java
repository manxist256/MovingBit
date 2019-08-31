package CodeChef.Practice;

import java.util.Scanner;

public class SnakeProcession {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String procession = scanner.nextLine();
            int Hc = 0, Tc = 0; char prev = ' ';
            for (int i = 0; i < procession.length(); i++) {
                if (procession.charAt(i) == 'H') {
                    Hc++;
                } else if (procession.charAt(i) == 'T') {
                    Tc++;
                }
                if (procession.charAt(i) == 'T' || procession.charAt(i) == 'H') {
                    if ((prev == ' ' && procession.charAt(i) == 'T') || (prev != ' ' && prev == procession.charAt(i))) {
                        System.out.println("Invalid");
                        continue outer;
                    }
                    prev = procession.charAt(i);
                }
            }
            System.out.println((Hc == Tc) ? "Valid" : "Invalid");
        }
    }
}
