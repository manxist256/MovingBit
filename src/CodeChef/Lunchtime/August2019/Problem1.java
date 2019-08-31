package CodeChef.Lunchtime.August2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class C {
    int Age;
    int money;
    public C(int age, int money) {
        this.Age = age;
        this.money = money;
    }
    public int getAge() {
        return Age;
    }
}

public class Problem1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T-- > 0) {
            String[] strings = bufferedReader.readLine().split(" ");
            int A1 = Integer.parseInt(strings[0]);
            int A2 = Integer.parseInt(strings[1]);
            int A3 = Integer.parseInt(strings[2]);
            int C1 = Integer.parseInt(strings[3]);
            int C2 = Integer.parseInt(strings[4]);
            int C3 = Integer.parseInt(strings[5]);
            C c1 = new C(A1, C1);
            C c2 = new C(A2, C2);
            C c3 = new C(A3, C3);
            ArrayList<C> arrayList = new ArrayList();
            arrayList.add(c1);
            arrayList.add(c2);
            arrayList.add(c3);
            Collections.sort(arrayList, Comparator.comparing(C::getAge, Comparator.reverseOrder()));
            for (int i = 0; i < arrayList.size() - 1; i++) {
                C x1 = arrayList.get(i);
                C x2 = arrayList.get(i+1);
                if (x1.getAge() == x2.getAge()) {
                    if (!(x1.money == x2.money)) {
                        System.out.println("NOT FAIR");
                        continue outer;
                    }
                } else {
                    if (!(x1.money > x2.money)) {
                        System.out.println("NOT FAIR");
                        continue outer;
                    }
                }
            }
            System.out.println("FAIR");
        }
    }
}
