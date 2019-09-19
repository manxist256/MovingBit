package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class TestingRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] strings = scanner.nextLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int X = Integer.parseInt(strings[0]);
            String s = scanner.nextLine();
            HashSet<Integer> set = new HashSet<>();
            set.add(X);
            for (int i = 0; i < N; i++) {
                if (s.charAt(i) == 'L') {
                    X--;
                } else {
                    X++;
                }
                set.add(X);
            }
            System.out.println(set.size());
        }
    }
}
