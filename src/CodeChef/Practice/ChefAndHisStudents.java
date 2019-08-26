package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndHisStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String config = scanner.nextLine();
            int ans = 0;
            for (int i = 0; i < config.length() - 1; i++) {
                if (config.charAt(i) == '<' && config.charAt(i + 1) == '>') {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
