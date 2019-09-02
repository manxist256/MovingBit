package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class ChefDetective {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(bufferedReader.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            treeSet.add(i);
        }
        String[] strings = bufferedReader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(strings[i]);
            if (v != 0) {
                treeSet.remove(v);
            }
        }
        for (Integer integer : treeSet) {
            printWriter.print(integer + " ");
        }
        printWriter.flush();
    }
}
