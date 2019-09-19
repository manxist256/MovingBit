package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class ClosingTheTweets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(strings[0]);
        int K = Integer.parseInt(strings[1]);
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < K; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            if (strings1[0].equals("CLOSEALL")) {
                set.clear();
                printWriter.println(0);
            } else {
                int T = Integer.parseInt(strings1[1]);
                if (set.contains(T)) {
                    set.remove(T);
                } else {
                    set.add(T);
                }
                printWriter.println(set.size());
            }
        }
        printWriter.flush();
    }
}
