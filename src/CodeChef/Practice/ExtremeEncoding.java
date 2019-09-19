package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtremeEncoding {

    private static int binaryToDecimal(String b) {
        int result = 0;
        int i = 0;
        for (int j = b.length() - 1; j >= 0; j--) {
            result += ((b.charAt(j) - 48) * Math.pow(2, i++));
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine()) ;
        for (int m = 1; m <= T; m++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[] a = new int[N], b = new int[N];
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(bufferedReader.readLine());
                String binary = Integer.toBinaryString(n);
                String lastSixteen = "", ini = "";
                int k = binary.length() - 1, r = 0;
                while (k >= 0) {
                    lastSixteen = binary.charAt(k) + lastSixteen;
                    k--; r++;
                    if (r == 16) {
                        break;
                    }
                }
                while (k >= 0) {
                    ini = binary.charAt(k) + ini;
                    k--;
                }
                a[i] = binaryToDecimal(lastSixteen);
                b[i] = binaryToDecimal(ini);
            }
            printWriter.println("Case "+ m + ":");
            for (int i = 0; i < a.length; i++) {
                printWriter.print(a[i] + " ");
            }
            printWriter.println();
            for (int i = 0; i < a.length; i++) {
                printWriter.print(b[i] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
