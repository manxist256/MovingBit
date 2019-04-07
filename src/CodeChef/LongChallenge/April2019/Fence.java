import java.util.*;
import java.io.*;

class Fence {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
            for (int i = 0; i < K; i++) {
                String inp[] = br.readLine().split(" ");
                int R = Integer.parseInt(inp[0]), C = Integer.parseInt(inp[1]);
                if (!map.containsKey(R)) {
                    TreeSet newset = new TreeSet();
                    map.put(R, newset);
                }
                TreeSet getset = map.get(R);
                getset.add(C);
            }
            int ans = 0;
            for(Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
                TreeSet set = entry.getValue();
                Iterator itr = set.iterator();
                int R = entry.getKey();
                while (itr.hasNext()) {
                    int C = (int) itr.next();
                    //top
                    if (R == 1) {
                        ans += 1;
                    } else {
                        int k = R - 1;
                        if ((map.containsKey(k) && !map.get(k).contains(C)) || (!map.containsKey(k))) {
                            ans += 1;
                        }
                    }
                    //bottom
                    if (R == N) {
                        ans += 1;
                    } else {
                        int k = R + 1;
                        if ((map.containsKey(k) && !map.get(k).contains(C)) || (!map.containsKey(k))) {
                            ans += 1;
                        }
                    }
                    //left
                    if (C == 1) {
                        ans += 1;
                    } else {
                        int k = C - 1;
                        if (!set.contains(k)) {
                            ans += 1;
                        }
                    }
                    //bottom
                    if (C == M) {
                        ans += 1;
                    } else {
                        int k = C + 1;
                        if (!set.contains(k)) {
                            ans += 1;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
    }

}