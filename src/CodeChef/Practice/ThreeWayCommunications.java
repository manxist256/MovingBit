package CodeChef.Practice;

import java.util.Scanner;

public class ThreeWayCommunications {

    private static boolean possible(int x1, int y1, int x2, int y2, double maxD) {
        if (y1 == y2) {
            return Math.abs(x1 - x2) <= maxD;
        } else if (x1 == x2) {
            return Math.abs(y1 - y2) <= maxD;
        } else {
            int r1 = Math.abs(x1 - x2);
            int r2 = Math.abs(y1 - y2);
            double hyp = Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2));
            return hyp <= maxD;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- >0) {
            int maxD = scanner.nextInt();
            int[][] dist = new int[3][2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    dist[i][j] = scanner.nextInt();
                }
            }
            boolean possible1 = possible(dist[0][0], dist[0][1], dist[1][0], dist[1][1], maxD)
                    && possible(dist[0][0], dist[0][1], dist[2][0], dist[2][1], maxD);
            boolean possible2 = possible(dist[0][0], dist[0][1], dist[1][0], dist[1][1], maxD)
                    && possible(dist[1][0], dist[1][1], dist[2][0], dist[2][1], maxD);
            boolean possible3 = possible(dist[0][0], dist[0][1], dist[2][0], dist[2][1], maxD)
                    && possible(dist[2][0], dist[2][1], dist[1][0], dist[1][1], maxD);
            if (possible1 || possible2 || possible3) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
