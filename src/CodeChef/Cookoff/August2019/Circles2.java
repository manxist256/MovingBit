package CodeChef.Cookoff.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Circles2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            double x1 = Double.parseDouble(input[0]), y1 = Double.parseDouble(input[1]), r1 = Double.parseDouble(input[2]);
            double x2 = Double.parseDouble(input[3]), y2 = Double.parseDouble(input[4]), r2 = Double.parseDouble(input[5]);
            double maxInnerDist = Math.abs(r1 - r2), currDist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            if (r1 <= r2 && currDist <= maxInnerDist) {
                out.println("NO");
                continue;
            }
            out.println("YES");
            double dx = x1 - x2, dy = y1 - y2;
            double sinTheta = dy / currDist, cosTheta = dx / currDist;
            double opp = sinTheta * r1, adj = cosTheta * r1;
            out.println(x1 + adj + " " + (y1 + opp));
        }
        out.flush();
    }
}
