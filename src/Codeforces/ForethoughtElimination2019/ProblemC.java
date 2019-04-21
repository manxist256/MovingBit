import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProblemC {
    public static void main(String[] args) throws IOException  {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(bufferedReader.readLine());
            long max = 0l;
            ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
            ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
            int mid = N / 2;
            ArrayList<Integer> s1 = new ArrayList<>();
            for (int i = 1; i <= mid; i++) {
                s1.add(i);
            }
            ArrayList<Integer> s2 = new ArrayList<>();
            for (int i = mid + 1; i <= N; i++) {
                s2.add(i);
            }
            list1.add(s1); list2.add(s2);
            boolean r = false;
            int tp = 8;
            do {
                if (r) {
                    ArrayList<ArrayList<Integer>> list3 = new ArrayList<>();
                    ArrayList<ArrayList<Integer>> list4 = new ArrayList<>();
                    for (ArrayList<Integer> sets : list1) {
                       int l = sets.size(), m = l / 2;
                       ArrayList<Integer> p1 = new ArrayList<>();
                       ArrayList<Integer> p2 = new ArrayList<>();
                       for (int i = 0; i < m; i++) {
                           p1.add(sets.get(i));
                       }
                       for (int i = m; i < l; i++) {
                           p2.add(sets.get(i));
                       }
                       list3.add(p1);
                       list4.add(p2);
                    }
                    for (ArrayList<Integer> sets : list2) {
                        int l = sets.size(), m = l / 2;
                        ArrayList<Integer> p1 = new ArrayList<>();
                        ArrayList<Integer> p2 = new ArrayList<>();
                        for (int i = 0; i < m; i++) {
                            p1.add(sets.get(i));
                        }
                        for (int i = m; i < l; i++) {
                            p2.add(sets.get(i));
                        }
                        list3.add(p1);
                        list4.add(p2);
                    }
                    list1 = list3;
                    list2 = list4;
                }
                int k1 = 0, k2 = 0;
                for (ArrayList<Integer> sets : list1) {
                    k1 += sets.size();
                }
                for (ArrayList<Integer> sets : list2) {
                    k2 += sets.size();
                }
                if (k1 == 0 || k2 == 0) {
                    break;
                }
                writer.print(k1 + " " + k2 + " ");
                for (ArrayList<Integer> sets : list1) {
                    for (Integer integer : sets) {
                        writer.print(integer + " ");
                    }
                }
                for (ArrayList<Integer> sets : list2) {
                    for (Integer integer : sets) {
                        writer.print(integer + " ");
                    }
                }
                writer.println();
                writer.flush();
                long read = Integer.parseInt(bufferedReader.readLine());
                if (read > max) {
                    max = read;
                }
                r = true;
            } while(tp-- > 0);
            System.out.println(-1 + " " + max);
        }
    }
}
