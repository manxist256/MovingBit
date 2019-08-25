package CodeChef.Encoding2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NutellaLovesCakewalk {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] array = bufferedReader.readLine().split(" ");
            int max = 0, min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                int value = Integer.parseInt(array[i]);
                if (value < min) {
                    min = value;
                }
                if (value > max) {
                    max = value;
                }
            }
            System.out.println(min + " " + max);
        }
    }
}
