package CodeChef.Practice;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        outer : for (int i = 0; i <T ; i++) {
            String s = scanner.nextLine();
            int[] arr = new int[52];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) >= 97 && s.charAt(j) <= 122) {
                    int index = s.charAt(j) - 97;
                    arr[index]++;
                } else {
                    int index = s.charAt(j) - 65;
                    arr[index + 26]++;
                }
            }
            int twz = 0;
            for (int j = 0; j < 52; j++) {
                if (arr[j] > 0) {
                    twz++;
                }
            }
            int[] arr2 = new int[twz]; int pk = 0;
            for (int j = 0; j < 52; j++) {
                if (arr[j] == 0) {
                    continue;
                }
                arr2[pk++] = arr[j];
            }
            Arrays.sort(arr2);
            for (int j = 2; j < arr2.length; j++) {
                if (!(arr2[j] == arr2[j-1]+arr2[j-2])) {
                    System.out.println("Not");
                    continue outer;
                }
            }
            System.out.println("Dynamic");
        }
    }
}
