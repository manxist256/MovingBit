package CodeChef.Practice;

import java.util.Scanner;

public class TrainPartner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int D = scanner.nextInt();
            int N = D % 8;
            int nC; String bc;
            if (N == 1 || N == 4) {
                nC = N == 1 ? 4 : 1;
                bc = "LB";
            } else if (N == 2 || N == 5) {
                nC = N == 2 ? 5 : 2;
                bc = "MB";
            } else if (N == 3 || N == 6) {
                nC = N == 3 ? 6 : 3;
                bc = "UB";
            } else {
                nC = N == 7 ? 8 : 7;
                bc = N == 7 ? "SU" : "SL";
            }
            int aC = D / 8;
            if (N == 0) {
                aC--;
            }
            System.out.println((aC*8)+nC + bc);
        }
    }
}
