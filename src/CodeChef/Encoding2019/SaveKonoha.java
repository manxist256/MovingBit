package CodeChef.Encoding2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SaveKonoha {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T-- > 0) {
            String input[] = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int power = Integer.parseInt(input[1]);
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            String sol[] = bufferedReader.readLine().split(" ");
            for (int i = 0; i < sol.length; i++) {
                priorityQueue.add(Integer.parseInt(sol[i]));
            }
            int c = 0;
            while (power > 0) {
                int v = priorityQueue.poll();
                power -= v;
                int newpow = v / 2;
                if (newpow > 0) {
                    priorityQueue.add(newpow);
                }
                if (power > 0 && priorityQueue.isEmpty()) {
                    System.out.println("Evacuate");
                    continue outer;
                }
                c++;
            }
            System.out.println(c);
        }
    }
}
