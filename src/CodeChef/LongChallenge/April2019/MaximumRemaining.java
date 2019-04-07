import java.util.*;

class MaximumRemaining {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int max = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] != max) {
                System.out.println(arr[i]);
                return;
            }
        }

        System.out.println(0);

    }

}