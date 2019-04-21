import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int aC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aC++;
            }
        }
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        if ((s.length() / 2) + 1 <= aC) {
            System.out.println(s.length());
            return;
        }
        System.out.println((aC + (aC - 1)));
    }
}
