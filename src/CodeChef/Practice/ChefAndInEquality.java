package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChefAndInEquality {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while(T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            int c = Integer.parseInt(strings[2]);
            int d = Integer.parseInt(strings[3]);
            if (d <= a) {
                printWriter.println(0);
            } else if (b < c) {
                printWriter.println(((long)(b-a)+1)*((d-c)+1));
            } else {
                long ans = 0;
                for (int x = a; x <= b; x++) {
                    if (x < c) {
                        ans += (d-c+1);
                    } else if (x >= d) {
                        ans += 0;
                    } else {
                        ans += (d-x);
                    }
                }
                printWriter.println(ans);
            }
        }
        printWriter.flush();
    }
}
