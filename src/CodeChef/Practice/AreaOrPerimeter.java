package CodeChef.Practice;

import java.util.Scanner;

public class AreaOrPerimeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L = scanner.nextInt();
        int B = scanner.nextInt();
        int area = L * B;
        int peri = 2 * (L + B);
        System.out.println((area > peri) ? "Area" : (peri > area ? "Peri" : "Eq"));
        System.out.println((area > peri) ? area : (peri > area ? peri : area));
    }
}
