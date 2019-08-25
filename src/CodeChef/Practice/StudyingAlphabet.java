package CodeChef.Practice;

import java.util.HashSet;
import java.util.Scanner;

public class StudyingAlphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        HashSet<Character> jeffKnows = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            jeffKnows.add(s.charAt(i));
        }
        int N = Integer.parseInt(scanner.nextLine());
        outer : for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            for (int i1 = 0; i1 < word.length(); i1++) {
                if (!jeffKnows.contains(word.charAt(i1))) {
                    System.out.println("No");
                    continue outer;
                }
            }
            System.out.println("Yes");
        }
    }
}
