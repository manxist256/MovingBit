package CodeChef.Practice;

import java.util.Scanner;

public class BeautifulArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            int gt1 = 0, z = 0, po = 0, mo = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] != 0 && arr[i] != 1 && arr[i] != -1) {
                    gt1++;
                } else if (arr[i] == 0) {
                    z++;
                } else if (arr[i] == 1) {
                    po++;
                } else if (arr[i] == -1) {
                    mo++;
                }
            }
            if (N == 1) {
                System.out.println("yes");
            }
            else if (gt1 > 1) {
                System.out.println("no");
            } else {
                if (mo == 1) {
                    if (gt1 == 1) {
                        System.out.println("no");
                    } else {
                        System.out.println("yes");
                    }
                } else if (mo > 1) {
                    if (po == 0) {
                        System.out.println("no");
                    } else {
                        System.out.println(gt1 == 1 ? "no" : "yes");
                    }
                } else {
                    System.out.println("yes");
                }
            }
        }
    }
}
