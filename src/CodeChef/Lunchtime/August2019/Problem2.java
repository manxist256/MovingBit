package CodeChef.Lunchtime.August2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int T = Integer.parseInt(bufferedReader.readLine());
        outer : while (T--> 0) {
            String string[] = bufferedReader.readLine().split(" ");
            int N = Integer.parseInt(string[0]);
            int K = Integer.parseInt(string[1]);
            String[] plan = bufferedReader.readLine().split(" ");
            int[] arr = new int[plan.length];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(plan[i]);
            }
            if (N == 1) {
                printWriter.println("YES");
                printWriter.println(arr[0] == -1 ? 1 : arr[0]);
                continue;
            }
            if (K >= 3) {
                for (int i = 0; i < N - 1; i++) {
                    if (arr[i] == arr[i + 1] && arr[i] != -1) {
                        printWriter.println("NO");
                        continue outer;
                    }
                }
                printWriter.println("YES");
                for (int i = 0; i < N; i++) {
                    if (i == 0) {
                        if (arr[0] == -1) {
                            if (arr[1] == -1) {
                                arr[0] = 1;
                            } else {
                                if (arr[1] != 2) {
                                    arr[0] = 2;
                                } else {
                                    arr[0] = 1;
                                }
                            }
                        }
                        continue;
                    }
                    if (i == N - 1) {
                        if (arr[i] == -1) {
                            if (arr[i - 1] == 1) {
                                arr[i] = 2;
                            } else {
                                arr[i] = 1;
                            }
                        }
                        continue;
                    }
                    if (arr[i] == -1) {
                        int l = arr[i - 1], r = arr[i + 1];
                        if (1 != l && 1 != r) {
                            arr[i] = 1;
                        } else if (2 != l && 2 != r) {
                            arr[i] = 2;
                        } else {
                            arr[i] = 3;
                        }
                        continue;
                    }
                }
            }
            if (K == 2) {
                int c = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i] == -1) {
                        c++;
                    }
                }
                if (c == N) {
                    printWriter.println("YES");
                    int flip = 0;
                    for (int i = 0; i < N; i++) {
                        if (flip == 0) {
                            printWriter.print(1 + " ");
                            flip = 1;
                        } else {
                            printWriter.print(2 + " ");
                            flip = 0;
                        }
                    }
                    continue;
                } else {
                    int x = 0;
                    for (int i = 0; i < N; i++) {
                        if (arr[i] == -1) {
                            x = i;
                            break;
                        }
                    }
                    for (int i = x; i < N; i++) {
                        if (arr[i] != -1) {
                            int v = arr[i]; int flip = 0;
                            for (int j = i - 1; j >= x; j--) {
                                if (flip == 0) {
                                    arr[j] = v == 2 ? 1 : 2;
                                    flip = 1;
                                } else {
                                    arr[j] = v;
                                    flip = 0;
                                }
                            }
                            x = i + 1;
                        }
                    }
                    int y = 0;
                    for (int i = N - 1; i >= 0; i--) {
                        if (arr[i] != -1) {
                            y = i;
                            break;
                        }
                    }
                    int v = arr[y]; int flip = 0;
                    for (int k = y + 1; k < N; k++) {
                        if (flip == 0) {
                            arr[k] = v == 2 ? 1 : 2;
                            flip = 1;
                        } else {
                            arr[k] = v;
                            flip = 0;
                        }
                    }
                    for (int i = 0; i < N - 1; i++) {
                        if (arr[i] == arr[i + 1] && arr[i] != -1) {
                            printWriter.println("NO");
                            continue outer;
                        }
                    }
                    printWriter.println("YES");
                }
            }
            for (int i = 0; i < N; i++) {
                printWriter.print(arr[i] + " ");
            }
            printWriter.println();
        }
        printWriter.flush();
    }
}
