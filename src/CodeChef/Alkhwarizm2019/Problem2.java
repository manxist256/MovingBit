package CodeChef.Alkhwarizm2019;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        long modder = 1000000007l;
        //System.out.println(modder);
        //long edge = (long)Math.pow(2, n + 1) - 2;
        BigInteger edge = new BigInteger(((long)Math.pow(2, n + 1) - 2 ) + "");
        //long left = n + 1, right = left, top = 1, bottom = (long)Math.pow(2, n);
        BigInteger left = new BigInteger(n + 1 + "");
        BigInteger right = new BigInteger(n + 1 + "");
        BigInteger top = new BigInteger("1");
        BigInteger bottom = new BigInteger((long)Math.pow(2, n) + "");
        //System.out.println(bottom);
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            if (a == 1) {
                int b = scanner.nextInt();
                switch(b) {
                    case 1 : //right
                        edge = edge.multiply(BigInteger.valueOf(2));
                        edge = edge.add(right);
                        top = top.multiply(BigInteger.valueOf(2));
                        bottom = bottom.multiply(BigInteger.valueOf(2));
                        break;
                    case 2 : //left
                        edge = edge.multiply(BigInteger.valueOf(2));
                        edge = edge.add(left);
                        top = top.multiply(BigInteger.valueOf(2));
                        bottom = bottom.multiply(BigInteger.valueOf(2));
                        break;
                    case 3 : //top
                        edge = edge.multiply(BigInteger.valueOf(2));
                        edge = edge.add(top);
                        left = left.multiply(BigInteger.valueOf(2));
                        right = right.multiply(BigInteger.valueOf(2));
                        top = bottom;
                        break;
                    case 4 : //bottom
                        edge = edge.multiply(BigInteger.valueOf(2));
                        edge = edge.add(bottom);
                        left = left.multiply(BigInteger.valueOf(2));
                        right = right.multiply(BigInteger.valueOf(2));
                        bottom = top;
                        break;
                }
            } else {
                System.out.println(edge.mod(BigInteger.valueOf(modder))) ;
            }
        }
    }
}
