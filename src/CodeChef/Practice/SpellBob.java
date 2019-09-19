package CodeChef.Practice;

import java.io.PrintWriter;
import java.util.Scanner;

public class SpellBob {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            if (((s1.charAt(0) == 'o' || s2.charAt(0) == 'o') && (s1.charAt(1) == 'b' || s2.charAt(1) == 'b') && (s1.charAt(2) == 'b' || s2.charAt(2) == 'b'))
            || ((s1.charAt(1) == 'o' || s2.charAt(1) == 'o') && (s1.charAt(0) == 'b' || s2.charAt(0) == 'b') && (s1.charAt(2) == 'b' || s2.charAt(2) == 'b'))
            || ((s1.charAt(2) == 'o' || s2.charAt(2) == 'o') && (s1.charAt(1) == 'b' || s2.charAt(1) == 'b') && (s1.charAt(0) == 'b' || s2.charAt(0) == 'b'))) {
                printWriter.println("yes");
            } else {
                printWriter.println("no");
            }
            printWriter.flush();
        }
    }
}
