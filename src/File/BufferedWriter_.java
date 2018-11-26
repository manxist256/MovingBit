/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author mankank
 */
public class BufferedWriter_ {
        public static void main(String[] args) throws IOException {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                bw.write("hello writer");
                bw.flush();
        }
}
