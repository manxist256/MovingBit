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
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author mankank
 */
public class _1Client {
        public static void main(String[] args) throws UnknownHostException, IOException {
                Socket socket = new Socket(InetAddress.getLocalHost(), 2500);
                BufferedReader buff_1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer_1 = new PrintWriter(System.out);
                while (true) {
                        String read = buff_1.readLine();
                        writer_1.println("server says : " + read);
                        writer_1.flush();
                }
        }
}
