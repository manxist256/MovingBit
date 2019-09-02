package CodeChef.Practice;

import java.util.Scanner;

public class Laddu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] md = scanner.nextLine().split(" ");
            int N = Integer.parseInt(md[0]);
            int laddus = 0;
            for (int i = 0; i < N; i++) {
                String[] input = scanner.nextLine().split( " ");
                switch(input[0]) {
                    case "CONTEST_WON" : int rank = Integer.parseInt(input[1]);
                        laddus += 300;
                        if (rank < 20) {
                            laddus += (20 - rank);
                        }
                        break;
                    case "TOP_CONTRIBUTOR" : laddus += 300;
                        break;
                    case "BUG_FOUND" : laddus += Integer.parseInt(input[1]);
                        break;
                    case "CONTEST_HOSTED" : laddus += 50;
                        break;
                }
            }
            System.out.println(md[1].equals("INDIAN") ? laddus / 200 : laddus / 400);
        }
    }
}
