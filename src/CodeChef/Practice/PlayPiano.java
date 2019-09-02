package CodeChef.Practice;

import java.util.Scanner;

public class PlayPiano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i += 2) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    System.out.println("no");
                    continue outer;
                }
            }
            System.out.println("yes");
        }
    }
}
