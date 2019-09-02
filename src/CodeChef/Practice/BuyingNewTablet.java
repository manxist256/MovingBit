package CodeChef.Practice;

import java.util.Scanner;

public class BuyingNewTablet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T--> 0) {
            int N = scanner.nextInt(), R = scanner.nextInt();
            int area = -1;
            for (int i = 0; i < N; i++) {
                int wi = scanner.nextInt(), hi = scanner.nextInt(), pi = scanner.nextInt();
                if (pi <= R) {
                    int curr_area = wi * hi;
                    if (curr_area > area) {
                        area = curr_area;
                    }
                }
            }
            System.out.println(area == -1 ? "no tablet" : area);
        }
    }
}
