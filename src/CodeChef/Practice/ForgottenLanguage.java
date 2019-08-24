package CodeChef.Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ForgottenLanguage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            String[] fgtnwords = scanner.nextLine().split(" ");
            Map<String, Boolean> map = new HashMap<>();
            for (int i = 0; i < fgtnwords.length; i++) {
                map.put(fgtnwords[i], false);
            }
            for (int i = 0; i < K; i++) {
                String[] phrase = scanner.nextLine().split(" ");
                for (int j = 1; j < phrase.length; j++) {
                    String wtc = phrase[j];
                    if (map.containsKey(wtc) && !map.get(wtc)) {
                        map.put(wtc, true);
                    }
                }
            }
            for (String word : fgtnwords) {
                System.out.print(map.get(word) ? "YES " : "NO ");
            }
            System.out.println();
        }
    }
}
