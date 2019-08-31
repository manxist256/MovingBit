package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DevuAndArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]), Q = Integer.parseInt(strings[1]);
        int max = 0, min = Integer.MAX_VALUE;
        String[] nums = bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(nums[i]);
            if (v > max) {
                max = v;
            }
            if (v < min) {
                min = v;
            }
        }
        for (int i = 0; i < Q; i++) {
            int x = Integer.parseInt(bufferedReader.readLine());
            if (x >= min && x <= max) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
