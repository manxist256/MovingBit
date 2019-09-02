package CodeChef.Practice;

import java.util.Scanner;

public class CodersLifeMatters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            String[] strings = scanner.nextLine().split(" ");
            int prev = strings[0].charAt(0);
            int ctgs = 1;
            for (int i = 1; i < strings.length; i++) {
                if (prev == strings[i].charAt(0)) {
                    ctgs++;
                } else {
                    ctgs = 1;
                }
                if (ctgs > 5 && strings[i].charAt(0) == 49) {
                    System.out.println("#coderlifematters");
                    continue outer;
                }
                prev = strings[i].charAt(0);
            }
            System.out.println("#allcodersarefun");
        }
    }
}
