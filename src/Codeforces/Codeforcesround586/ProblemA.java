import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int K = Integer.parseInt(bufferedReader.readLine());
        String s = bufferedReader.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            int ev = map.get(c);
            map.put(c, ++ev);
        }
        int nc = map.containsKey('n') ? map.get('n') : 0;
        int rc = map.containsKey('r') ? map.get('r') : 0;
        for (int i = 0; i < nc; i++) {
            printWriter.print(1 + " ");
        }
        for (int i = 0; i < rc; i++) {
            printWriter.print(0 + " ");
        }
        printWriter.flush();
    }
}
