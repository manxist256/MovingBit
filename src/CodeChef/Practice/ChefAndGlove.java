package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndGlove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] fingers = new int[N];
            for (int i = 0; i < N; i++ ) {
                fingers[i] = scanner.nextInt();
            }
            int[] gloves = new int[N];
            for (int i = 0; i < N; i++ ) {
                gloves[i] = scanner.nextInt();
            }
            boolean front = true, back = true;
            for (int i = 0; i < N; i++) {
                if (fingers[i] > gloves[i]) {
                    front = false;
                    break;
                }
            }
            for (int i = 0; i < N; i++) {
                if (fingers[i] > gloves[N-1-i]) {
                    back = false;
                    break;
                }
            }
            if (front && back) {
                System.out.println("both");
            } else if (!front && !back) {
                System.out.println("none");
            } else if (front) {
                System.out.println("front");
            } else {
                System.out.println("back");
            }
        }
    }
}
