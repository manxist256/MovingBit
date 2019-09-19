package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArchiAndComparision {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            long a = Long.parseLong(strings[0]);
            long b = Long.parseLong(strings[1]);
            long n = Long.parseLong(strings[2]);
            if (a >= 0 && b >= 0) {
                printWriter.println(a > b ? 1 : (a < b ? 2 : 0));
            } else if (a < 0 && b < 0) {
                boolean neven = n % 2 == 0;
                long a1 = Math.abs(a), b1 = Math.abs(b);;
                if (neven) {
                    printWriter.println(a1 > b1 ? 1 : (a1 < b1 ? 2 : 0));
                } else {
                    printWriter.println(a1 < b1 ? 1 : (a1 > b1 ? 2 : 0));
                }
            } else if (a >= 0 && b < 0) {
                long a1 = Math.abs(a), b1 = Math.abs(b);;
                boolean neven = n % 2 == 0;
                if (neven) {
                    printWriter.println(a1 > b1 ? 1 : (a1 < b1 ? 2 : 0));
                } else {
                    printWriter.println(1);
                }
            } else {
                long a1 = Math.abs(a), b1 = Math.abs(b);
                boolean neven = n % 2 == 0;
                if (neven) {
                    printWriter.println(a1 > b1 ? 1 : (a1 < b1 ? 2 : 0));
                } else {
                    printWriter.println(2);
                }
            }
        }
        printWriter.flush();
    }
}
