package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class DaysInAMonth {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        map.put("mon", 0);
        map.put("tues", 1);
        map.put("wed", 2);
        map.put("thurs", 3);
        map.put("fri", 4);
        map.put("sat", 5);
        map.put("sun", 6);
        while (T-- > 0) {
            int[] days = {4, 4, 4, 4, 4, 4, 4};
            String[] strings = bufferedReader.readLine().split(" ");
            int daysInAMonth = Integer.parseInt(strings[0]);
            String day = strings[1];
            int rem = daysInAMonth - 28;
            int srd = (map.get(day)) % 7;
            for (int i = 0; i < rem; i++) {
                days[srd % 7]++;
                srd++;
            }
            for (int i = 0; i < days.length; i++) {
                printWriter.print(days[i] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
