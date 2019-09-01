package CodeChef.Practice;

import java.util.Scanner;

public class SnakesAndMongooses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            if (s.length() == 1) {
                System.out.println(s.charAt(0) == 'm' ? "mongooses" : "snakes");
            } else {
                int sc = 0, mc = 0;
                int[] arr = new int[s.length()];
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'm') {
                        mc++;
                    } else {
                        sc++;
                    }
                }
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == 'm') {
                        if (i == 0) {
                            if (s.charAt(1) == 's') {
                                arr[1] = 1;
                                sc--;
                            }
                        } else if (i == s.length() - 1) {
                            if (s.charAt(s.length() - 2) == 's' && arr[s.length() - 2] == 0) {
                                sc--;
                            }
                        } else {
                            if (s.charAt(i - 1) == 's' && arr[i - 1] == 0) {
                                sc--;
                            } else if (s.charAt(i + 1) == 's') {
                                sc--;
                                arr[i + 1] = 1;
                            }
                        }
                    }
                }
                System.out.println(sc > mc ? "snakes" : (sc == mc ? "tie" : "mongooses"));
            }
        }
    }
}
