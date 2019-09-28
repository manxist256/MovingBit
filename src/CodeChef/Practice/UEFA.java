package CodeChef.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class UEFA {

    static ReaderWriter rw = new ReaderWriter();
    static Helpers hp = new Helpers();

    private static void solve(boolean multipleTC) throws Exception {
        int T = multipleTC ? rw.ri() : 1;
        while (T-- > 0) {
            String[] strings = new String[12];
            for (int i = 0; i < 12; i++) {
                strings[i] = rw.rs();
            }
            Map<String, Team> teamMap = new TreeMap();
            for (int i = 0; i < 12; i++) {
                String[] s = strings[i].split(" ");
                String t1 = s[0].trim();
                int sc1 = Integer.parseInt(s[1].trim());
                String t2 = s[4].trim();
                int sc2 = Integer.parseInt(s[3].trim());
                if (!teamMap.containsKey(t1)) {
                    teamMap.put(t1, new Team());
                }
                if (!teamMap.containsKey(t2)) {
                    teamMap.put(t2, new Team());
                }
                Team gt1 = teamMap.get(t1);
                Team gt2 = teamMap.get(t2);
                if (sc1 > sc2) {
                    gt1.points += 3;
                } else if (sc2 > sc1) {
                    gt2.points += 3;
                } else {
                    gt1.points += 1;
                    gt2.points += 1;
                }
                gt1.goaldiff += (sc1 - sc2);
                gt2.goaldiff += (sc2 - sc1);
                gt1.teamName = t1;
                gt2.teamName = t2;
            }
            TreeSet<Team> treeSet = new TreeSet<>(new Team());
            for (Map.Entry<String, Team> entry : teamMap.entrySet()) {
                treeSet.add(entry.getValue());
            }
            int k = 2;
            for (Team team : treeSet) {
                rw.printWriter.print(team.teamName + " ");
                --k;
                if (k == 0) {
                    break;
                }
            }
            rw.println("");
        }
    }

    public static void main(String[] args) throws Exception {
        solve(true);
        rw.flush();
    }

    static class Helpers {

        static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

        static long lcm(long a, long b) {
            return (a / gcd(a, b)) * b;
        }

        static <T> HashMap<T, Integer> freqMap(T[] array) {
            HashMap<T, Integer> map = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                if (!map.containsKey(array[i])) {
                    map.put(array[i], 0);
                }
                int ev = map.get(array[i]);
                map.put(array[i], ++ev);
            }
            return map;
        }

    }

    static class ReaderWriter {
        static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        static PrintWriter printWriter = new PrintWriter(System.out);

        protected void flush() throws Exception {
            printWriter.flush();
            printWriter.close();
            bufferedReader.close();
        }

        protected void println(String s) {
            printWriter.println(s);
        }

        protected void println(int i) {
            printWriter.println(i);
        }

        protected void println(long l) {
            printWriter.println(l);
        }

        int ri() throws Exception {
            return Integer.parseInt(bufferedReader.readLine());
        }

        long rl() throws Exception {
            return Long.parseLong(bufferedReader.readLine());
        }

        String rs() throws Exception {
            return bufferedReader.readLine();
        }

        double rd() throws Exception {
            return Double.parseDouble(bufferedReader.readLine());
        }

        int[] ria() throws Exception {
            String[] line = rs().split(" ");
            int[] arr = new int[line.length];
            for (int i = 0; i < line.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            return arr;
        }

        long[] rla() throws Exception {
            String[] line = rs().split(" ");
            long[] arr = new long[line.length];
            for (int i = 0; i < line.length; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }
            return arr;
        }

        int gifs(int[] line, int index) {
            return line[index];
        }

        long glfs(long[] line, int index) {
            return line[index];
        }

        void pia(int[] array) {
            for (int i = 0; i < array.length; i++) {
                printWriter.print(array[i] + " ");
            }
            printWriter.println();
        }

        void pla(long[] array) {
            for (int i = 0; i < array.length; i++) {
                printWriter.print(array[i] + " ");
            }
            printWriter.println();
        }
    }
}

class Team implements Comparator<Team> {
    int points = 0;
    int goaldiff = 0;
    String teamName;

    public int compare(Team t1, Team t2) {
        if (t1.points > t2.points) {
            return -1;
        } else if (t2.points > t1.points) {
            return 1;
        } else {
            if (t1.goaldiff > t2.goaldiff) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
