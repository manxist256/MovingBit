
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
class ChefAndInteractiveXOR {
    
        private static void print(int n1, int n2, int n3, PrintWriter pw) {
                pw.println(1 + " " + n1 + " " + n2 + " " + n3);
                pw.flush();
        }
        
        private static long read(BufferedReader br) throws IOException {
                return Long.parseLong(br.readLine());
        }
    
        private static void computelasttwo(long[] arr, long xor[], int N, PrintWriter pw, BufferedReader br) throws IOException {
                print(1, 2, 3, pw);
                xor[0] = read(br);
                print(2, 3, 4, pw);
                xor[1] = read(br);
                print(1, 4, arr.length, pw);
                xor[2] = read(br);
                print(1, 4, arr.length - 1, pw);
                xor[3] = read(br);
                arr[arr.length - 1] = xor[0] ^ xor[1] ^ xor[2];
                arr[arr.length - 2] = xor[0] ^ xor[1] ^ xor[3];
                //System.out.println(arr[arr.length - 1] + " " + arr[arr.length - 2]);
        }
    
        private static void printresult(long arr[], PrintWriter pw) {
               pw.print(2 + " ");
               for (int i = 0; i < arr.length; i++) {
                    pw.print(arr[i] + " ");
               }
               pw.println();
               pw.flush();
        }
        
        private static void computefirstfour(long[] arr, long[] xor, int N, PrintWriter pw, BufferedReader br) throws IOException {
                if (N % 2 == 0) {
                        print(5, 6, 3, pw); //find 3rd pos
                        arr[2] = arr[4] ^ arr[5] ^ read(br);
                } else {
                        print(5, 7, 3, pw); //find 3nd pos
                        arr[2] = arr[4] ^ arr[6] ^ read(br);   
                }
                print(5, 6, 2, pw); 
                arr[1] = arr[4] ^ arr[5] ^ read(br); //find 2nd pos
                arr[0] = xor[0] ^ arr[1] ^ arr[2]; //find 1st pos
                arr[3] = xor[1] ^ arr[1] ^ arr[2]; //find 4th pos
        }
        
        public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter pw = new PrintWriter(System.out);
                int T = Integer.parseInt(br.readLine());
                while (T-- > 0) {
                        int N = Integer.parseInt(br.readLine());
                        long[] arr = new long[N];
                        long[] xor = new long[N];
                        computelasttwo(arr, xor, N, pw, br);
                        int n1 = N, n2 = N - 1, n3 = N - 2, cntr = 0, xi = 4, pos = arr.length - 3;
                        while (n3 != 4) {
                                print(n1, n2, n3, pw);
                                xor[xi] = read(br);
                                cntr++;
                                if (cntr % 2 != 0) {
                                         arr[pos] = xor[xi] ^ xor[xi - 1] ^ xor[xi - 2];
                                } else if (cntr % 2 == 0) {
                                         arr[pos] = xor[xi] ^ xor[xi - 2] ^ xor[xi - 3];
                                }
                                if (cntr % 2 == 0) {
                                        n1 = n3 + 1;
                                        n2 = n3;
                                        cntr = 0;
                                }
                                n3--; xi++; pos--;
                        }
                        computefirstfour(arr, xor, N, pw, br);
                        printresult(arr, pw);
                        read(br);
                }
        }
}
