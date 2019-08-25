package CodeChef.CypherAugust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(strings[0]);
            int K = Integer.parseInt(strings[1]);
            int[] arr = new int[N];
            String[] sks = bufferedReader.readLine().split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(sks[i]);
            }
            HashSet<Integer> bt = new HashSet<>();
            String[] sk2 = bufferedReader.readLine().split(" ");
            int[] arr2 = new int[K];
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = Integer.parseInt(sk2[i]);
                bt.add(arr2[i]);
            }
            for (int i = 0; i < N; i++) {
                if (!bt.contains(arr[i])) {
                    printWriter.print(arr[i] + " ");
                }
            }
            for (int i = 0; i < arr2.length; i++) {
                printWriter.print(arr2[i] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
