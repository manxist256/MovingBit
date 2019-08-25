package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class DevuAndBirthday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(scanner.nextInt());
            }
            System.out.println(set.size());
        }
    }
}
