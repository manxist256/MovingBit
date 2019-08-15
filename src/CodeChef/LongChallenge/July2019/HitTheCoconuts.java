package CodeChef.LongChallenge.July2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class HitTheCoconuts {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            String[] NZ = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(NZ[0]), Z = Integer.parseInt(NZ[1]);
            //N = number of coco and Z = needs breaking
            String[] A = bufferedReader.readLine().split(" ");
            Integer[] CB = new Integer[A.length];
            for (int i = 0; i < A.length; i++) {
                CB[i] = Integer.parseInt(A[i]);
            }
            Arrays.sort(CB);
            Integer[] CBDup = new Integer[A.length];
            HashMap<Integer, Integer> dupc = new HashMap<>();

            for (int i = CB.length - 1; i >= 0; i--) {
                if (!dupc.containsKey(CB[i])) {
                    dupc.put(CB[i], 1);
                    CBDup[i] = 0;
                } else {
                    CBDup[i] = dupc.get(CB[i]);
                    int c = CBDup[i];
                    dupc.put(CB[i], ++c);
                }
            }

            int benchIndex = Z - 1, benchData = CB[benchIndex];

            long total = 0;

            for (int i = CB.length - 1; i >= 0; i--) {
                int value = CB[i];

                if (benchData == value) {
                    total += value;
                    benchIndex--;
                    if (benchIndex == -1) {
                        break;
                    }
                    benchData = CB[benchIndex];
                } else {

                    int ver = value - benchData;
                     /*(i - (benchIndex + CBDup[benchIndex])) * benchData*/;
                    int horz = findMinimum(CB, i - 1, benchIndex, benchData);
                    if (ver < horz) {
                        total += value;
                        benchIndex--;
                        if (benchIndex == -1) {
                            break;
                        }
                        benchData = CB[benchIndex];
                    } else {
                        total += benchData;
                    }
                }
            }
            System.out.println(total);
        }
    }

    static int findMinimum(Integer[] CB, int s, int e, int benchData) {
        int k = 0, min = Integer.MAX_VALUE;
        for (int i = s; i >= e; i--) {
            int value = CB[i] + (k * benchData);
            k++;
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

}

//6
//10 3
//100 90 85 75 65 50 40 30 2 1
//117
//2 1
//50 55
//55
//2 1
//40 100
//80
//4 3
//35 30 2 1
//40
