package CodeChef.MoscowWorkshopsJunior2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] xa = bufferedReader.readLine().split(" ");
        int a[] = new int[n];
        for (int i = 0; i < xa.length; i++) {
            a[i] = Integer.parseInt(xa[i]);
        }
        int l = 0, r = n - 1;
        StringBuilder builder = new StringBuilder("");
        int mp = 0;
        while (l != r) {
            if (a[l] < mp && a[r] < mp) {
                break;
            }
            int pick = pick(mp, a[l], a[r]);
            mp = pick;
            if (pick == a[l]) {
                builder.append("L");
                l++;
            } else if (pick == a[r]) {
                builder.append("R");
                r--;
            }
        }
        if (l == r && a[l] > mp) builder.append("R");
        System.out.println(builder.toString().length());
        System.out.println(builder.toString());
    }
    public static int pick(int mp, int al, int ar) {
        if (al > mp && ar > mp) {
            return al < ar ? al : ar;
        } else if (al > mp) {
            return al;
        } else {
            return ar;
        }
    }
}
