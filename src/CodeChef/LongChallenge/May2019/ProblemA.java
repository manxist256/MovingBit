package CodeChef.LongChallenge.May2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/*
*
*
19 2432902008176639999 146326063
17 6402373705727999 660911388
14 1307674367999 674358850
13 87178291199 178290590
* */
/*
* 19
10 39916799
19 6473608599
17 3701246340
14 7674367089
11 479001599
5
719*/

public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        long mod = (long)10e9 + 7;
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            ArrayList<Long> arrayList = new ArrayList<>();
            for (int i = N; i >= 1; i--) {
                arrayList.add((long)i);
            }
            while (arrayList.size() != 1) {
                long n1 = arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                long n2 = arrayList.get(arrayList.size() - 1);
                arrayList.remove(arrayList.size() - 1);
                long n3 = ((n1 + n2) + ((n1*n2)%mod));
                arrayList.add(n3);
            }
            System.out.println(arrayList.get(0) % mod);
        }
    }
}
