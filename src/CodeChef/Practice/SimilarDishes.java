package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class SimilarDishes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] ing1 = scanner.nextLine().split(" ");
            String[] ing2 = scanner.nextLine().split(" ");
            HashSet<String> set = new HashSet();
            for (int i = 0; i < 4; i++) {
                set.add(ing1[i]);
                set.add(ing2[i]);
            }
            if (set.size() > 6) {
                System.out.println("dissimilar");
            } else {
                System.out.println("similar");
            }
        }
    }
}
