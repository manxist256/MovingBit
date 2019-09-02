package CodeChef.Practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    long marks;
    int pos;
    public Student(long marks, int pos) {
        this.marks = marks;
        this.pos = pos;
    }
    public long getMarks() {
        return this.marks;
    }
}

public class EntranceXam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        outer : while (T-- > 0) {
            int N = scanner.nextInt(), K = scanner.nextInt(), E = scanner.nextInt(), M = scanner.nextInt();
            Student[] arr = new Student[N];
            for (int i = 0; i < N; i++) {
                long total = 0;
                for (int j = 0; j < (i != N - 1 ? E : E - 1); j++) {
                    total += scanner.nextInt();
                }
                arr[i] = new Student(total, i);
            }
            Arrays.sort(arr, Comparator.comparing(Student::getMarks, Comparator.reverseOrder()));
            int currPos = 0; long hisM = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i].pos == N - 1) {
                    currPos = i + 1;
                    hisM = arr[i].marks;
                    break;
                }
            }
            if (currPos <= K) {
                System.out.println(0);
            } else {
                long b = arr[K - 1].getMarks();
                long ts = (b - hisM) + 1;
                System.out.println(ts <= M ? ts : "Impossible");
            }
        }
    }
}
