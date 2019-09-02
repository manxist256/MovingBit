package CodeChef.Lunchtime.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class DestroyCells_Practice {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] inputs = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);
            int M = Integer.parseInt(inputs[1]);
            int[] hero1 = new int[N*M];
            int[] hero2 = new int[N*M];
            for (int i = 0; i < hero1.length; i++) {
                hero1[i] = i;
            }
            int k = 0, r = 0, c = 0;
            for (int i = 0; i < hero2.length; i++) {
                if (c == 0) {
                    hero2[i] = k;
                    c++;
                    continue;
                }
                k += M;
                hero2[i] = k;
                c++;
                if (c % N == 0) {
                    c = 0;
                    k = ++r;
                }
            }
            printWriter.print(N*M + " ");
            for (int i = 2; i <= N*M; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < hero1.length; j+=i) {
                    set.add(hero1[j]);
                    set.add(hero2[j]);
                }
                printWriter.print(set.size() + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
