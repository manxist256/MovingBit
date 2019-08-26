package CodeChef.Practice;

import java.util.Scanner;

public class GregorianCalendar {

    static boolean leapYear(int i) {
        boolean leap = false;
        if (i % 100 == 0 && i % 400 != 0) {
            leap = false;
        } else if (i % 400 == 0 || i % 4 == 0) {
            leap =  true;
        }
        return leap;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[(5000) + 1];
        int day = 2;
        for (int i = 2000; i >= 0; i--) {
            int m = (leapYear(i) ? 366 : 365) % 7;
            int rem = 7 - m;
            day = (day + rem) % 7;
        }
        arr[0] = day; int j = 1;
        for (int i = 1; i <= 5000; i++) {
            int m = (leapYear(i - 1) ? 366 : 365) % 7;
            day = (day + m) % 7;
            arr[j++] = day;
        }
        int T = scanner.nextInt();
        while (T-- > 0) {
            try {
                int d = arr[scanner.nextInt()];
                switch (d) {
                    case 1:
                        System.out.println("sunday");
                        break;
                    case 2:
                        System.out.println("monday");
                        break;
                    case 3:
                        System.out.println("tuesday");
                        break;
                    case 4:
                        System.out.println("wednesday");
                        break;
                    case 5:
                        System.out.println("thursday");
                        break;
                    case 6:
                        System.out.println("friday");
                        break;
                    case 0:
                        System.out.println("saturday");
                        break;
                    default:
                        System.out.println("haha");
                }
            }
            catch(Exception e) {
                System.out.println("monday");
            }
        }
    }
}
