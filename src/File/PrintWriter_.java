/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mankank
 */
public class PrintWriter_ {
        public static void main(String[] args) throws IOException {
                PrintWriter pw = new PrintWriter(System.out);
                pw.print("hello_console");
                pw.flush();
                PrintWriter out = new PrintWriter(new FileWriter("a.txt", true));
                out.println("hello_mankank"); 
                out.flush();
        }
}
