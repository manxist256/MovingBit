package CodeChef.Practice;

import java.util.Scanner;

public class VillageTribes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String s = scanner.nextLine();
            int ac = 0, bc = 0, k = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '.') {
                    if (s.charAt(i) == 65) {
                        ac++;
                    } else {
                        bc++;
                    }
                    k = i;
                    break;
                }
            }
            for (int i = k + 1; i < s.length(); i++) {
                if (s.charAt(i) == 65 || s.charAt(i) == 66) {
                    if (s.charAt(i) == s.charAt(k)) {
                        if (s.charAt(i) == 65) {
                            ac += (i - k - 1);
                        } else {
                            bc += (i - k - 1);
                        }
                    }
                    if (s.charAt(i) == 65) {
                        ac++;
                    } else {
                        bc++;
                    }
                    k = i;
                }
            }
            System.out.println(ac + " " + bc);
        }
    }
}
