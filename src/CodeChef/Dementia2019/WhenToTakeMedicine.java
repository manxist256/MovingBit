package CodeChef.Dementia2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhenToTakeMedicine {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] s = bufferedReader.readLine().split(":");
            int year = Integer.parseInt(s[0].trim());
            int month = Integer.parseInt(s[1].trim());
            int date = Integer.parseInt(s[2].trim());
            boolean ly = false;
            if (year % 400 == 0) {
                ly = true;
            } else if (year % 100 != 0 && year % 4 == 0) {
                ly = true;
            }
            int[] ref;
            if (ly) {
                int[] j = {1, 2, 3, 5, 7, 8, 10, 12};
                ref = j;
            }
            else {
                int[] j = {1, 3, 5, 7, 8, 10, 12};
                ref = j;
            }
            int ans = 0;
            boolean fm = true; //stops at 1st month
            if (!fmf(ref, month)) {
                fm = false; // go to next month
            }
            if (!fm) {
                if (month == 2) { // not a leap year
                    System.out.println((28-date)/2 + 1 + (date % 2 == 0 ? 15 : 16));
                } else {
                    System.out.println((30-date)/2 + 1 + (date % 2 == 0 ? 15 : 16));
                }
            } else {
                if (month == 2) { // leap year
                    System.out.println((29-date) / 2 + 1);
                } else {
                    System.out.println((31-date) / 2 + 1);
                }
            }
        }
    }
    static boolean fmf(int[] ref, int month) {
        for (int i = 0; i < ref.length; i++) {
            if (ref[i] == month) {
                return true;
            }
        }
        return false;
    }
}
