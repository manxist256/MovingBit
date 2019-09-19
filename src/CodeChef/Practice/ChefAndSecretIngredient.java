package CodeChef.Practice;

        import java.util.Scanner;

public class ChefAndSecretIngredient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt(), X = scanner.nextInt();
            boolean yes = false;
            for (int i = 0; i < N; i++) {
                if (scanner.nextInt() >= X) {
                    yes = true;
                }
            }
            System.out.println(yes ? "YES" : "NO");
        }
    }
}
