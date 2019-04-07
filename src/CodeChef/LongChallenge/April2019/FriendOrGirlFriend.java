import java.util.*;

class FriendOrGirlFriend {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int N = Integer.parseInt(sc.nextLine());
            String[] inp = sc.nextLine().split(" ");
            char x = inp[1].charAt(0); String act = inp[0];
            long local = 0, ans = 0;
            for (int i = 0; i <  act.length(); i++) {
                local++;
                if (x == act.charAt(i)) {
                    ans += ((long)local * (act.length() - i));
                    local = 0;
                }
            }
            System.out.println(ans);
        }
    }

}