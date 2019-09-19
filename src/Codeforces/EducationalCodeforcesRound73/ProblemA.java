import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class ProblemA {

    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    private static boolean getAns(HashMap<Long, Integer> map, long number) {
        if (map.containsKey(number) && map.get(number) > 0) {
            int ev = map.get(number);
            map.put(number, --ev);
            return true;
        }
        if (number == 1) {
            return false;
        }
        long div = number / 2;
        boolean left = getAns(map, div);
        boolean right = getAns(map, div);
        return left && right;
    }

    private static void solve() throws Exception {
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            String[] inputs = bufferedReader.readLine().split(" ");
            long[] array = new long[N];
            HashMap<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                array[i] = Long.parseLong(inputs[i]);
                if (!map.containsKey(array[i])) {
                    map.put(array[i], 0);
                }
                int ev = map.get(array[i]);
                map.put(array[i], ++ev);
            }
            printWriter.println(getAns(map, 2048) ? "YES" : "NO");
        }
    }

    public static void main(String[] args) throws Exception {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        printWriter = new PrintWriter(System.out);
        solve();
        printWriter.flush();
    }
}
