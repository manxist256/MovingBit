package CodeChef.Practice;

import java.util.Scanner;

public class ChefAndString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] arr = new int[4];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'C') {
                arr[0]++;
            } else if (s.charAt(i) == 'H') {
                if (arr[0] > 0) {
                    arr[1]++;
                    arr[0]--;
                }
            } else if (s.charAt(i) == 'E') {
                if (arr[1] > 0) {
                    arr[2]++;
                    arr[1]--;
                }
            } else if (s.charAt(i) == 'F') {
                if (arr[2] > 0) {
                    arr[3]++;
                    arr[2]--;
                }
            }
        }
        System.out.println(arr[3]);
    }
}
