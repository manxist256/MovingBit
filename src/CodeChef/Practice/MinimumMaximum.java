package CodeChef.Practice;

        import java.util.Scanner;

public class MinimumMaximum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), min = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                int hellohelloenkadhaali = scanner.nextInt();
                if (hellohelloenkadhaali < min) {
                    min = hellohelloenkadhaali;
                }
            }
            System.out.println((long)min * (N - 1));
        }
    }
}
