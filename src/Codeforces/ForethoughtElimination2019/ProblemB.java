import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        int aC = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                aC++;
            }
        }
        int rC = (s.length() - aC) / 2;
        StringBuilder res = new StringBuilder(""); StringBuilder dm1 = new StringBuilder("");
        for (int i = 0; i < s.length() - rC; i++) {
           res = res.append(s.charAt(i));
           if (s.charAt(i) != 'a') {
               dm1 .append(s.charAt(i));
           }
        }
        StringBuilder dm2 = new StringBuilder("");
        for (int i = s.length() - rC; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                System.out.println(":(");
                return;
            }
            dm2 =dm2.append(s.charAt(i));
        }
        if (!dm1.toString().equals(dm2.toString())) {
            System.out.println(":(");
            return;
        }
        System.out.println(res);
    }
}
