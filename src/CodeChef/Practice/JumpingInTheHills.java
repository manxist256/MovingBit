package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class JumpingInTheHills {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int U = Integer.parseInt(strings[1]);
            int D = Integer.parseInt(strings[2]);
            String[] hills = bufferedReader.readLine().split(" ");
            boolean p_used = false;
            int ans = 1;
            for (int i = 0; i < N - 1; i++) {
                int curr = Integer.parseInt(hills[i]);
                int nextHill = Integer.parseInt(hills[i + 1]);
                if (curr <= nextHill) {
                    if ((nextHill - curr) <= U)
                        ans++;
                    else
                        break;
                } else if (curr > nextHill) {
                    if ((curr - nextHill) <= D) {
                        ans++;
                    } else {
                        if (!p_used) {
                            ans++;
                            p_used = true;
                        } else {
                            break;
                        }
                    }
                }
            }
            printWriter.println(ans);
        }
        printWriter.flush();
    }
}
