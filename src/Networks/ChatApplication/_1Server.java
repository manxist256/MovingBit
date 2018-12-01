/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Networks.ChatApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author mankank
 */
public class _1Server {
        public static void main(String[] args) throws IOException {
                ServerSocket server = new ServerSocket(2500);
                Socket s = server.accept();
                BufferedReader buff_1 = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer_1 = new PrintWriter(s.getOutputStream());
                while (true) {
                        String input = buff_1.readLine();
                        writer_1.println(input);
                        writer_1.flush();
                }
        }
}
