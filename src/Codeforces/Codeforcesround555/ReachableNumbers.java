package CodeChef.MoscowWorkshopsJunior2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ReachableNumbers {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        HashSet<Long> s = new HashSet<>();
        long D = N;
        do {
            s.add(N);
            N += 1;
            while (N % 10 == 0) {
                N /= 10;
            }
        } while(!s.contains(N));
        System.out.println(s.size());
    }
}
