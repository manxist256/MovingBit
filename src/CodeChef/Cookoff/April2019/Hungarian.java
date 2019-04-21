package CodeChef.Cookoff.April2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hungarian {
    public static void main(String[] args)  throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] strings = bufferedReader.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(strings[j]);
                }
            }
            hc : for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) {
                        continue hc;
                    }
                }
                System.out.println("NO");
                continue outer;
            }
            vc : for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[j][i] == 0) {
                        continue vc;
                    }
                }
                System.out.println("NO");
                continue outer;
            }
            System.out.println("YES");
        }
    }
}
