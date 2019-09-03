package CodeChef.LongChallenge.January2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class EartSeq {
    static ArrayList<Integer> sieve(int N, int K){
        long[] arr = new long[N + 1];
        Arrays.fill(arr, 1);
        arr[1] = 0;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;
            for (int j = 2; i * j <= N; j++) {
                arr[i * j] = 0;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = K; i < arr.length; i++) {
            if (arr[i] == 1) {
                arrayList.add(i);
                arrayList.add(i);
            }
        }
        return arrayList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        ArrayList<Integer> al1 = sieve(1000000, 3);
        ArrayList<Integer> al2 = sieve(500, 7);
        al1.remove(0);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine()) - 2;
            int K = N;
            printWriter.print(6 + " ");
            int m1 = 0, m2 = 0, cp = 0;
            int last1 = -1, last2 = -1;
            while (N-- > 0) {
                printWriter.print(al1.get(m1) * al2.get(m2) + " ");
                last1 = al1.get(m1);
                last2 = al2.get(m2);
                cp++;
                m1++;
                m2++;
                if (cp == 100) {
                    m2 = 0;
                    cp = 0;
                }
            }
            if (K % 2 == 0) {
                printWriter.print(last1 * 2);
            } else {
                printWriter.print(last2 * 2);
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
