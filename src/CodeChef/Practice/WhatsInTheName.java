package CodeChef.Practice;

import java.util.Scanner;

public class WhatsInTheName {

    static char getFNC(char fc) {
        int ascii = (int)fc;
        if (ascii >= 65 && ascii <= 90) {
            return fc;
        } else {
            return (char)(65 + (fc - 97));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T-- > 0) {
            String[] name = scanner.nextLine().split(" ");
            if (name.length == 3) {
                System.out.println(getFNC(name[0].charAt(0)) + ". " + getFNC(name[1].charAt(0)) + ". " + getFNC(name[2].charAt(0)) + name[2].substring(1).toLowerCase());
            }  else if (name.length == 2) {
                System.out.println(getFNC(name[0].charAt(0)) + ". "  + getFNC(name[1].charAt(0)) + name[1].substring(1).toLowerCase());
            } else if (name.length == 1) {
                System.out.println(getFNC(name[0].charAt(0)) + name[0].substring(1).toLowerCase());
            }
        }
    }
}
