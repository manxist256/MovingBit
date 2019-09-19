import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class KoalaAndLights {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(bufferedReader.readLine());
        String config = bufferedReader.readLine();
        int[] arr = new int[config.length()];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = config.charAt(i) - 48;
        }
        int[] ai = new int[N], bi = new int[N];
        for (int i = 0; i < N; i++) {
            String[] ik = bufferedReader.readLine().split(" ");
            ai[i] = Integer.parseInt(ik[0]);
            bi[i] = Integer.parseInt(ik[1]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int k = arr[i], a = ai[i], b = bi[i];
            int s = 0;
            boolean toggle = k == 1;
            if (toggle) {
                for (int p = 0; p < b; p++) {
                    if (!map.containsKey(p)) {
                        map.put(p, 0);
                    }
                    int ev = map.get(p);
                    map.put(p, ++ev);
                }
            }
            for (int j = b; j <= 1000; j++) {
                if (s % a == 0) {
                    toggle = toggle == true ? false : true;
                }
                if (toggle) {
                    if (!map.containsKey(j)) {
                        map.put(j, 0);
                    }
                    int ev = map.get(b);
                    map.put(j, ++ev);
                }
                s++; b++;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        printWriter.println(max);
        printWriter.flush();
    }
}
