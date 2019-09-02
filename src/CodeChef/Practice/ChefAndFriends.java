package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int f = 0;
        outer : for (int i = 0; i < N; i++) {
            String user = scanner.nextLine();
            if (user.length() >= 2) {
                for (int j = 0; j <= user.length() - 2; j++) {
                    if ((user.charAt(j) == 'c' && user.charAt(j+1) == 'h')
                    ||(user.charAt(j) == 'h' && user.charAt(j+1) == 'e')
                    ||(user.charAt(j) == 'e' && user.charAt(j+1) == 'f')) {
                        f += 1;
                        continue outer;
                    }
                }
            }
        }
        System.out.println(f);
    }
}
