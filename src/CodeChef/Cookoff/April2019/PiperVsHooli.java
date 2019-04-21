package CodeChef.Cookoff.April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PiperVsHooli implements Comparator {
    public int compare(Object o1, Object o2) {
        return (long)o1 < (long)o2 ? 1 : -1;
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] input = bufferedReader.readLine().split(" ");
            long N = Long.parseLong(input[0]);
            long A = Long.parseLong(input[1]);
            long B = Long.parseLong(input[2]);
            long X = Long.parseLong(input[3]);
            long Y = Long.parseLong(input[4]);
            long Z = Long.parseLong(input[5]);
            String[] C = bufferedReader.readLine().split(" ");
            PriorityQueue<Long> priorityQueue = new PriorityQueue(new PiperVsHooli());
            long Cs[] = new long[C.length];
            for (int i = 0; i < Cs.length; i++) {
                Cs[i] = Long.parseLong(C[i]);
                priorityQueue.add(Cs[i]);

            }
            long reqh = Z - B;
            long days = reqh / Y;
            if (reqh % Y == 0) {
                days--;
            }
            long actPip = A + (X * days), sr = Z - actPip;
            int ans = 0;
            while (sr > 0 && !priorityQueue.isEmpty()) {
                long poll = priorityQueue.poll();
                sr -= poll;
                ans++;
                if (poll / 2 > 0) {
                    priorityQueue.add(poll / 2);
                }
            }
            System.out.println(sr > 0 ? "RIP" : ans);
        }
    }
}
