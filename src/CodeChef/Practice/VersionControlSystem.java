package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class VersionControlSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int total = scanner.nextInt();
            int ignored = scanner.nextInt();
            int tracked = scanner.nextInt();
            Set<Integer> ignoredS = new HashSet<>();
            for (int i = 0; i < ignored; i++) {
                ignoredS.add(scanner.nextInt());
            }
            Set<Integer> trackedS = new HashSet<>();
            for (int i = 0; i < tracked; i++) {
                trackedS.add(scanner.nextInt());
            }
            int a = 0, b = 0;
            for (int i = 1; i <= total; i++) {
                if (ignoredS.contains(i) && trackedS.contains(i)) {
                    a++;
                }
                if (!ignoredS.contains(i) && !trackedS.contains(i)) {
                    b++;
                }
            }
            System.out.println(a + " " + b);
        }
    }
}
