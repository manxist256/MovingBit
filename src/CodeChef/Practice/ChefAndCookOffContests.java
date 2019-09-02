package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndCookOffContests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[5];
            for (int i = 0; i < N; i++) {
                String level = scanner.nextLine();
                if (level.equals("cakewalk")) {
                    arr[0] = 1;
                } else if (level.equals("simple")) {
                    arr[1] = 1;
                } else if (level.equals("easy")) {
                    arr[2] = 1;
                } else if (level.equals("easy-medium") || level.equals("medium")) {
                    arr[3] = 1;
                } else if (level.equals("medium-hard") || level.equals("hard")) {
                    arr[4] = 1;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    System.out.println("No");
                    continue outer;
                }
            }
            System.out.println("Yes");
        }
    }
}
