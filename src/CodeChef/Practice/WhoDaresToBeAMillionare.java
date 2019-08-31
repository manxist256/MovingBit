package CodeChef.Practice;

import java.util.Scanner;

public class WhoDaresToBeAMillionare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(scanner.nextLine());
            String aa = scanner.nextLine();
            String bb = scanner.nextLine();
            String[] strings = scanner.nextLine().split(" ");
            int c = 0;
            for (int i = 0; i < N; i++) {
                if (aa.charAt(i) == bb.charAt(i)) {
                    c++;
                }
            }
            int maxV = 0;
            for (int i = 0; i < c+1; i++) {
                int cc = Integer.parseInt(strings[i]);
                if (cc > maxV) {
                    maxV = cc;
                }
            }
            if(c == N) maxV = Integer.parseInt(strings[N]);
            System.out.println(maxV);
        }
    }
}
