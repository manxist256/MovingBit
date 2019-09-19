import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ProblemC {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        String s = bufferedReader.readLine();
        int[] arr = new int[26];
        outer : for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                arr[0]++;
                printWriter.println("Mike");
                continue;
            }
            int index = s.charAt(i) - 97;
            for (int j = 0; j < index; j++) {
                if (arr[j] > 0) {
                    printWriter.println("Ann");
                    continue outer;
                }
            }
            arr[index]++;
            printWriter.println("Mike");
        }
        printWriter.flush();
    }
}
