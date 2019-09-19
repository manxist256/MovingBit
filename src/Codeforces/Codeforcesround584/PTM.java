import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class PTM {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(bufferedReader.readLine());
        String[] strings = bufferedReader.readLine().split(" ");
        int[] arr = new int[strings.length];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(strings[i]);
            set.add(arr[i]);
        }
        Arrays.sort(arr);
        int c = 0;
        for (int i = 0; i < N; i++) {
            int value = arr[i];
            if (!set.contains(value)) {
                continue;
            }
            for (int j = 1; j <= 100; j++) {
                if (set.contains(value * j)) {
                    set.remove(value * j);
                }
            }
            c++;
        }
        printWriter.println(c);
        printWriter.flush();
    }
}
