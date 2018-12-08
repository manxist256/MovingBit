
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package CodeChef.LongChallenge.December2018;

/**
 *
 * @author mankank
 */
class MaxAndElectricPanel {
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(System.out);
                String[] input = br.readLine().split(" ");
                int N = Integer.parseInt(input[0]);
                int c = Integer.parseInt(input[1]);
                int t1 = -1, t2 = -1; int read = 0;
                for (int i = 1; i <= 150001 ; i += 1000) { // binary search in range 1000
                        if (i > N) {
                                t1 = i - 1000;
                                t2 = i;
                                break;
                        }
                        pw.println(1 + " " + i);
                        pw.flush();
                        read = Integer.parseInt(br.readLine());
                        if (read == 1) {
                                t1 = i - 1000;
                                t2 = i;
                                break;
                        }
                }
                if (t2 == 1) { // it broke in x = 1
                        if (read == 1)
                                pw.println(2);
                        pw.println(3 + " " + 1);
                        pw.flush();
                } else { // binary search in range 100
                        if (read == 1)
                                pw.println(2);
                        pw.flush();
                        int t3 = -1, t4 = -1;
                        for (int i = t1; i <= t2; i += 100) {
                                if (i > N) {
                                        t3 = i - 100;
                                        t4 = i;
                                        break;
                                }
                                pw.println(1 + " " + i);
                                pw.flush();
                                read = Integer.parseInt(br.readLine());
                                if (read == 1) {
                                        t3 = i - 100;
                                        t4 = i;
                                        break;
                                }
                        }
                        if (t4 == t1) { //it broke in x = t1
                                if (read == 1)
                                        pw.println(2);
                                pw.println(3 + " " + t1);
                                pw.flush();
                        } else {
                                if (read == 1)
                                        pw.println(2);
                                pw.flush();
                                for (int i = t3; i <= t4; i++) { //iterative search on 100's with 1 increment
                                        pw.println(1 + " " + i);
                                        pw.flush();
                                        read = Integer.parseInt(br.readLine());
                                        if (read == 1) {
                                                pw.println(2);
                                                pw.println(3 + " " + i);
                                                pw.flush();
                                                break;
                                        }
                                }
                        }
                }
        }
}
