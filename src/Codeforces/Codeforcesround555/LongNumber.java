package CodeChef.MoscowWorkshopsJunior2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongNumber {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        String num = bufferedReader.readLine();
        String[] fd = bufferedReader.readLine().split(" ");
        int[] fx =  new int[9];
        for (int i = 0; i < 9; i++) {
            fx[i] = Integer.parseInt(fd[i]);
        }
        StringBuilder builder = new StringBuilder("");
        boolean start = false, stop = false;
        for (int i = 0; i < N; i++) {
            int d = num.charAt(i) - '0';
            if (start && !stop && fx[d - 1] < d) {
                stop = true;
            }
            if (fx[d - 1] > d && !stop) {
                d = fx[d - 1];
                start = true;
            }
            builder.append(d);
        }
        System.out.println(builder.toString());
    }
}
